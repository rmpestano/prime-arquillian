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
package org.primefaces.mobile.component.uiswitch;

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

})
public class UISwitch extends UIInput implements org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.mobile.UISwitch";
	public static final String COMPONENT_FAMILY = "org.primefaces.mobile.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.mobile.component.UISwitchRenderer";

	protected enum PropertyKeys {

		onLabel
		,offLabel
		,label
		,disabled
		,onchange
		,style
		,styleClass;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public UISwitch() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public java.lang.String getOnLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onLabel, "on");
	}
	public void setOnLabel(java.lang.String _onLabel) {
		getStateHelper().put(PropertyKeys.onLabel, _onLabel);
	}

	public java.lang.String getOffLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.offLabel, "off");
	}
	public void setOffLabel(java.lang.String _offLabel) {
		getStateHelper().put(PropertyKeys.offLabel, _offLabel);
	}

	public java.lang.String getLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.label, null);
	}
	public void setLabel(java.lang.String _label) {
		getStateHelper().put(PropertyKeys.label, _label);
	}

	public boolean isDisabled() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.disabled, false);
	}
	public void setDisabled(boolean _disabled) {
		getStateHelper().put(PropertyKeys.disabled, _disabled);
	}

	public java.lang.String getOnchange() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onchange, null);
	}
	public void setOnchange(java.lang.String _onchange) {
		getStateHelper().put(PropertyKeys.onchange, _onchange);
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


    public static String CONTAINER_CLASS = "ui-flipswitch ui-shadow-inset ui-bar-inherit ui-corner-all";
    public static String ON_CLASS = "ui-flipswitch-on ui-btn ui-shadow ui-btn-inherit";
    public static String OFF_CLASS = "ui-flipswitch-off";
    public static String INPUT_CLASS = "ui-flipswitch-input";
	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if(userWidgetVar != null)
			return userWidgetVar;
		 else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}
}