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
package org.primefaces.metadata;

import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import org.primefaces.config.ConfigContainer;
import org.primefaces.context.RequestContext;

public class ComponentMetadataTransformerListener implements SystemEventListener {

    public void processEvent(SystemEvent event) throws AbortProcessingException {
        try {
            if (event instanceof PostAddToViewEvent) {
                PostAddToViewEvent postAddToViewEvent = (PostAddToViewEvent) event;
                
                FacesContext context = FacesContext.getCurrentInstance();

                if (!context.isPostback()) {
                    RequestContext requestContext = RequestContext.getCurrentInstance();
                    ConfigContainer config = requestContext.getApplicationContext().getConfig();
                    
                    if (config.isTransformMetadataEnabled() && config.isBeanValidationAvailable()) {
                        BeanValidationComponentMetadataTransformer.getInstance().transform(context, requestContext, postAddToViewEvent.getComponent());
                    }
                }
            }
        }
        catch (IOException e) {
            throw new FacesException(e);
        }
    }

    public boolean isListenerForSource(Object source) {
        return source instanceof UIComponent;
    }
    
}
