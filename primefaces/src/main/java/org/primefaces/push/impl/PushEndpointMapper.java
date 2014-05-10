/*
 * Copyright 2013 Jeanfrancois Arcand
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.primefaces.push.impl;

import org.atmosphere.config.service.EndpointMapperService;
import org.atmosphere.cpr.AtmosphereConfig;
import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.FrameworkConfig;
import org.atmosphere.util.DefaultEndpointMapper;
import org.atmosphere.util.IOUtils;
import org.primefaces.push.DefaultPushRule;
import org.primefaces.push.PrimeAtmosphereHandler;
import org.primefaces.push.PushRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EndpointMapperService
public class PushEndpointMapper<U> extends DefaultEndpointMapper<U> {
    private final Logger logger = LoggerFactory.getLogger(PushEndpointMapper.class.getName());

    private String servletPath = "";
    private AtmosphereConfig config;
    public final static String RULES = "org.primefaces.push.rules";

    @Override
    public void configure(AtmosphereConfig config) {
        servletPath = IOUtils.guestServletPath(config);
        config.framework().getAtmosphereConfig().properties().put("servletPath", servletPath);
        this.config = config;
    }

    public String computePath(AtmosphereRequest req) {
        String path;
        String pathInfo = null;
        try {
            pathInfo = req.getPathInfo();
        } catch (IllegalStateException ex) {
            // http://java.net/jira/browse/GRIZZLY-1301
        }

        if (pathInfo != null) {
            path = req.getServletPath() + pathInfo;
        } else {
            path = req.getServletPath();
        }

        if (path == null || path.isEmpty()) {
            path = "/";
        }

        if (servletPath != null && path.startsWith(servletPath)) {
            path = path.substring(servletPath.length());
        }

        return path;
    }

    @Override
    public U map(AtmosphereRequest req, Map<String, U> handlers) {
        String path = computePath(req);

        if (path == null || path.isEmpty()) {
            path = "/";
        }

        U handler = match(path, handlers);
        if (handler == null) {
            // (2) First, try exact match
            handler = match(path + (path.endsWith("/") ? "all" : "/all"), handlers);

            if (handler == null) {
                // (3) Wildcard
                handler = match(path + "*", handlers);

                // (4) try without a path
                if (handler == null) {
                    String p = path.lastIndexOf("/") <= 0 ? "/" : path.substring(0, path.lastIndexOf("/"));
                    while (p.length() > 0 && p.indexOf("/") != -1) {
                        handler = match(p, handlers);

                        // (3.1) Try path wildcard
                        if (handler != null) {
                            break;
                        }
                        p = p.substring(0, p.lastIndexOf("/"));
                    }
                }
            }
        }

        if (handler == null) {
            synchronized (config) {
                logger.trace("Preserving backward PrimeFaces behavior");
                PrimeAtmosphereHandler pah = new PrimeAtmosphereHandler(configureRules(config.getServletConfig()));
                path = computePath(req);
                config.framework().addAtmosphereHandler(path, pah);
                handler = (U) config.framework().getAtmosphereHandlers().get(path);
            }
        }

        req.setAttribute(FrameworkConfig.MAPPED_PATH, path);
        return handler;
    }

    List<PushRule> configureRules(ServletConfig sc) {
        List<PushRule> rules = new ArrayList<PushRule>();

        String s = sc.getInitParameter(RULES);

        if (s != null) {
            String[] r = s.split(",");
            for (String rule : r) {
                try {
                    rules.add(((Class<PushRule>) IOUtils.loadClass(getClass(), rule)).newInstance());
                    logger.info("PushRule {} loaded", rule);
                } catch (Throwable t) {
                    logger.info("Unable to load PushRule {}", rule, t);
                }
            }
        }

        if (rules.isEmpty()) {
            rules.add(new DefaultPushRule());
        }

        return rules;
    }

}
