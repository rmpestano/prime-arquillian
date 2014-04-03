/*
 * Generated, Do Not Modify
 */
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
package org.primefaces.component.fileupload;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.component.UINamingContainer;
import javax.el.ValueExpression;
import javax.el.MethodExpression;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import java.util.List;
import java.util.ArrayList;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="primefaces.css"),
	@ResourceDependency(library="primefaces", name="fileupload/fileupload.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js"),
	@ResourceDependency(library="primefaces", name="fileupload/fileupload.js")
})
public class FileUpload extends UIInput implements org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.component.FileUpload";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.FileUploadRenderer";

	protected enum PropertyKeys {

		widgetVar
		,style
		,styleClass
		,update
		,process
		,fileUploadListener
		,multiple
		,auto
		,label
		,allowTypes
		,fileLimit
		,sizeLimit
		,mode
		,uploadLabel
		,cancelLabel
		,invalidSizeMessage
		,invalidFileMessage
		,fileLimitMessage
		,dragDropSupport
		,onstart
		,oncomplete
		,onerror
		,disabled
		,messageTemplate
		,previewWidth;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public FileUpload() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public java.lang.String getWidgetVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}
	public void setWidgetVar(java.lang.String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}

	public java.lang.String getStyle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.style, null);
	}
	public void setStyle(java.lang.String _style) {
		getStateHelper().put(PropertyKeys.style, _style);
	}

	public java.lang.String getStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.styleClass, null);
	}
	public void setStyleClass(java.lang.String _styleClass) {
		getStateHelper().put(PropertyKeys.styleClass, _styleClass);
	}

	public java.lang.String getUpdate() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.update, null);
	}
	public void setUpdate(java.lang.String _update) {
		getStateHelper().put(PropertyKeys.update, _update);
	}

	public java.lang.String getProcess() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.process, null);
	}
	public void setProcess(java.lang.String _process) {
		getStateHelper().put(PropertyKeys.process, _process);
	}

	public javax.el.MethodExpression getFileUploadListener() {
		return (javax.el.MethodExpression) getStateHelper().eval(PropertyKeys.fileUploadListener, null);
	}
	public void setFileUploadListener(javax.el.MethodExpression _fileUploadListener) {
		getStateHelper().put(PropertyKeys.fileUploadListener, _fileUploadListener);
	}

	public boolean isMultiple() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.multiple, false);
	}
	public void setMultiple(boolean _multiple) {
		getStateHelper().put(PropertyKeys.multiple, _multiple);
	}

	public boolean isAuto() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.auto, false);
	}
	public void setAuto(boolean _auto) {
		getStateHelper().put(PropertyKeys.auto, _auto);
	}

	public java.lang.String getLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.label, "Choose");
	}
	public void setLabel(java.lang.String _label) {
		getStateHelper().put(PropertyKeys.label, _label);
	}

	public java.lang.String getAllowTypes() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.allowTypes, null);
	}
	public void setAllowTypes(java.lang.String _allowTypes) {
		getStateHelper().put(PropertyKeys.allowTypes, _allowTypes);
	}

	public int getFileLimit() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.fileLimit, java.lang.Integer.MAX_VALUE);
	}
	public void setFileLimit(int _fileLimit) {
		getStateHelper().put(PropertyKeys.fileLimit, _fileLimit);
	}

	public java.lang.Long getSizeLimit() {
		return (java.lang.Long) getStateHelper().eval(PropertyKeys.sizeLimit, java.lang.Long.MAX_VALUE);
	}
	public void setSizeLimit(java.lang.Long _sizeLimit) {
		getStateHelper().put(PropertyKeys.sizeLimit, _sizeLimit);
	}

	public java.lang.String getMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.mode, "advanced");
	}
	public void setMode(java.lang.String _mode) {
		getStateHelper().put(PropertyKeys.mode, _mode);
	}

	public java.lang.String getUploadLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.uploadLabel, "Upload");
	}
	public void setUploadLabel(java.lang.String _uploadLabel) {
		getStateHelper().put(PropertyKeys.uploadLabel, _uploadLabel);
	}

	public java.lang.String getCancelLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.cancelLabel, "Cancel");
	}
	public void setCancelLabel(java.lang.String _cancelLabel) {
		getStateHelper().put(PropertyKeys.cancelLabel, _cancelLabel);
	}

	public java.lang.String getInvalidSizeMessage() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.invalidSizeMessage, null);
	}
	public void setInvalidSizeMessage(java.lang.String _invalidSizeMessage) {
		getStateHelper().put(PropertyKeys.invalidSizeMessage, _invalidSizeMessage);
	}

	public java.lang.String getInvalidFileMessage() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.invalidFileMessage, null);
	}
	public void setInvalidFileMessage(java.lang.String _invalidFileMessage) {
		getStateHelper().put(PropertyKeys.invalidFileMessage, _invalidFileMessage);
	}

	public java.lang.String getFileLimitMessage() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.fileLimitMessage, null);
	}
	public void setFileLimitMessage(java.lang.String _fileLimitMessage) {
		getStateHelper().put(PropertyKeys.fileLimitMessage, _fileLimitMessage);
	}

	public boolean isDragDropSupport() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.dragDropSupport, true);
	}
	public void setDragDropSupport(boolean _dragDropSupport) {
		getStateHelper().put(PropertyKeys.dragDropSupport, _dragDropSupport);
	}

	public java.lang.String getOnstart() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onstart, null);
	}
	public void setOnstart(java.lang.String _onstart) {
		getStateHelper().put(PropertyKeys.onstart, _onstart);
	}

	public java.lang.String getOncomplete() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.oncomplete, null);
	}
	public void setOncomplete(java.lang.String _oncomplete) {
		getStateHelper().put(PropertyKeys.oncomplete, _oncomplete);
	}

	public java.lang.String getOnerror() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onerror, null);
	}
	public void setOnerror(java.lang.String _onerror) {
		getStateHelper().put(PropertyKeys.onerror, _onerror);
	}

	public boolean isDisabled() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.disabled, false);
	}
	public void setDisabled(boolean _disabled) {
		getStateHelper().put(PropertyKeys.disabled, _disabled);
	}

	public java.lang.String getMessageTemplate() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.messageTemplate, null);
	}
	public void setMessageTemplate(java.lang.String _messageTemplate) {
		getStateHelper().put(PropertyKeys.messageTemplate, _messageTemplate);
	}

	public int getPreviewWidth() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.previewWidth, 80);
	}
	public void setPreviewWidth(int _previewWidth) {
		getStateHelper().put(PropertyKeys.previewWidth, _previewWidth);
	}


    public final static String CONTAINER_CLASS = "ui-fileupload ui-widget";
    public final static String BUTTON_BAR_CLASS = "ui-fileupload-buttonbar ui-widget-header ui-corner-top";
    public final static String CONTENT_CLASS = "ui-fileupload-content ui-widget-content ui-corner-bottom";
    public final static String FILES_CLASS = "ui-fileupload-files";
    public final static String CHOOSE_BUTTON_CLASS = "ui-fileupload-choose";
    public final static String UPLOAD_BUTTON_CLASS = "ui-fileupload-upload";
    public final static String CANCEL_BUTTON_CLASS = "ui-fileupload-cancel";
    
    public final static String MOBILE_CONTAINER_CLASS = "ui-fileupload ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset";

    public void broadcast(javax.faces.event.FacesEvent event) throws javax.faces.event.AbortProcessingException {
		super.broadcast(event);
		
		FacesContext facesContext = getFacesContext();
		MethodExpression me = getFileUploadListener();
		
		if (me != null && event instanceof org.primefaces.event.FileUploadEvent) {
			me.invoke(facesContext.getELContext(), new Object[] {event});
		}
	}
	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if(userWidgetVar != null)
			return userWidgetVar;
		 else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}
}