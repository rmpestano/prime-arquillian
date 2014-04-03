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
package org.primefaces.component.treetable;

import org.primefaces.component.api.UITree;
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
import org.primefaces.model.TreeTableModel;
import org.primefaces.model.TreeNode;
import javax.faces.model.DataModel;
import javax.faces.event.FacesEvent;
import javax.faces.event.PhaseId;
import java.util.Collection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Iterator;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.util.Constants;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.ColumnResizeEvent;
import org.primefaces.component.column.Column;
import java.lang.StringBuilder;
import java.util.Locale;
import javax.faces.context.FacesContext;
import org.primefaces.component.api.UIColumn;
import org.primefaces.util.ComponentUtils;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="primefaces.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class TreeTable extends UITree implements org.primefaces.component.api.Widget,javax.faces.component.behavior.ClientBehaviorHolder {


	public static final String COMPONENT_TYPE = "org.primefaces.component.TreeTable";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.TreeTableRenderer";

	protected enum PropertyKeys {

		widgetVar
		,style
		,styleClass
		,scrollable
		,scrollHeight
		,scrollWidth
		,tableStyle
		,tableStyleClass
		,emptyMessage
		,resizableColumns
		,rowStyleClass
		,liveResize
		,sortBy
		,sortOrder
		,sortFunction
		,nativeElements
		,dataLocale
		,caseSensitiveSort;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public TreeTable() {
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

	public boolean isScrollable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.scrollable, false);
	}
	public void setScrollable(boolean _scrollable) {
		getStateHelper().put(PropertyKeys.scrollable, _scrollable);
	}

	public java.lang.String getScrollHeight() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.scrollHeight, null);
	}
	public void setScrollHeight(java.lang.String _scrollHeight) {
		getStateHelper().put(PropertyKeys.scrollHeight, _scrollHeight);
	}

	public java.lang.String getScrollWidth() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.scrollWidth, null);
	}
	public void setScrollWidth(java.lang.String _scrollWidth) {
		getStateHelper().put(PropertyKeys.scrollWidth, _scrollWidth);
	}

	public java.lang.String getTableStyle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.tableStyle, null);
	}
	public void setTableStyle(java.lang.String _tableStyle) {
		getStateHelper().put(PropertyKeys.tableStyle, _tableStyle);
	}

	public java.lang.String getTableStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.tableStyleClass, null);
	}
	public void setTableStyleClass(java.lang.String _tableStyleClass) {
		getStateHelper().put(PropertyKeys.tableStyleClass, _tableStyleClass);
	}

	public java.lang.String getEmptyMessage() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.emptyMessage, "No records found.");
	}
	public void setEmptyMessage(java.lang.String _emptyMessage) {
		getStateHelper().put(PropertyKeys.emptyMessage, _emptyMessage);
	}

	public boolean isResizableColumns() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.resizableColumns, false);
	}
	public void setResizableColumns(boolean _resizableColumns) {
		getStateHelper().put(PropertyKeys.resizableColumns, _resizableColumns);
	}

	public java.lang.String getRowStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.rowStyleClass, null);
	}
	public void setRowStyleClass(java.lang.String _rowStyleClass) {
		getStateHelper().put(PropertyKeys.rowStyleClass, _rowStyleClass);
	}

	public boolean isLiveResize() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.liveResize, false);
	}
	public void setLiveResize(boolean _liveResize) {
		getStateHelper().put(PropertyKeys.liveResize, _liveResize);
	}

	public java.lang.Object getSortBy() {
		return (java.lang.Object) getStateHelper().eval(PropertyKeys.sortBy, null);
	}
	public void setSortBy(java.lang.Object _sortBy) {
		getStateHelper().put(PropertyKeys.sortBy, _sortBy);
	}

	public java.lang.String getSortOrder() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.sortOrder, "ascending");
	}
	public void setSortOrder(java.lang.String _sortOrder) {
		getStateHelper().put(PropertyKeys.sortOrder, _sortOrder);
	}

	public javax.el.MethodExpression getSortFunction() {
		return (javax.el.MethodExpression) getStateHelper().eval(PropertyKeys.sortFunction, null);
	}
	public void setSortFunction(javax.el.MethodExpression _sortFunction) {
		getStateHelper().put(PropertyKeys.sortFunction, _sortFunction);
	}

	public boolean isNativeElements() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.nativeElements, false);
	}
	public void setNativeElements(boolean _nativeElements) {
		getStateHelper().put(PropertyKeys.nativeElements, _nativeElements);
	}

	public java.lang.Object getDataLocale() {
		return (java.lang.Object) getStateHelper().eval(PropertyKeys.dataLocale, null);
	}
	public void setDataLocale(java.lang.Object _dataLocale) {
		getStateHelper().put(PropertyKeys.dataLocale, _dataLocale);
	}

	public boolean isCaseSensitiveSort() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.caseSensitiveSort, false);
	}
	public void setCaseSensitiveSort(boolean _caseSensitiveSort) {
		getStateHelper().put(PropertyKeys.caseSensitiveSort, _caseSensitiveSort);
	}


	public final static String CONTAINER_CLASS = "ui-treetable ui-widget";
    public final static String RESIZABLE_CONTAINER_CLASS = "ui-treetable ui-treetable-resizable ui-widget";
    public final static String HEADER_CLASS = "ui-treetable-header ui-widget-header ui-corner-top";
	public final static String DATA_CLASS = "ui-treetable-data ui-widget-content";
    public final static String FOOTER_CLASS = "ui-treetable-footer ui-widget-header ui-corner-bottom";
    public final static String COLUMN_HEADER_CLASS = "ui-state-default";
    public static final String SORTABLE_COLUMN_HEADER_CLASS = "ui-state-default ui-sortable-column";
    public final static String ROW_CLASS = "ui-widget-content";
    public final static String SELECTED_ROW_CLASS = "ui-widget-content ui-state-highlight ui-selected";
    public final static String COLUMN_CONTENT_WRAPPER = "ui-tt-c";
    public final static String EXPAND_ICON = "ui-treetable-toggler ui-icon ui-icon-triangle-1-e ui-c";
    public final static String COLLAPSE_ICON = "ui-treetable-toggler ui-icon ui-icon-triangle-1-s ui-c";
    public static final String SCROLLABLE_CONTAINER_CLASS = "ui-treetable-scrollable";
    public static final String SCROLLABLE_HEADER_CLASS = "ui-widget-header ui-treetable-scrollable-header";
    public static final String SCROLLABLE_HEADER_BOX_CLASS = "ui-treetable-scrollable-header-box";
    public static final String SCROLLABLE_BODY_CLASS = "ui-treetable-scrollable-body";
    public static final String SCROLLABLE_FOOTER_CLASS = "ui-widget-header ui-treetable-scrollable-footer";
    public static final String SCROLLABLE_FOOTER_BOX_CLASS = "ui-treetable-scrollable-footer-box";
    public static final String SELECTABLE_NODE_CLASS = "ui-treetable-selectable-node";
    public static final String RESIZABLE_COLUMN_CLASS = "ui-resizable-column";
    public static final String INDENT_CLASS = "ui-treetable-indent";
	public static final String EMPTY_MESSAGE_ROW_CLASS = "ui-widget-content ui-treetable-empty-message";
    public final static String PARTIAL_SELECTED_CLASS = "ui-treetable-partialselected";
    public static final String SORTABLE_COLUMN_ICON_CLASS = "ui-sortable-column-icon ui-icon ui-icon-carat-2-n-s";
    public static final String SORTABLE_COLUMN_ASCENDING_ICON_CLASS = "ui-sortable-column-icon ui-icon ui-icon ui-icon-carat-2-n-s ui-icon-triangle-1-n";
    public static final String SORTABLE_COLUMN_DESCENDING_ICON_CLASS = "ui-sortable-column-icon ui-icon ui-icon ui-icon-carat-2-n-s ui-icon-triangle-1-s";
    
    private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("select","unselect", "expand", "collapse", "colResize"));

    private List<String> selectedRowKeys = new ArrayList<String>();

    @Override
    public Collection<String> getEventNames() {
        return EVENT_NAMES;
    }

    private boolean isRequestSource(FacesContext context) {
        return this.getClientId(context).equals(context.getExternalContext().getRequestParameterMap().get(Constants.RequestParams.PARTIAL_SOURCE_PARAM));
    }

    public boolean isSelectionRequest(FacesContext context) {
		return context.getExternalContext().getRequestParameterMap().containsKey(this.getClientId(context) + "_instantSelection");
	}

    public boolean isSortRequest(FacesContext context) {
		return context.getExternalContext().getRequestParameterMap().containsKey(this.getClientId(context) + "_sorting");
	}

    @Override
    public void queueEvent(FacesEvent event) {
        FacesContext context = getFacesContext();

        if(isRequestSource(context)) {
            Map<String,String> params = context.getExternalContext().getRequestParameterMap();
            String eventName = params.get(Constants.RequestParams.PARTIAL_BEHAVIOR_EVENT_PARAM);
            String clientId = this.getClientId(context);
            FacesEvent wrapperEvent = null;

            AjaxBehaviorEvent behaviorEvent = (AjaxBehaviorEvent) event;

            if(eventName.equals("expand")) {
                String nodeKey = params.get(clientId + "_expand");
                this.setRowKey(nodeKey);
                TreeNode node = this.getRowNode();

                wrapperEvent = new NodeExpandEvent(this, behaviorEvent.getBehavior(), node);
                wrapperEvent.setPhaseId(PhaseId.APPLY_REQUEST_VALUES);
            } 
            else if(eventName.equals("collapse")) {
                String nodeKey = params.get(clientId + "_collapse");
                this.setRowKey(nodeKey);
                TreeNode node = this.getRowNode();

                wrapperEvent = new NodeCollapseEvent(this, behaviorEvent.getBehavior(), node);
                wrapperEvent.setPhaseId(PhaseId.APPLY_REQUEST_VALUES);
            } 
            else if(eventName.equals("select")) {
                String nodeKey = params.get(clientId + "_instantSelect");
                this.setRowKey(nodeKey);
                TreeNode node = this.getRowNode();

                wrapperEvent = new NodeSelectEvent(this, behaviorEvent.getBehavior(), node);
                wrapperEvent.setPhaseId(behaviorEvent.getPhaseId());
            }  
            else if(eventName.equals("unselect")) {
                String nodeKey = params.get(clientId + "_instantUnselect");
                this.setRowKey(nodeKey);
                TreeNode node = this.getRowNode();

                wrapperEvent = new NodeUnselectEvent(this, behaviorEvent.getBehavior(), node);
                wrapperEvent.setPhaseId(behaviorEvent.getPhaseId());
            }
            else if(eventName.equals("colResize")) {
                String columnId = params.get(clientId + "_columnId");
                int width = Integer.parseInt(params.get(clientId + "_width"));
                int height = Integer.parseInt(params.get(clientId + "_height"));

                wrapperEvent = new ColumnResizeEvent(this, behaviorEvent.getBehavior(), width, height, findColumn(columnId));
            }
            
            super.queueEvent(wrapperEvent);
        }
        else {
            super.queueEvent(event);
        }
    }

    @Override
    public void processDecodes(FacesContext context) {
        if(isToggleRequest(context)) {
            this.decode(context);
        } else {
            super.processDecodes(context);
        }
    }

    public Column findColumn(String clientId) {
        for(UIComponent child : getChildren()) {
            if(child instanceof Column && child.getClientId().equals(clientId)) {
                return (Column) child;
            }
        }
        
        return null;
    }

    public boolean hasFooterColumn() {
        for(UIComponent child : getChildren()) {
            if(child instanceof Column && child.isRendered()) {
                Column column = (Column) child;

                if(column.getFacet("footer") != null || column.getFooterText() != null)
                    return true;
            }
        }

        return false;
    }

    private boolean isToggleRequest(FacesContext context) {
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String clientId = getClientId(context);

        return params.get(clientId + "_expand") != null || params.get(clientId + "_collapse") != null;
    }

    public boolean isResizeRequest(FacesContext context) {
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String clientId = getClientId(context);

        return params.get(clientId + "_colResize") != null;
    }

    private int columnsCount = -1;

    public int getColumnsCount() {
        if(columnsCount == -1) {
            columnsCount = 0;

            for(UIComponent kid : getChildren()) {
                if(kid.isRendered() && kid instanceof Column) {
                    columnsCount++;
                } 
            }
        }

        return columnsCount;
    }

    public String getScrollState() {
        Map<String,String> params = getFacesContext().getExternalContext().getRequestParameterMap();
        String name = this.getClientId() + "_scrollState";
        String value = params.get(name);
        
        return value == null ? "0,0" : value;
    }

    public boolean isCheckboxSelection() {
        String selectionMode = this.getSelectionMode();
        
        return selectionMode != null && selectionMode.equals("checkbox");
    }

    private UIColumn sortColumn;
    
    public void setSortColumn(UIColumn column) {
        this.sortColumn = column;
    }
    public UIColumn getSortColumn() {
        return this.sortColumn;
    }

    public void clearDefaultSorted() {
        getStateHelper().remove("defaultSorted");
    }
    public void setDefaultSorted() {
        getStateHelper().put("defaultSorted", "defaultSorted");
    }
    public boolean isDefaultSorted() {
        return getStateHelper().get("defaultSorted") != null;
    }

    public Locale resolveDataLocale() {
        FacesContext context = this.getFacesContext();
        Object userLocale = this.getDataLocale();
        
        if(userLocale != null) {
            if(userLocale instanceof String)
                return ComponentUtils.toLocale((String) userLocale);
            else if(userLocale instanceof java.util.Locale)
                return (java.util.Locale) userLocale;
            else
                throw new IllegalArgumentException("Type:" + userLocale.getClass() + " is not a valid locale type for datatable:" + this.getClientId(context));
        } 
        else {
            return context.getViewRoot().getLocale();
        }
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