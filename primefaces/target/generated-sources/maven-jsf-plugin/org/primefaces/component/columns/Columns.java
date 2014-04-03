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
package org.primefaces.component.columns;

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
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.primefaces.component.api.UIData;
import org.primefaces.component.celleditor.CellEditor;

@ResourceDependencies({

})
public class Columns extends UIData implements org.primefaces.component.api.UIColumn {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Columns";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";

	protected enum PropertyKeys {

		sortBy
		,style
		,styleClass
		,sortFunction
		,filterBy
		,filterStyle
		,filterStyleClass
		,filterOptions
		,filterMatchMode
		,filterPosition
		,rowspan
		,colspan
		,headerText
		,footerText
		,filterMaxLength
		,resizable
		,exportable
		,width
		,toggleable
		,filterFunction;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public Columns() {
		setRendererType(null);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public java.lang.Object getSortBy() {
		return (java.lang.Object) getStateHelper().eval(PropertyKeys.sortBy, null);
	}
	public void setSortBy(java.lang.Object _sortBy) {
		getStateHelper().put(PropertyKeys.sortBy, _sortBy);
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

	public javax.el.MethodExpression getSortFunction() {
		return (javax.el.MethodExpression) getStateHelper().eval(PropertyKeys.sortFunction, null);
	}
	public void setSortFunction(javax.el.MethodExpression _sortFunction) {
		getStateHelper().put(PropertyKeys.sortFunction, _sortFunction);
	}

	public java.lang.Object getFilterBy() {
		return (java.lang.Object) getStateHelper().eval(PropertyKeys.filterBy, null);
	}
	public void setFilterBy(java.lang.Object _filterBy) {
		getStateHelper().put(PropertyKeys.filterBy, _filterBy);
	}

	public java.lang.String getFilterStyle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.filterStyle, null);
	}
	public void setFilterStyle(java.lang.String _filterStyle) {
		getStateHelper().put(PropertyKeys.filterStyle, _filterStyle);
	}

	public java.lang.String getFilterStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.filterStyleClass, null);
	}
	public void setFilterStyleClass(java.lang.String _filterStyleClass) {
		getStateHelper().put(PropertyKeys.filterStyleClass, _filterStyleClass);
	}

	public java.lang.Object getFilterOptions() {
		return (java.lang.Object) getStateHelper().eval(PropertyKeys.filterOptions, null);
	}
	public void setFilterOptions(java.lang.Object _filterOptions) {
		getStateHelper().put(PropertyKeys.filterOptions, _filterOptions);
	}

	public java.lang.String getFilterMatchMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.filterMatchMode, "startsWith");
	}
	public void setFilterMatchMode(java.lang.String _filterMatchMode) {
		getStateHelper().put(PropertyKeys.filterMatchMode, _filterMatchMode);
	}

	public java.lang.String getFilterPosition() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.filterPosition, "bottom");
	}
	public void setFilterPosition(java.lang.String _filterPosition) {
		getStateHelper().put(PropertyKeys.filterPosition, _filterPosition);
	}

	public int getRowspan() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.rowspan, 1);
	}
	public void setRowspan(int _rowspan) {
		getStateHelper().put(PropertyKeys.rowspan, _rowspan);
	}

	public int getColspan() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.colspan, 1);
	}
	public void setColspan(int _colspan) {
		getStateHelper().put(PropertyKeys.colspan, _colspan);
	}

	public java.lang.String getHeaderText() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.headerText, null);
	}
	public void setHeaderText(java.lang.String _headerText) {
		getStateHelper().put(PropertyKeys.headerText, _headerText);
	}

	public java.lang.String getFooterText() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.footerText, null);
	}
	public void setFooterText(java.lang.String _footerText) {
		getStateHelper().put(PropertyKeys.footerText, _footerText);
	}

	public int getFilterMaxLength() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.filterMaxLength, java.lang.Integer.MAX_VALUE);
	}
	public void setFilterMaxLength(int _filterMaxLength) {
		getStateHelper().put(PropertyKeys.filterMaxLength, _filterMaxLength);
	}

	public boolean isResizable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.resizable, true);
	}
	public void setResizable(boolean _resizable) {
		getStateHelper().put(PropertyKeys.resizable, _resizable);
	}

	public boolean isExportable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.exportable, true);
	}
	public void setExportable(boolean _exportable) {
		getStateHelper().put(PropertyKeys.exportable, _exportable);
	}

	public java.lang.String getWidth() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.width, null);
	}
	public void setWidth(java.lang.String _width) {
		getStateHelper().put(PropertyKeys.width, _width);
	}

	public boolean isToggleable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.toggleable, true);
	}
	public void setToggleable(boolean _toggleable) {
		getStateHelper().put(PropertyKeys.toggleable, _toggleable);
	}

	public javax.el.MethodExpression getFilterFunction() {
		return (javax.el.MethodExpression) getStateHelper().eval(PropertyKeys.filterFunction, null);
	}
	public void setFilterFunction(javax.el.MethodExpression _filterFunction) {
		getStateHelper().put(PropertyKeys.filterFunction, _filterFunction);
	}


    public String getSelectionMode() {
        return null;
    }

    public boolean isDisabledSelection() {
        return false;
    }

    public CellEditor getCellEditor() {
        return null;
    }

    public boolean isDynamic() {
        return true;
    }

    public java.lang.String getColumnIndexVar() {
		return super.getRowIndexVar();
	}
	public void setColumnIndexVar(String _columnIndexVar) {
		super.setRowIndexVar(_columnIndexVar);
	}

    public String getColumnKey() {
        return this.getClientId();
    }
    
}