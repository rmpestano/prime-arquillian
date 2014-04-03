/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import javax.el.ValueExpression;
import javax.faces.application.Resource;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.el.ValueExpressionAnalyzer;
import org.primefaces.model.StreamedContent;

public class DynamicResourceBuilder {
    
    private static final String SB_BUILD = DynamicResourceBuilder.class.getName() + "#build";
    
    public static String build(FacesContext context, Object value, UIComponent component, boolean cache) throws UnsupportedEncodingException {
        String src = null;
            
        if (value == null) {
            return "";
        }
        else if (value instanceof String) {
            src = ComponentUtils.getResourceURL(context, (String) value);
        }
        else if (value instanceof StreamedContent) {
            StreamedContent streamedContent = (StreamedContent) value;
            Resource resource = context.getApplication().getResourceHandler().createResource("dynamiccontent.properties", "primefaces", streamedContent.getContentType());
            String resourcePath = resource.getRequestPath();
            StringEncrypter encrypter = RequestContext.getCurrentInstance().getEncrypter();

            ValueExpression expression = ValueExpressionAnalyzer.getExpression(context.getELContext(), component.getValueExpression("value"));
            String rid = encrypter.encrypt(expression.getExpressionString());

            StringBuilder builder = SharedStringBuilder.get(context, SB_BUILD);

            builder.append(resourcePath).append("&").append(Constants.DYNAMIC_CONTENT_PARAM).append("=").append(URLEncoder.encode(rid,"UTF-8"));

            for (UIComponent kid : component.getChildren()) {
                if (kid instanceof UIParameter) {
                    UIParameter param = (UIParameter) kid;
                    Object paramValue = param.getValue();

                    builder.append("&").append(param.getName()).append("=");

                    if (paramValue != null) {
                        builder.append(URLEncoder.encode(param.getValue().toString(), "UTF-8"));
                    }
                }
            }

            src = builder.toString();
        }

        if (src != null) {
            src += src.contains("?") ? "&" : "?";
            src += Constants.DYNAMIC_CONTENT_CACHE_PARAM + "=" + cache;

            if (!cache) {
                src += "&uid=" + UUID.randomUUID().toString();
            }
        }

        return context.getExternalContext().encodeResourceURL(src);
    }
}
