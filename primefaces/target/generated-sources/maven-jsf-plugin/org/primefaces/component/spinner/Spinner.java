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
package org.primefaces.component.spinner;

import javax.faces.component.html.HtmlInputText;
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
	@ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class Spinner extends HtmlInputText implements org.primefaces.component.api.Widget,org.primefaces.component.api.InputHolder {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Spinner";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.SpinnerRenderer";

	protected enum PropertyKeys {

		placeholder
		,widgetVar
		,stepFactor
		,min
		,max
		,prefix
		,suffix;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public Spinner() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public java.lang.String getPlaceholder() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.placeholder, null);
	}
	public void setPlaceholder(java.lang.String _placeholder) {
		getStateHelper().put(PropertyKeys.placeholder, _placeholder);
	}

	public java.lang.String getWidgetVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}
	public void setWidgetVar(java.lang.String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}

	public double getStepFactor() {
		return (java.lang.Double) getStateHelper().eval(PropertyKeys.stepFactor, 1.0);
	}
	public void setStepFactor(double _stepFactor) {
		getStateHelper().put(PropertyKeys.stepFactor, _stepFactor);
	}

	public double getMin() {
		return (java.lang.Double) getStateHelper().eval(PropertyKeys.min, java.lang.Double.MIN_VALUE);
	}
	public void setMin(double _min) {
		getStateHelper().put(PropertyKeys.min, _min);
	}

	public double getMax() {
		return (java.lang.Double) getStateHelper().eval(PropertyKeys.max, java.lang.Double.MAX_VALUE);
	}
	public void setMax(double _max) {
		getStateHelper().put(PropertyKeys.max, _max);
	}

	public java.lang.String getPrefix() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.prefix, null);
	}
	public void setPrefix(java.lang.String _prefix) {
		getStateHelper().put(PropertyKeys.prefix, _prefix);
	}

	public java.lang.String getSuffix() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.suffix, null);
	}
	public void setSuffix(java.lang.String _suffix) {
		getStateHelper().put(PropertyKeys.suffix, _suffix);
	}


    public final static String CONTAINER_CLASS = "ui-spinner ui-widget ui-corner-all";
    public final static String INPUT_CLASS = "ui-spinner-input ui-inputfield ui-state-default ui-corner-all";
    public final static String UP_BUTTON_CLASS = "ui-spinner-button ui-spinner-up ui-corner-tr ui-button ui-widget ui-state-default ui-button-text-only";
    public final static String DOWN_BUTTON_CLASS = "ui-spinner-button ui-spinner-down ui-corner-br ui-button ui-widget ui-state-default ui-button-text-only";
    public final static String UP_ICON_CLASS = "ui-icon ui-icon-triangle-1-n ui-c";
    public final static String DOWN_ICON_CLASS = "ui-icon ui-icon-triangle-1-s ui-c";

    public String getInputClientId() {
        return this.getClientId(getFacesContext()) + "_input";
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