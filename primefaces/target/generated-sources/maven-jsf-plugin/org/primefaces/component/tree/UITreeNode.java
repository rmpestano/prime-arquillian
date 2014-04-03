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
package org.primefaces.component.tree;

import javax.faces.component.UIColumn;
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
public class UITreeNode extends UIColumn {


	public static final String COMPONENT_TYPE = "org.primefaces.component.UITreeNode";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";

	protected enum PropertyKeys {

		type
		,styleClass
		,icon
		,expandedIcon
		,collapsedIcon;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public UITreeNode() {
		setRendererType(null);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public java.lang.String getType() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.type, "default");
	}
	public void setType(java.lang.String _type) {
		getStateHelper().put(PropertyKeys.type, _type);
	}

	public java.lang.String getStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.styleClass, null);
	}
	public void setStyleClass(java.lang.String _styleClass) {
		getStateHelper().put(PropertyKeys.styleClass, _styleClass);
	}

	public java.lang.String getIcon() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.icon, null);
	}
	public void setIcon(java.lang.String _icon) {
		getStateHelper().put(PropertyKeys.icon, _icon);
	}

	public java.lang.String getExpandedIcon() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.expandedIcon, null);
	}
	public void setExpandedIcon(java.lang.String _expandedIcon) {
		getStateHelper().put(PropertyKeys.expandedIcon, _expandedIcon);
	}

	public java.lang.String getCollapsedIcon() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.collapsedIcon, null);
	}
	public void setCollapsedIcon(java.lang.String _collapsedIcon) {
		getStateHelper().put(PropertyKeys.collapsedIcon, _collapsedIcon);
	}


    public String getIconToRender(boolean expanded) {
        String icon = getIcon();
        if(icon != null) {
            return icon;
        } else {
            String expandedIcon = getExpandedIcon();
            String collapsedIcon = getCollapsedIcon();

            if(expandedIcon != null && collapsedIcon != null) {
                return expanded ? expandedIcon : collapsedIcon;
            }
        }

        return null;
    }
}