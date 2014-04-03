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
package org.primefaces.component.scrollpanel;

import javax.faces.component.UIPanel;
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
	@ResourceDependency(library="primefaces", name="scrollpanel/scrollpanel.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js"),
	@ResourceDependency(library="primefaces", name="scrollpanel/scrollpanel.js")
})
public class ScrollPanel extends UIPanel implements org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.component.ScrollPanel";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.ScrollPanelRenderer";

	protected enum PropertyKeys {

		widgetVar
		,style
		,styleClass
		,mode;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public ScrollPanel() {
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

	public java.lang.String getMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.mode, "default");
	}
	public void setMode(java.lang.String _mode) {
		getStateHelper().put(PropertyKeys.mode, _mode);
	}



    public static final String SCROLL_PANEL_CLASS = "ui-scrollpanel ui-widget ui-widget-content";
    public static final String SCROLL_PANEL_NATIVE_CLASS = "ui-scrollpanel ui-scrollpanel-native ui-widget ui-widget-content ui-corner-all";
    public static final String SCROLL_PANEL_CONTAINER_CLASS = "ui-scrollpanel-container";
    public static final String SCROLL_PANEL_WRAPPER_CLASS = "ui-scrollpanel-wrapper";
    public static final String SCROLL_PANEL_CONTENT_CLASS = "ui-scrollpanel-content";
    public static final String SCROLL_PANEL_HBAR_CLASS = "ui-scrollpanel-hbar ui-widget-header ui-corner-bottom";
    public static final String SCROLL_PANEL_VBAR_CLASS = "ui-scrollpanel-vbar ui-widget-header ui-corner-right";
    public static final String SCROLL_PANEL_HANDLE_CLASS = "ui-scrollpanel-handle ui-state-default ui-corner-all";
    public static final String SCROLL_PANEL_BLEFT_CLASS = "ui-scrollpanel-bl ui-state-default ui-corner-bl";
    public static final String SCROLL_PANEL_BRIGHT_CLASS = "ui-scrollpanel-br ui-state-default ui-corner-br";
    public static final String SCROLL_PANEL_BTOP_CLASS = "ui-scrollpanel-bt ui-state-default ui-corner-tr";
    public static final String SCROLL_PANEL_BBOTTOM_CLASS = "ui-scrollpanel-bb ui-state-default ui-corner-br";
    public static final String SCROLL_PANEL_VGRIP_CLASS = "ui-icon ui-icon-grip-solid-vertical";
    public static final String SCROLL_PANEL_HGRIP_CLASS = "ui-icon ui-icon-grip-solid-horizontal";
    public static final String SCROLL_PANEL_IWEST_CLASS = "ui-icon ui-icon-triangle-1-w";
    public static final String SCROLL_PANEL_IEAST_CLASS = "ui-icon ui-icon-triangle-1-e";
    public static final String SCROLL_PANEL_INORTH_CLASS = "ui-icon ui-icon-triangle-1-n";
    public static final String SCROLL_PANEL_ISOUTH_CLASS = "ui-icon ui-icon-triangle-1-s";
	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if(userWidgetVar != null)
			return userWidgetVar;
		 else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}
}