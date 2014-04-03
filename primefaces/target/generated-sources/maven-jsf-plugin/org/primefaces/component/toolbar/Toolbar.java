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
package org.primefaces.component.toolbar;

import javax.faces.component.UIComponentBase;
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
	@ResourceDependency(library="primefaces", name="primefaces.css")
})
public class Toolbar extends UIComponentBase {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Toolbar";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.ToolbarRenderer";

	protected enum PropertyKeys {

		style
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

	public Toolbar() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
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


    public static String CONTAINER_CLASS = "ui-toolbar ui-widget ui-widget-header ui-corner-all ui-helper-clearfix";
    public static String SEPARATOR_CLASS = "ui-separator";
    public static String SEPARATOR_ICON_CLASS = "ui-icon ui-icon-grip-dotted-vertical";

    public static String MOBILE_CONTAINER_CLASS = "ui-toolbar ui-header ui-bar-inherit";
    public static String MOBILE_LEFT_GROUP_CLASS = "ui-btn-left ui-controlgroup ui-controlgroup-horizontal ui-corner-all";
    public static String MOBILE_RIGHT_GROUP_CLASS = "ui-btn-right ui-controlgroup ui-controlgroup-horizontal ui-corner-all";
    public static String MOBILE_GROUP_CONTAINER_CLASS = "ui-controlgroup-controls ";
}