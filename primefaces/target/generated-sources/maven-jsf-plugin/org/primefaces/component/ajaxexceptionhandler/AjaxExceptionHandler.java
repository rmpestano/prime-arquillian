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
package org.primefaces.component.ajaxexceptionhandler;

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
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class AjaxExceptionHandler extends UIComponentBase {


	public static final String COMPONENT_TYPE = "org.primefaces.component.AjaxExceptionHandler";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";

	protected enum PropertyKeys {

		onexception
		,update
		,type;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public AjaxExceptionHandler() {
		setRendererType(null);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public java.lang.String getOnexception() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onexception, null);
	}
	public void setOnexception(java.lang.String _onexception) {
		getStateHelper().put(PropertyKeys.onexception, _onexception);
	}

	public java.lang.String getUpdate() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.update, null);
	}
	public void setUpdate(java.lang.String _update) {
		getStateHelper().put(PropertyKeys.update, _update);
	}

	public java.lang.String getType() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.type, null);
	}
	public void setType(java.lang.String _type) {
		getStateHelper().put(PropertyKeys.type, _type);
	}

}