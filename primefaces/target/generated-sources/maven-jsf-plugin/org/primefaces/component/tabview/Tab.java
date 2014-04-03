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
package org.primefaces.component.tabview;

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

})
public class Tab extends UIPanel {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Tab";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";

	protected enum PropertyKeys {

		title
		,titleStyle
		,titleStyleClass
		,disabled
		,closable
		,titletip;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public Tab() {
		setRendererType(null);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public java.lang.String getTitle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.title, null);
	}
	public void setTitle(java.lang.String _title) {
		getStateHelper().put(PropertyKeys.title, _title);
	}

	public java.lang.String getTitleStyle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.titleStyle, null);
	}
	public void setTitleStyle(java.lang.String _titleStyle) {
		getStateHelper().put(PropertyKeys.titleStyle, _titleStyle);
	}

	public java.lang.String getTitleStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.titleStyleClass, null);
	}
	public void setTitleStyleClass(java.lang.String _titleStyleClass) {
		getStateHelper().put(PropertyKeys.titleStyleClass, _titleStyleClass);
	}

	public boolean isDisabled() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.disabled, false);
	}
	public void setDisabled(boolean _disabled) {
		getStateHelper().put(PropertyKeys.disabled, _disabled);
	}

	public boolean isClosable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.closable, false);
	}
	public void setClosable(boolean _closable) {
		getStateHelper().put(PropertyKeys.closable, _closable);
	}

	public java.lang.String getTitletip() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.titletip, null);
	}
	public void setTitletip(java.lang.String _titletip) {
		getStateHelper().put(PropertyKeys.titletip, _titletip);
	}


    public void setLoaded(boolean value) {
        getStateHelper().put("loaded", value);
    }

    public boolean isLoaded() {
        Object value = getStateHelper().get("loaded");
        
        return (value == null) ? false : (Boolean) value;
    }
}