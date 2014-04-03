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
package org.primefaces.component.datascroller;

import org.primefaces.component.api.UIData;
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
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class DataScroller extends UIData implements org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.component.DataScroller";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.DataScrollerRenderer";

	protected enum PropertyKeys {

		widgetVar
		,style
		,styleClass
		,chunkSize
		,mode
		,scrollHeight
		,buffer;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public DataScroller() {
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

	public int getChunkSize() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.chunkSize, 0);
	}
	public void setChunkSize(int _chunkSize) {
		getStateHelper().put(PropertyKeys.chunkSize, _chunkSize);
	}

	public java.lang.String getMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.mode, "document");
	}
	public void setMode(java.lang.String _mode) {
		getStateHelper().put(PropertyKeys.mode, _mode);
	}

	public java.lang.String getScrollHeight() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.scrollHeight, null);
	}
	public void setScrollHeight(java.lang.String _scrollHeight) {
		getStateHelper().put(PropertyKeys.scrollHeight, _scrollHeight);
	}

	public int getBuffer() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.buffer, 10);
	}
	public void setBuffer(int _buffer) {
		getStateHelper().put(PropertyKeys.buffer, _buffer);
	}

    public final static String CONTAINER_CLASS = "ui-datascroller ui-widget";
    public final static String INLINE_CONTAINER_CLASS = "ui-datascroller ui-datascroller-inline ui-widget";
    public final static String HEADER_CLASS = "ui-datascroller-header ui-widget-header ui-corner-top";
    public final static String CONTENT_CLASS = "ui-datascroller-content ui-widget-content";
    public final static String LIST_CLASS = "ui-datascroller-list";
    public final static String ITEM_CLASS = "ui-datascroller-item";
    public final static String LOADER_CLASS = "ui-datascroller-loader";
    public final static String LOADING_CLASS = "ui-datascroller-loading";

    public boolean isLoadRequest() {
        FacesContext context = getFacesContext();
        return context.getExternalContext().getRequestParameterMap().containsKey(this.getClientId(context) + "_load");
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