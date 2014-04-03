/*
 * Copyright 2009-2013 PrimeTek.
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
package org.primefaces.component.photocam;

import java.io.IOException;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.PhaseId;
import javax.xml.bind.DatatypeConverter;
import org.primefaces.event.CaptureEvent;
import org.primefaces.expression.SearchExpressionFacade;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.AgentUtils;
import org.primefaces.util.WidgetBuilder;

public class PhotoCamRenderer extends CoreRenderer {
    
    @Override
	public void decode(FacesContext context, UIComponent component) {
		PhotoCam cam = (PhotoCam) component;
        String clientId = cam.getClientId(context);
		Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        
        if(params.containsKey(clientId)) {
            String image = params.get(clientId);
            image = image.substring(22);
            
            CaptureEvent event = new CaptureEvent(cam, DatatypeConverter.parseBase64Binary(image), image);
            event.setPhaseId(PhaseId.INVOKE_APPLICATION);
            
            cam.queueEvent(event);
        }
	}
    
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(!AgentUtils.isIE(context)) {
            PhotoCam cam = (PhotoCam) component;

            encodeMarkup(context, cam);
            encodeScript(context, cam);
        }
	}

    protected void encodeMarkup(FacesContext context, PhotoCam cam) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
        String clientId = cam.getClientId(context);
        
        writer.startElement("div", null);
        writer.writeAttribute("id", clientId, null);
        if(cam.getStyle() != null) writer.writeAttribute("style", cam.getStyle(), null);
        if(cam.getStyleClass() != null) writer.writeAttribute("class", cam.getStyleClass(), null);
        
        writer.endElement("div");
    }
    
    protected void encodeScript(FacesContext context, PhotoCam cam) throws IOException {
		String clientId = cam.getClientId(context);
        String camera = getResourceRequestPath(context, "photocam/photocam.swf");
        
        WidgetBuilder wb = getWidgetBuilder(context);
        wb.initWithDomReady("PhotoCam", cam.resolveWidgetVar(), clientId)
            .attr("camera", camera);
        
        if(cam.getUpdate() != null) wb.attr("update", SearchExpressionFacade.resolveComponentsForClient(context, cam, cam.getUpdate()));
        if(cam.getProcess() != null) wb.attr("process", SearchExpressionFacade.resolveComponentsForClient(context, cam, cam.getProcess()));

       wb.finish();
	}
    
}
