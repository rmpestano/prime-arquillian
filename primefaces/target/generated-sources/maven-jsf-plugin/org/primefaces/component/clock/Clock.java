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
package org.primefaces.component.clock;

import javax.faces.component.UIOutput;
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
import java.util.Map; 

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="clock/clock.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js"),
	@ResourceDependency(library="primefaces", name="clock/clock.js")
})
public class Clock extends UIOutput implements org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Clock";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.ClockRenderer";

	protected enum PropertyKeys {

		pattern
		,mode
		,autoSync
		,syncInterval;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public Clock() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getPattern() {
		return (String) getStateHelper().eval(PropertyKeys.pattern, null);
	}
	public void setPattern(String _pattern) {
		getStateHelper().put(PropertyKeys.pattern, _pattern);
	}

	public java.lang.String getMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.mode, "client");
	}
	public void setMode(java.lang.String _mode) {
		getStateHelper().put(PropertyKeys.mode, _mode);
	}

	public boolean isAutoSync() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.autoSync, false);
	}
	public void setAutoSync(boolean _autoSync) {
		getStateHelper().put(PropertyKeys.autoSync, _autoSync);
	}

	public int getSyncInterval() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.syncInterval, 60000);
	}
	public void setSyncInterval(int _syncInterval) {
		getStateHelper().put(PropertyKeys.syncInterval, _syncInterval);
	}


    public final static String STYLE_CLASS = "ui-clock ui-widget ui-widget-header ui-corner-all";

    public boolean isSyncRequest() {
        FacesContext context = getFacesContext();
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
    
        return params.containsKey(this.getClientId(context) + "_sync");
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