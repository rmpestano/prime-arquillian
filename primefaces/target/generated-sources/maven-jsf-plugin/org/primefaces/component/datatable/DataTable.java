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
package org.primefaces.component.datatable;

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
import org.primefaces.component.column.Column;
import org.primefaces.component.columns.Columns;
import org.primefaces.component.columngroup.ColumnGroup;
import org.primefaces.component.rowexpansion.RowExpansion;
import org.primefaces.component.row.Row;
import org.primefaces.component.subtable.SubTable;
import org.primefaces.component.contextmenu.ContextMenu;
import org.primefaces.component.summaryrow.SummaryRow;
import org.primefaces.context.RequestContext;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.application.NavigationHandler;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import org.primefaces.model.LazyDataModel;
import java.lang.StringBuilder;
import java.util.List;
import javax.el.ValueExpression;
import javax.faces.event.FacesEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import org.primefaces.util.Constants;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.event.data.PageEvent;
import org.primefaces.event.data.SortEvent;
import org.primefaces.event.data.FilterEvent;
import org.primefaces.event.ColumnResizeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.event.ReorderEvent;
import org.primefaces.model.Visibility;
import org.primefaces.model.SortOrder;
import org.primefaces.model.SelectableDataModel;
import org.primefaces.model.SelectableDataModelWrapper;
import java.lang.reflect.Array;
import javax.el.ELContext;
import javax.faces.model.DataModel;
import javax.faces.FacesException;
import javax.faces.component.UINamingContainer;
import org.primefaces.component.api.UIColumn;
import org.primefaces.component.api.DynamicColumn;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.SortMeta;
import org.primefaces.component.datatable.feature.*;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.SharedStringBuilder;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="primefaces.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class DataTable extends UIData implements org.primefaces.component.api.Widget,org.primefaces.component.api.RTLAware,javax.faces.component.behavior.ClientBehaviorHolder {


	public static final String COMPONENT_TYPE = "org.primefaces.component.DataTable";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.DataTableRenderer";

	protected enum PropertyKeys {

		widgetVar
		,scrollable
		,scrollHeight
		,scrollWidth
		,selectionMode
		,selection
		,emptyMessage
		,style
		,styleClass
		,liveScroll
		,rowStyleClass
		,onExpandStart
		,resizableColumns
		,sortBy
		,sortOrder
		,sortFunction
		,scrollRows
		,rowKey
		,filterEvent
		,filterDelay
		,tableStyle
		,tableStyleClass
		,draggableColumns
		,editable
		,filteredValue
		,sortMode
		,editMode
		,editingRow
		,cellSeparator
		,summary
		,frozenRows
		,dir
		,liveResize
		,stickyHeader
		,expandedRow
		,disabledSelection
		,rowSelectMode
		,rowExpandMode
		,dataLocale
		,nativeElements
		,frozenColumns
		,draggableRows
		,caseSensitiveSort
		,skipChildren;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public DataTable() {
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

	public java.lang.String getSelectionMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.selectionMode, null);
	}
	public void setSelectionMode(java.lang.String _selectionMode) {
		getStateHelper().put(PropertyKeys.selectionMode, _selectionMode);
	}

	public java.lang.Object getSelection() {
		return (java.lang.Object) getStateHelper().eval(PropertyKeys.selection, null);
	}
	public void setSelection(java.lang.Object _selection) {
		getStateHelper().put(PropertyKeys.selection, _selection);
	}

	public java.lang.String getEmptyMessage() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.emptyMessage, "No records found.");
	}
	public void setEmptyMessage(java.lang.String _emptyMessage) {
		getStateHelper().put(PropertyKeys.emptyMessage, _emptyMessage);
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

	public boolean isLiveScroll() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.liveScroll, false);
	}
	public void setLiveScroll(boolean _liveScroll) {
		getStateHelper().put(PropertyKeys.liveScroll, _liveScroll);
	}

	public java.lang.String getRowStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.rowStyleClass, null);
	}
	public void setRowStyleClass(java.lang.String _rowStyleClass) {
		getStateHelper().put(PropertyKeys.rowStyleClass, _rowStyleClass);
	}

	public java.lang.String getOnExpandStart() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onExpandStart, null);
	}
	public void setOnExpandStart(java.lang.String _onExpandStart) {
		getStateHelper().put(PropertyKeys.onExpandStart, _onExpandStart);
	}

	public boolean isResizableColumns() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.resizableColumns, false);
	}
	public void setResizableColumns(boolean _resizableColumns) {
		getStateHelper().put(PropertyKeys.resizableColumns, _resizableColumns);
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

	public int getScrollRows() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.scrollRows, 0);
	}
	public void setScrollRows(int _scrollRows) {
		getStateHelper().put(PropertyKeys.scrollRows, _scrollRows);
	}

	public java.lang.Object getRowKey() {
		return (java.lang.Object) getStateHelper().eval(PropertyKeys.rowKey, null);
	}
	public void setRowKey(java.lang.Object _rowKey) {
		getStateHelper().put(PropertyKeys.rowKey, _rowKey);
	}

	public java.lang.String getFilterEvent() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.filterEvent, null);
	}
	public void setFilterEvent(java.lang.String _filterEvent) {
		getStateHelper().put(PropertyKeys.filterEvent, _filterEvent);
	}

	public int getFilterDelay() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.filterDelay, java.lang.Integer.MAX_VALUE);
	}
	public void setFilterDelay(int _filterDelay) {
		getStateHelper().put(PropertyKeys.filterDelay, _filterDelay);
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

	public boolean isDraggableColumns() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.draggableColumns, false);
	}
	public void setDraggableColumns(boolean _draggableColumns) {
		getStateHelper().put(PropertyKeys.draggableColumns, _draggableColumns);
	}

	public boolean isEditable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.editable, false);
	}
	public void setEditable(boolean _editable) {
		getStateHelper().put(PropertyKeys.editable, _editable);
	}

	public java.util.List getFilteredValue() {
		return (java.util.List) getStateHelper().eval(PropertyKeys.filteredValue, null);
	}
	public void setFilteredValue(java.util.List _filteredValue) {
		getStateHelper().put(PropertyKeys.filteredValue, _filteredValue);
	}

	public java.lang.String getSortMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.sortMode, "single");
	}
	public void setSortMode(java.lang.String _sortMode) {
		getStateHelper().put(PropertyKeys.sortMode, _sortMode);
	}

	public java.lang.String getEditMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.editMode, "row");
	}
	public void setEditMode(java.lang.String _editMode) {
		getStateHelper().put(PropertyKeys.editMode, _editMode);
	}

	public boolean isEditingRow() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.editingRow, false);
	}
	public void setEditingRow(boolean _editingRow) {
		getStateHelper().put(PropertyKeys.editingRow, _editingRow);
	}

	public java.lang.String getCellSeparator() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.cellSeparator, null);
	}
	public void setCellSeparator(java.lang.String _cellSeparator) {
		getStateHelper().put(PropertyKeys.cellSeparator, _cellSeparator);
	}

	public java.lang.String getSummary() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.summary, null);
	}
	public void setSummary(java.lang.String _summary) {
		getStateHelper().put(PropertyKeys.summary, _summary);
	}

	public java.util.Collection getFrozenRows() {
		return (java.util.Collection) getStateHelper().eval(PropertyKeys.frozenRows, null);
	}
	public void setFrozenRows(java.util.Collection _frozenRows) {
		getStateHelper().put(PropertyKeys.frozenRows, _frozenRows);
	}

	public java.lang.String getDir() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.dir, "ltr");
	}
	public void setDir(java.lang.String _dir) {
		getStateHelper().put(PropertyKeys.dir, _dir);
	}

	public boolean isLiveResize() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.liveResize, false);
	}
	public void setLiveResize(boolean _liveResize) {
		getStateHelper().put(PropertyKeys.liveResize, _liveResize);
	}

	public boolean isStickyHeader() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.stickyHeader, false);
	}
	public void setStickyHeader(boolean _stickyHeader) {
		getStateHelper().put(PropertyKeys.stickyHeader, _stickyHeader);
	}

	public boolean isExpandedRow() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.expandedRow, false);
	}
	public void setExpandedRow(boolean _expandedRow) {
		getStateHelper().put(PropertyKeys.expandedRow, _expandedRow);
	}

	public boolean isDisabledSelection() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.disabledSelection, false);
	}
	public void setDisabledSelection(boolean _disabledSelection) {
		getStateHelper().put(PropertyKeys.disabledSelection, _disabledSelection);
	}

	public java.lang.String getRowSelectMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.rowSelectMode, "new");
	}
	public void setRowSelectMode(java.lang.String _rowSelectMode) {
		getStateHelper().put(PropertyKeys.rowSelectMode, _rowSelectMode);
	}

	public java.lang.String getRowExpandMode() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.rowExpandMode, "multiple");
	}
	public void setRowExpandMode(java.lang.String _rowExpandMode) {
		getStateHelper().put(PropertyKeys.rowExpandMode, _rowExpandMode);
	}

	public java.lang.Object getDataLocale() {
		return (java.lang.Object) getStateHelper().eval(PropertyKeys.dataLocale, null);
	}
	public void setDataLocale(java.lang.Object _dataLocale) {
		getStateHelper().put(PropertyKeys.dataLocale, _dataLocale);
	}

	public boolean isNativeElements() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.nativeElements, false);
	}
	public void setNativeElements(boolean _nativeElements) {
		getStateHelper().put(PropertyKeys.nativeElements, _nativeElements);
	}

	public int getFrozenColumns() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.frozenColumns, java.lang.Integer.MIN_VALUE);
	}
	public void setFrozenColumns(int _frozenColumns) {
		getStateHelper().put(PropertyKeys.frozenColumns, _frozenColumns);
	}

	public boolean isDraggableRows() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.draggableRows, false);
	}
	public void setDraggableRows(boolean _draggableRows) {
		getStateHelper().put(PropertyKeys.draggableRows, _draggableRows);
	}

	public boolean isCaseSensitiveSort() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.caseSensitiveSort, false);
	}
	public void setCaseSensitiveSort(boolean _caseSensitiveSort) {
		getStateHelper().put(PropertyKeys.caseSensitiveSort, _caseSensitiveSort);
	}

	public boolean isSkipChildren() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.skipChildren, false);
	}
	public void setSkipChildren(boolean _skipChildren) {
		getStateHelper().put(PropertyKeys.skipChildren, _skipChildren);
	}


    private final static Logger logger = Logger.getLogger(DataTable.class.getName());

    private static final String SB_GET_SELECTED_ROW_KEYS_AS_STRING = DataTable.class.getName() + "#getSelectedRowKeysAsString";
            
    public static final String CONTAINER_CLASS = "ui-datatable ui-widget";
    public static final String TABLE_WRAPPER_CLASS = "ui-datatable-tablewrapper";
    public static final String RTL_CLASS = "ui-datatable-rtl";
    public static final String COLUMN_HEADER_CLASS = "ui-state-default";
    public static final String DYNAMIC_COLUMN_HEADER_CLASS = "ui-dynamic-column";
    public static final String COLUMN_HEADER_CONTAINER_CLASS = "ui-header-column";
    public static final String COLUMN_FOOTER_CLASS = "ui-state-default";
    public static final String COLUMN_FOOTER_CONTAINER_CLASS = "ui-footer-column";
    public static final String DATA_CLASS = "ui-datatable-data ui-widget-content";
    public static final String ROW_CLASS = "ui-widget-content";
    public static final String SELECTABLE_ROW_CLASS = "ui-datatable-selectable";
    public static final String EMPTY_MESSAGE_ROW_CLASS = "ui-widget-content ui-datatable-empty-message";
    public static final String HEADER_CLASS = "ui-datatable-header ui-widget-header ui-corner-top";
    public static final String FOOTER_CLASS = "ui-datatable-footer ui-widget-header ui-corner-bottom";
    public static final String SORTABLE_COLUMN_CLASS = "ui-sortable-column";
    public static final String SORTABLE_COLUMN_ICON_CLASS = "ui-sortable-column-icon ui-icon ui-icon-carat-2-n-s";
    public static final String SORTABLE_COLUMN_ASCENDING_ICON_CLASS = "ui-sortable-column-icon ui-icon ui-icon ui-icon-carat-2-n-s ui-icon-triangle-1-n";
    public static final String SORTABLE_COLUMN_DESCENDING_ICON_CLASS = "ui-sortable-column-icon ui-icon ui-icon ui-icon-carat-2-n-s ui-icon-triangle-1-s";
    public static final String STATIC_COLUMN_CLASS = "ui-static-column";
    public static final String FILTER_COLUMN_CLASS = "ui-filter-column";
    public static final String COLUMN_TITLE_CLASS = "ui-column-title";
    public static final String COLUMN_FILTER_CLASS = "ui-column-filter ui-widget ui-state-default ui-corner-left";
    public static final String COLUMN_INPUT_FILTER_CLASS = "ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all";
    public static final String COLUMN_CUSTOM_FILTER_CLASS = "ui-column-customfilter";
    public static final String RESIZABLE_COLUMN_CLASS = "ui-resizable-column";
    public static final String EXPANDED_ROW_CLASS = "ui-expanded-row";
    public static final String EXPANDED_ROW_CONTENT_CLASS = "ui-expanded-row-content";
    public static final String ROW_TOGGLER_CLASS = "ui-row-toggler";
    public static final String EDITABLE_COLUMN_CLASS = "ui-editable-column";
    public static final String CELL_EDITOR_CLASS = "ui-cell-editor";
    public static final String CELL_EDITOR_INPUT_CLASS = "ui-cell-editor-input";
    public static final String CELL_EDITOR_OUTPUT_CLASS = "ui-cell-editor-output";
    public static final String ROW_EDITOR_COLUMN_CLASS = "ui-row-editor-column";
    public static final String ROW_EDITOR_CLASS = "ui-row-editor ui-helper-clearfix";
    public static final String SELECTION_COLUMN_CLASS = "ui-selection-column";
    public static final String EVEN_ROW_CLASS = "ui-datatable-even";
    public static final String ODD_ROW_CLASS = "ui-datatable-odd";
    public static final String SCROLLABLE_CONTAINER_CLASS = "ui-datatable-scrollable";
    public static final String SCROLLABLE_HEADER_CLASS = "ui-widget-header ui-datatable-scrollable-header";
    public static final String SCROLLABLE_HEADER_BOX_CLASS = "ui-datatable-scrollable-header-box";
    public static final String SCROLLABLE_BODY_CLASS = "ui-datatable-scrollable-body";
    public static final String SCROLLABLE_FOOTER_CLASS = "ui-widget-header ui-datatable-scrollable-footer";
    public static final String SCROLLABLE_FOOTER_BOX_CLASS = "ui-datatable-scrollable-footer-box";
    public static final String COLUMN_RESIZER_CLASS = "ui-column-resizer";
    public static final String RESIZABLE_CONTAINER_CLASS = "ui-datatable-resizable"; 
    public static final String SUBTABLE_HEADER = "ui-datatable-subtable-header"; 
    public static final String SUBTABLE_FOOTER = "ui-datatable-subtable-footer"; 
    public static final String SUMMARY_ROW_CLASS = "ui-datatable-summaryrow ui-widget-header";
    public static final String EDITING_ROW_CLASS = "ui-row-editing";
    public static final String STICKY_HEADER_CLASS = "ui-datatable-sticky";

    private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("page","sort","filter", "rowSelect", 
                                                        "rowUnselect", "rowEdit", "rowEditInit", "rowEditCancel", "colResize", "toggleSelect", "colReorder", "contextMenu"
                                                        ,"rowSelectRadio", "rowSelectCheckbox", "rowUnselectCheckbox", "rowDblselect", "rowToggle"
                                                        ,"cellEdit", "rowReorder"));

                                                        
    static Map<DataTableFeatureKey,DataTableFeature> FEATURES;
    
    static {
        FEATURES = new HashMap<DataTableFeatureKey,DataTableFeature>();
        FEATURES.put(DataTableFeatureKey.DRAGGABLE_COLUMNS, new DraggableColumnsFeature());
        FEATURES.put(DataTableFeatureKey.FILTER, new FilterFeature());
        FEATURES.put(DataTableFeatureKey.PAGE, new PageFeature());
        FEATURES.put(DataTableFeatureKey.SORT, new SortFeature());
        FEATURES.put(DataTableFeatureKey.RESIZABLE_COLUMNS, new ResizableColumnsFeature());
        FEATURES.put(DataTableFeatureKey.SELECT, new SelectionFeature());
        FEATURES.put(DataTableFeatureKey.ROW_EDIT, new RowEditFeature());
        FEATURES.put(DataTableFeatureKey.CELL_EDIT, new CellEditFeature());
        FEATURES.put(DataTableFeatureKey.ROW_EXPAND, new RowExpandFeature());
        FEATURES.put(DataTableFeatureKey.SCROLL, new ScrollFeature());
        FEATURES.put(DataTableFeatureKey.DRAGGABLE_ROWS, new DraggableRowsFeature());
    }
    
    public DataTableFeature getFeature(DataTableFeatureKey key) {
        return FEATURES.get(key);
    }
    
    public boolean shouldEncodeFeature(FacesContext context) {
        return context.getExternalContext().getRequestParameterMap().containsKey(this.getClientId(context) + "_encodeFeature");
    }
    
    public boolean isRowEditRequest(FacesContext context) {
        return context.getExternalContext().getRequestParameterMap().containsKey(this.getClientId(context) + "_rowEditAction");
    }
    
    public boolean isRowEditCancelRequest(FacesContext context) {
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String value = params.get(this.getClientId(context) + "_rowEditAction");
        
        return value != null && value.equals("cancel");
    }

    public boolean isRowSelectionEnabled() {
        return this.getSelectionMode() != null;
	}

    public boolean isColumnSelectionEnabled() {
        return getColumnSelectionMode() != null;
	}

    public String getColumnSelectionMode() {
        for(UIComponent child : getChildren()) {
            if(child.isRendered() && (child instanceof Column)) {
                String selectionMode = ((Column) child).getSelectionMode();
                
                if(selectionMode != null) {
                    return selectionMode;
                }
            }
        }

		return null;
	}

    public boolean isSelectionEnabled() {
        return this.isRowSelectionEnabled() || isColumnSelectionEnabled();
	}

    public boolean isSingleSelectionMode() {
		String selectionMode = this.getSelectionMode();
        String columnSelectionMode = this.getColumnSelectionMode();

		if(selectionMode != null)
			return selectionMode.equalsIgnoreCase("single");
		else if(columnSelectionMode != null)
			return columnSelectionMode.equalsIgnoreCase("single");
        else
            return false;
	}
    
    @Override
    public void processValidators(FacesContext context) {
        super.processValidators(context);

        if(this.isFilterRequest(context)) {
            FEATURES.get(DataTableFeatureKey.FILTER).decode(context, this);
        }
	}

    @Override
    public void processUpdates(FacesContext context) {
        super.processUpdates(context);

        ValueExpression selectionVE = this.getValueExpression("selection");

        if(selectionVE != null) {
            selectionVE.setValue(context.getELContext(), this.getLocalSelection());

            this.setSelection(null);
        }
	}

    @Override
    public void queueEvent(FacesEvent event) {
        FacesContext context = getFacesContext();

        if(isRequestSource(context) && event instanceof AjaxBehaviorEvent) {
            setRowIndex(-1);
            Map<String,String> params = context.getExternalContext().getRequestParameterMap();
            String eventName = params.get(Constants.RequestParams.PARTIAL_BEHAVIOR_EVENT_PARAM);
            String clientId = this.getClientId(context);
            FacesEvent wrapperEvent = null;

            AjaxBehaviorEvent behaviorEvent = (AjaxBehaviorEvent) event;

            if(eventName.equals("rowSelect")||eventName.equals("rowSelectRadio")||eventName.equals("contextMenu")
                    ||eventName.equals("rowSelectCheckbox")||eventName.equals("rowDblselect")) {
                String rowKey = params.get(clientId + "_instantSelectedRowKey");
                wrapperEvent = new SelectEvent(this, behaviorEvent.getBehavior(), this.getRowData(rowKey)); 
            }
            else if(eventName.equals("rowUnselect")||eventName.equals("rowUnselectCheckbox")) {
                String rowKey = params.get(clientId + "_instantUnselectedRowKey");
                wrapperEvent = new UnselectEvent(this, behaviorEvent.getBehavior(), this.getRowData(rowKey));
            }
            else if(eventName.equals("page")) {
                int rows = this.getRowsToRender();
                int first = Integer.parseInt(params.get(clientId + "_first"));
                int page = rows > 0 ? (int) (first / rows) : 0;
        
                wrapperEvent = new PageEvent(this, behaviorEvent.getBehavior(), page);
            }
            else if(eventName.equals("sort")) {
                SortOrder order;
                UIColumn sortColumn;
                
                if(isMultiSort()) {
                    String[] sortDirs = params.get(clientId + "_sortDir").split(",");
                    String[] sortKeys = params.get(clientId + "_sortKey").split(",");
                    
                    order = SortOrder.valueOf(sortDirs[sortDirs.length - 1]);
                    sortColumn = findColumn(sortKeys[sortKeys.length - 1]);
                } 
                else {
                    order = SortOrder.valueOf(params.get(clientId + "_sortDir"));
                    sortColumn = findColumn(params.get(clientId + "_sortKey"));
                }

                wrapperEvent = new SortEvent(this, behaviorEvent.getBehavior(), sortColumn, order);
            }
            else if(eventName.equals("filter")) {
                wrapperEvent = new FilterEvent(this, behaviorEvent.getBehavior(), getFilteredValue(), getFilters());
            }
            else if(eventName.equals("rowEdit")||eventName.equals("rowEditCancel")||eventName.equals("rowEditInit")) {
                int rowIndex = Integer.parseInt(params.get(clientId + "_rowEditIndex"));
                setRowIndex(rowIndex);
                wrapperEvent = new RowEditEvent(this, behaviorEvent.getBehavior(), this.getRowData());
            }
            else if(eventName.equals("colResize")) {
                String columnId = params.get(clientId + "_columnId");
                int width = Double.valueOf(params.get(clientId + "_width")).intValue();
                int height = Double.valueOf(params.get(clientId + "_height")).intValue();;

                wrapperEvent = new ColumnResizeEvent(this, behaviorEvent.getBehavior(), width, height, findColumn(columnId));
            }
            else if(eventName.equals("toggleSelect")) {
                boolean checked = Boolean.valueOf(params.get(clientId + "_checked"));
                
                wrapperEvent = new ToggleSelectEvent(this, behaviorEvent.getBehavior(), checked);
            }
            else if(eventName.equals("colReorder")) {
                wrapperEvent = behaviorEvent;
            }
            else if(eventName.equals("rowToggle")) {
                boolean expansion = params.containsKey(clientId + "_rowExpansion");
                Visibility visibility = expansion ? Visibility.VISIBLE : Visibility.HIDDEN;
                String rowIndex = expansion ? params.get(clientId + "_expandedRowIndex") : params.get(clientId + "_collapsedRowIndex");
                setRowIndex(Integer.parseInt(rowIndex));
                
                wrapperEvent = new ToggleEvent(this, behaviorEvent.getBehavior(), visibility, getRowData());
            }
            else if(eventName.equals("cellEdit")) {
                String[] cellInfo = params.get(clientId + "_cellInfo").split(",");
                int rowIndex = Integer.parseInt(cellInfo[0]);
                int cellIndex = Integer.parseInt(cellInfo[1]);
                int i = -1;
                UIColumn column = null;
                
                for(UIColumn col : this.getColumns()) {
                    if(col.isRendered()) {
                        i++;
                        
                        if(i == cellIndex) {
                            column = col;
                            break;
                        }
                    }
                }

                wrapperEvent = new CellEditEvent(this, behaviorEvent.getBehavior(), rowIndex, column);
            }
            else if(eventName.equals("rowReorder")) {
                int fromIndex = Integer.parseInt(params.get(clientId + "_fromIndex"));
                int toIndex = Integer.parseInt(params.get(clientId + "_toIndex"));
                
                wrapperEvent = new ReorderEvent(this, behaviorEvent.getBehavior(), fromIndex, toIndex);
            }
            
            wrapperEvent.setPhaseId(event.getPhaseId());

            super.queueEvent(wrapperEvent);
        }
        else {
            super.queueEvent(event);
        }
    }
    
    public UIColumn findColumn(String clientId) {
        for(UIColumn column : this.getColumns()) {
            if(column.getColumnKey().equals(clientId)) {
                return column;
            }
        }
        
        FacesContext context = this.getFacesContext();
        ColumnGroup headerGroup = this.getColumnGroup("header");
        for(UIComponent row : headerGroup.getChildren()) {
            for(UIComponent col : row.getChildren()) {
                if(col.getClientId(context).equals(clientId)) {
                    return (UIColumn) col;
                }
            }
        }
       
        throw new FacesException("Cannot find column with key: " + clientId);
    }

    public ColumnGroup getColumnGroup(String target) {
        for(UIComponent child : this.getChildren()) {
            if(child instanceof ColumnGroup) {
                ColumnGroup colGroup = (ColumnGroup) child;
                String type = colGroup.getType();

                if(type != null && type.equals(target)) {
                    return colGroup;
                }

            }
        }

        return null;
    }

    public boolean hasFooterColumn() {
        for(UIComponent child : getChildren()) {
            if(child.isRendered() && (child instanceof UIColumn)) {
                UIColumn column = (UIColumn) child;
                
                if(column.getFacet("footer") != null || column.getFooterText() != null)
                    return true; 
            }
            
        }

        return false;
    }

    public void loadLazyData() {
        DataModel model = getDataModel();
        
        if(model != null && model instanceof LazyDataModel) {            
            LazyDataModel lazyModel = (LazyDataModel) model;
            
            List<?> data = null;
            
            if(this.isMultiSort()) {
                data = lazyModel.load(getFirst(), getRows(), getMultiSortMeta(), getFilters());
            }
            else {
                data = lazyModel.load(getFirst(), getRows(),  resolveSortField(), convertSortOrder(), getFilters());
            }
            
            lazyModel.setPageSize(getRows());
            lazyModel.setWrappedData(data);

            //Update paginator for callback
            if(this.isPaginator()) {
                RequestContext requestContext = RequestContext.getCurrentInstance();

                if(requestContext != null) {
                    requestContext.addCallbackParam("totalRecords", lazyModel.getRowCount());
                }
            }
        }
    }
    
     public void loadLazyScrollData(int offset, int rows) {
        DataModel model = getDataModel();
        
        if(model != null && model instanceof LazyDataModel) {            
            LazyDataModel lazyModel = (LazyDataModel) model;
            
            List<?> data = null;
            
            if(this.isMultiSort()) {
                data = lazyModel.load(offset, rows, getMultiSortMeta(), getFilters());
            }
            else {
                data = lazyModel.load(offset, rows, resolveSortField(), convertSortOrder(), getFilters());
            }
            
            lazyModel.setPageSize(rows);
            lazyModel.setWrappedData(data);

            //Update paginator for callback
            if(this.isPaginator()) {
                RequestContext requestContext = RequestContext.getCurrentInstance();

                if(requestContext != null) {
                    requestContext.addCallbackParam("totalRecords", lazyModel.getRowCount());
                }
            }
        }
    }
        
    protected String resolveSortField() {
        UIColumn column = this.getSortColumn();
        String sortField = null;
        ValueExpression tableSortByVE = this.getValueExpression("sortBy");
        Object tableSortByProperty = this.getSortBy();
        
        if(column == null) {
            sortField = (tableSortByVE == null) ? (String) tableSortByProperty : resolveStaticField(tableSortByVE);
        }
        else {
            ValueExpression columnSortByVE = column.getValueExpression("sortBy");
            
            if(column.isDynamic()) {
                ((DynamicColumn) sortColumn).applyStatelessModel();
                Object sortByProperty = sortColumn.getSortBy();
                sortField = (sortByProperty == null) ? resolveDynamicField(columnSortByVE) : sortByProperty.toString();
            }
            else {
                sortField = (columnSortByVE == null) ? (String) column.getSortBy() : resolveStaticField(columnSortByVE);
            }
        }
        
        return sortField;
    }

    public SortOrder convertSortOrder() {
        String sortOrder = getSortOrder();
        
        if(sortOrder == null)
            return SortOrder.UNSORTED;
        else
            return SortOrder.valueOf(sortOrder.toUpperCase(Locale.ENGLISH));
    }

    public String resolveStaticField(ValueExpression expression) {
        if(expression != null) {
            String expressionString = expression.getExpressionString();
            expressionString = expressionString.substring(2, expressionString.length() - 1);      //Remove #{}

            return expressionString.substring(expressionString.indexOf(".") + 1);                //Remove var
        }
        else {
            return null;
        }
    }
    
    public String resolveDynamicField(ValueExpression expression) {
        if(expression != null) {
            String expressionString = expression.getExpressionString();
            expressionString = expressionString.substring(expressionString.indexOf("[") + 1, expressionString.indexOf("]"));            
            expressionString = "#{" + expressionString + "}";
            
            FacesContext context = getFacesContext();
            ELContext eLContext = context.getELContext();
            ValueExpression dynaVE = context.getApplication()
                                    .getExpressionFactory().createValueExpression(eLContext, expressionString, String.class);

            return (String) dynaVE.getValue(eLContext);
        }
        else {
            return null;
        }
    }

    public void clearLazyCache() {
        LazyDataModel model = (LazyDataModel) getDataModel();
        model.setWrappedData(null);
    }

    public Map<String,Object> getFilters() {
        return (Map<String,Object>) getStateHelper().eval("filters", new HashMap<String,Object>());
    }

    public void setFilters(Map<String,Object> filters) {
        getStateHelper().put("filters", filters);
    }
    
    private List filterMetadata;
    public List getFilterMetadata() {
        return filterMetadata;
    }
    public void setFilterMetadata(List filterMetadata) {
        this.filterMetadata = filterMetadata;
    }
    
    private boolean reset = false;
    
    public boolean isReset() {
        return reset;
    }

    public void resetValue() {
        setValue(null);
        setFilteredValue(null);
        setFilters(null);
    }

    public void reset() {
        resetValue();
        setFirst(0);
        this.reset = true;
    }

    public boolean isFilteringEnabled() {
        Object value = getStateHelper().get("filtering");

        return value == null ? false : true;
	}
	public void enableFiltering() {
		getStateHelper().put("filtering", true);
	}

    public RowExpansion getRowExpansion() {
        for(UIComponent kid : getChildren()) {
            if(kid instanceof RowExpansion)
                return (RowExpansion) kid;
        }

        return null;
    }

    private SelectableDataModelWrapper selectableDataModelWrapper = null;

    /**
    * Override to support filtering, we return the filtered subset in getValue instead of actual data.
    * In case selectableDataModel is bound, we wrap it with filtered data.
    * 
    */ 
    @Override
    public Object getValue() {
        Object value = super.getValue();
        List<?> filteredValue = this.getFilteredValue();
        
        if(filteredValue != null) {
            if(value instanceof SelectableDataModel) {
                return selectableDataModelWrapper == null 
                                ? (selectableDataModelWrapper = new SelectableDataModelWrapper((SelectableDataModel) value, filteredValue))
                                : selectableDataModelWrapper;
            } 
            else {
                return filteredValue;
            }
        }
        else {
            return value;
        }
    }
    
    public void setSelectableDataModelWrapper(SelectableDataModelWrapper wrapper) {
        this.selectableDataModelWrapper = wrapper;
    }

    public Object getLocalSelection() {
		return getStateHelper().get(PropertyKeys.selection);
	}

    @Override
    public Collection<String> getEventNames() {
        return EVENT_NAMES;
    }

    public boolean isRequestSource(FacesContext context) {
        String partialSource = context.getExternalContext().getRequestParameterMap().get(Constants.RequestParams.PARTIAL_SOURCE_PARAM);

        return partialSource != null && this.getClientId(context).equals(partialSource);
    }

    public boolean isBodyUpdate(FacesContext context) {
        String clientId = this.getClientId(context);

        return context.getExternalContext().getRequestParameterMap().containsKey(clientId + "_updateBody");
    }

    public SubTable getSubTable() {
        for(UIComponent kid : getChildren()) {
            if(kid instanceof SubTable)
                return (SubTable) kid;
        }
        
        return null;
    }

    public Object getRowKeyFromModel(Object object) {
        DataModel model = getDataModel();
        if(!(model instanceof SelectableDataModel)) {
            throw new FacesException("DataModel must implement org.primefaces.model.SelectableDataModel when selection is enabled.");
        }
        
        return ((SelectableDataModel) getDataModel()).getRowKey(object);
    }

    public Object getRowData(String rowKey) {
        boolean hasRowKeyVe = this.getValueExpression("rowKey") != null;
        
        if(hasRowKeyVe) {
            Map<String,Object> requestMap = getFacesContext().getExternalContext().getRequestMap();
            String var = this.getVar();
            Collection data = (Collection) getDataModel().getWrappedData();

            for(Iterator it = data.iterator(); it.hasNext();) {
                Object object = it.next();
                requestMap.put(var, object);

                if(String.valueOf(this.getRowKey()).equals(rowKey)) {
                    return object;
                }
            }
            
            return null;
        } 
        else {
            DataModel model = getDataModel();
            if(!(model instanceof SelectableDataModel)) {
                throw new FacesException("DataModel must implement org.primefaces.model.SelectableDataModel when selection is enabled or you need to define rowKey attribute");
            }

            return ((SelectableDataModel) getDataModel()).getRowData(rowKey);
        }
    }

    private List<Object> selectedRowKeys = new ArrayList<Object>();

    public void findSelectedRowKeys() {
        Object selection = this.getSelection();
        selectedRowKeys = new ArrayList<Object>();
        boolean hasRowKeyVe = this.getValueExpression("rowKey") != null;
        String var = this.getVar();
        Map<String,Object> requestMap = getFacesContext().getExternalContext().getRequestMap();

        if(isSelectionEnabled() && selection != null) {
            if(this.isSingleSelectionMode()) {
                addToSelectedRowKeys(selection, requestMap, var, hasRowKeyVe);
            } 
            else {
                if(selection.getClass().isArray()) {
                    for(int i = 0; i < Array.getLength(selection); i++) {
                        addToSelectedRowKeys(Array.get(selection, i), requestMap, var, hasRowKeyVe);   
                    }
                }
                else {
                    List<?> list = (List<?>) selection;
                    
                    for(Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
                        addToSelectedRowKeys(it.next(), requestMap, var, hasRowKeyVe);   
                    }
                }
                
            }
        }
    }
    
    protected void addToSelectedRowKeys(Object object, Map<String,Object> map, String var, boolean hasRowKey) {
        if(hasRowKey) {
            map.put(var, object);
            this.selectedRowKeys.add(this.getRowKey());
        }
        else {
            this.selectedRowKeys.add(this.getRowKeyFromModel(object));
        }
    }

    protected List<Object> getSelectedRowKeys() {
        return selectedRowKeys;
    }

    protected String getSelectedRowKeysAsString() {
        StringBuilder builder = SharedStringBuilder.get(SB_GET_SELECTED_ROW_KEYS_AS_STRING);
        for(Iterator<Object> iter = getSelectedRowKeys().iterator(); iter.hasNext();) {
            builder.append(iter.next());

            if(iter.hasNext()) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public SummaryRow getSummaryRow() {
        for(UIComponent kid : getChildren()) {
            if(kid.isRendered() && kid instanceof SummaryRow) {
                return (SummaryRow) kid;
            }
        }

        return null;
    }

    private int columnsCount = -1;
    
    public int getColumnsCount() {
        if(columnsCount == -1) {
            columnsCount = 0;

            for(UIComponent kid : getChildren()) {
                if(kid.isRendered()) {
                    if(kid instanceof Columns) {
                        Columns uicolumns = (Columns) kid;
                        Collection collection = (Collection) uicolumns.getValue();
                        if(collection != null) {
                            columnsCount += collection.size();
                        }
                    }
                    else if(kid instanceof Column) {
                        columnsCount++;
                    } 
                    else if(kid instanceof SubTable) {
                        SubTable subTable = (SubTable) kid;
                        for(UIComponent subTableKid : subTable.getChildren()) {
                            if(subTableKid.isRendered() && subTableKid instanceof Column) {
                                columnsCount++;
                            }
                        }
                    }
                } 
            }
        }

        return columnsCount;
    }
    
    private List<UIColumn> columns;
    
    public List<UIColumn> getColumns() {
        if(columns == null) {
            columns = new ArrayList<UIColumn>();
            FacesContext context = getFacesContext();
            char separator = UINamingContainer.getSeparatorChar(context);
            
            for(UIComponent child : this.getChildren()) {
                if(child instanceof Column) {
                    columns.add((UIColumn) child);
                }
                else if(child instanceof Columns) {
                    Columns uiColumns = (Columns) child;
                    String uiColumnsClientId = uiColumns.getClientId(context);
                    
                    for(int i=0; i < uiColumns.getRowCount(); i++) {
                        DynamicColumn dynaColumn = new DynamicColumn(i, uiColumns);
                        dynaColumn.setColumnKey(uiColumnsClientId + separator + i);
                        columns.add(dynaColumn);
                    }
                }
            }
        }
        
        return columns;
    }
    
    public void setColumns(List<UIColumn> columns) {
        this.columns = columns;
    }
        
    public String getScrollState() {
        Map<String,String> params = getFacesContext().getExternalContext().getRequestParameterMap();
        String name = this.getClientId() + "_scrollState";
        String value = params.get(name);
        
        return value == null ? "0,0" : value;
    }
    
    @Override
    protected boolean shouldSkipChildren(FacesContext context) {
        return this.isSkipChildren() || context.getExternalContext().getRequestParameterMap().containsKey(this.getClientId(context) + "_skipChildren");
    }
    
    private UIColumn sortColumn;
    
    public void setSortColumn(UIColumn column) {
        this.sortColumn = column;
    }
    public UIColumn getSortColumn() {
        return this.sortColumn;
    }
    
    public boolean isMultiSort() {
        String sortMode = this.getSortMode();
        
        return (sortMode != null && sortMode.equals("multiple"));
    }
    
    private List<SortMeta> multiSortMeta;
    
    public List<SortMeta> getMultiSortMeta() {
        if(this.multiSortMeta == null) {
            ValueExpression ve = this.getValueExpression("sortBy");
            if(ve != null) {
                this.multiSortMeta = (List<SortMeta>) ve.getValue(getFacesContext().getELContext());
            }
        }
        
        return this.multiSortMeta;
    }
    
    public void setMultiSortMeta(List<SortMeta> value) {
        this.multiSortMeta = value;
    }
    
    public boolean isRTL() {
        return this.getDir().equalsIgnoreCase("rtl");
    }
    
    public String resolveSelectionMode() {
        String tableSelectionMode = this.getSelectionMode();
        String columnSelectionMode = this.getColumnSelectionMode();
        String selectionMode = null;

        if(tableSelectionMode != null)
            selectionMode = tableSelectionMode;
        else if(columnSelectionMode != null)
            selectionMode = columnSelectionMode.equals("single") ? "radio" : "checkbox";
            
        return selectionMode;
    }
    
    @Override
    protected boolean requiresColumns() {
        return true;
    }
    
    private Columns dynamicColumns;
    
    public void setDynamicColumns(Columns value) {
        this.dynamicColumns = value;
    }
    public Columns getDynamicColumns() {
        return dynamicColumns;
    }
    
    @Override
    protected void processColumnFacets(FacesContext context, PhaseId phaseId) {  
        if(getChildCount() > 0) {
            for(UIComponent child : this.getChildren()) {
                if(child.isRendered()) {
                    if(child instanceof UIColumn) {
                        if(child instanceof Column) {
                            for(UIComponent facet : child.getFacets().values()) {
                                process(context, facet, phaseId);
                            }
                        }
                        else if(child instanceof Columns) {
                            Columns uicolumns = (Columns) child;
                            int f = uicolumns.getFirst();
                            int r = uicolumns.getRows();
                            int l = (r == 0) ? uicolumns.getRowCount() : (f + r);

                            for(int i = f; i < l; i++) {
                                uicolumns.setRowIndex(i);

                                if(!uicolumns.isRowAvailable()) {
                                    break;
                                }

                                for(UIComponent facet : child.getFacets().values()) {
                                    process(context, facet, phaseId);
                                }
                            }

                            uicolumns.setRowIndex(-1);
                        }
                    }
                    else if(child instanceof ColumnGroup) {
                        if(child.getChildCount() > 0) {
                            for(UIComponent row : child.getChildren()) {
                                if(row.getChildCount() > 0) {
                                    for(UIComponent col : row.getChildren()) {
                                        if(col instanceof Column && col.getFacetCount() > 0) {
                                            for(UIComponent facet : col.getFacets().values()) {
                                                process(context, facet, phaseId);
                                            }
                                        }
                                    }
                                }            
                            }
                        }
                    }
                }
            }
        }
    }
        
    private ValueExpression sortByVE;
    public void setSortByVE(ValueExpression ve) {
        this.sortByVE = ve;
    }
    public ValueExpression getSortByVE() {
        return this.sortByVE;
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
    
    private boolean isFilterRequest(FacesContext context) {
        return context.getExternalContext().getRequestParameterMap().containsKey(this.getClientId(context) + "_filtering");
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