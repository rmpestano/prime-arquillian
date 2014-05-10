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
package org.primefaces.application;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.StreamedContent;
import org.primefaces.util.Constants;
import org.primefaces.util.StringEncrypter;

public class PrimeResourceHandler extends ResourceHandlerWrapper {
    
    private final static Logger logger = Logger.getLogger(PrimeResourceHandler.class.getName());
        
    private ResourceHandler wrapped;

    public PrimeResourceHandler(ResourceHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ResourceHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public Resource createResource(String resourceName, String libraryName) {
        Resource resource = super.createResource(resourceName, libraryName);
        
        if(resource != null && libraryName != null && libraryName.equalsIgnoreCase(Constants.LIBRARY)) {
            return new PrimeResource(resource);
        }
        else {
            return resource;
        }
    }
    
    @Override
    public void handleResourceRequest(FacesContext context) throws IOException {
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String library = params.get("ln");
        String dynamicContentId = (String) params.get(Constants.DYNAMIC_CONTENT_PARAM);
        StringEncrypter strEn = RequestContext.getCurrentInstance().getEncrypter();
        
        if(dynamicContentId != null && library != null && library.equals(Constants.LIBRARY)) {
            StreamedContent streamedContent = null;
            boolean cache = Boolean.valueOf(params.get(Constants.DYNAMIC_CONTENT_CACHE_PARAM));
            
            try {
                String dynamicContentEL = strEn.decrypt(dynamicContentId);                
                ExternalContext externalContext = context.getExternalContext();
                 
                if(dynamicContentEL != null) {
                    ELContext eLContext = context.getELContext();
                    ValueExpression ve = context.getApplication().getExpressionFactory().createValueExpression(context.getELContext(), dynamicContentEL, StreamedContent.class);
                    streamedContent = (StreamedContent) ve.getValue(eLContext);

                    externalContext.setResponseStatus(200);
                    externalContext.setResponseContentType(streamedContent.getContentType());
                    
                    if(cache) {
                        DateFormat httpDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
                        httpDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, 1);
                        externalContext.setResponseHeader("Cache-Control", "max-age=29030400");
                        externalContext.setResponseHeader("Expires", httpDateFormat.format(calendar.getTime()));
                    }
                    else {
                        externalContext.setResponseHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                        externalContext.setResponseHeader("Pragma", "no-cache");
                        externalContext.setResponseHeader("Expires", "Mon, 8 Aug 1980 10:00:00 GMT");
                    }
                    
                    if(streamedContent.getContentEncoding() != null) {
                        externalContext.setResponseHeader("Content-Encoding", streamedContent.getContentEncoding());
                    }

                    byte[] buffer = new byte[2048];

                    int length;
                    InputStream inputStream = streamedContent.getStream();
                    while ((length = (inputStream.read(buffer))) >= 0) {
                        externalContext.getResponseOutputStream().write(buffer, 0, length);
                    }
                }

                externalContext.responseFlushBuffer();
                context.responseComplete();

            } catch(Exception e) {
                logger.log(Level.SEVERE, "Error in streaming dynamic resource. {0}", new Object[]{e.getMessage()});
                throw new IOException(e);
            }
            finally {
                //cleanup
                if(streamedContent != null) {
                    streamedContent.getStream().close();
                }
            }
        }
        else {
           super.handleResourceRequest(context); 
        }
    }
}
