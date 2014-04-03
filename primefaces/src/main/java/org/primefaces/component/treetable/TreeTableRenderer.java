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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.el.ValueExpression;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import org.primefaces.component.api.UIColumn;
import org.primefaces.component.api.UITree;

import org.primefaces.component.column.Column;
import org.primefaces.context.RequestContext;
import org.primefaces.model.SortOrder;
import org.primefaces.model.TreeNode;
import org.primefaces.model.TreeNodeComparator;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.renderkit.RendererUtils;
import org.primefaces.util.SharedStringBuilder;
import org.primefaces.util.TreeUtils;
import org.primefaces.util.WidgetBuilder;

public class TreeTableRenderer extends CoreRenderer {

    private static final String SB_DECODE_SELECTION = TreeTableRenderer.class.getName() + "#decodeSelection";
    
    @Override
    public void decode(FacesContext context, UIComponent component) {
        TreeTable tt = (TreeTable) component;
        
        if(tt.getSelectionMode() != null) {
            decodeSelection(context, tt);
        }
        
        if(tt.isSortRequest(context)) {
            decodeSort(context, tt);
        }
                    
        decodeBehaviors(context, component);
    }

    protected void decodeSelection(FacesContext context, TreeTable tt) {
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String selectionMode = tt.getSelectionMode();
        String clientId = tt.getClientId(context);
        
        //decode selection
        if(selectionMode != null) {
            String selectionValue = params.get(tt.getClientId(context) + "_selection");
            
            if(!isValueBlank(selectionValue)) {
                if(selectionMode.equals("single")) {
                    tt.setRowKey(selectionValue);

                    tt.setSelection(tt.getRowNode());
                } 
                else {
                    String[] rowKeys = selectionValue.split(",");
                    TreeNode[] selection = new TreeNode[rowKeys.length];

                    for(int i = 0; i < rowKeys.length; i++) {
                       tt.setRowKey(rowKeys[i]);

                       selection[i] = tt.getRowNode();
                    }

                    tt.setSelection(selection);
                }

                tt.setRowKey(null);     //cleanup
            }
        }

        if(tt.isCheckboxSelection() && tt.isSelectionRequest(context)) {
            String selectedNodeRowKey = params.get(clientId + "_instantSelection");
            tt.setRowKey(selectedNodeRowKey);
            TreeNode selectedNode = tt.getRowNode();
            List<String> descendantRowKeys = new ArrayList<String>();
            tt.populateRowKeys(selectedNode, descendantRowKeys);
            int size = descendantRowKeys.size();
            StringBuilder sb = SharedStringBuilder.get(context, SB_DECODE_SELECTION);
            
            for(int i = 0; i < size; i++) {
                sb.append(descendantRowKeys.get(i));
                if(i != (size - 1)) {
                    sb.append(",");
                }
            }
            
            RequestContext.getCurrentInstance().addCallbackParam("descendantRowKeys", sb.toString());
            sb.setLength(0);
            descendantRowKeys = null;
        }
    }

    @Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		TreeTable tt = (TreeTable) component;
        String clientId = tt.getClientId(context);
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        
        String nodeKey = params.get(clientId + "_expand");
        if(nodeKey != null) {
            tt.setRowKey(nodeKey);
            TreeNode node = tt.getRowNode();
            node.setExpanded(true);
            
            encodeNodeChildren(context, tt, node);
        }
        else if(tt.isSortRequest(context)) {
            encodeSort(context, tt);
        }
        else {
            encodeMarkup(context, tt);
            encodeScript(context, tt); 
        }
	}
	
	protected void encodeScript(FacesContext context, TreeTable tt) throws IOException {
		String clientId = tt.getClientId(context);
        String selectionMode = tt.getSelectionMode();
        WidgetBuilder wb = getWidgetBuilder(context);
        wb.initWithDomReady("TreeTable", tt.resolveWidgetVar(), clientId)
            .attr("selectionMode", selectionMode, null)
            .attr("resizableColumns", tt.isResizableColumns(), false)
            .attr("liveResize", tt.isLiveResize(), false)
            .attr("scrollable", tt.isScrollable(), false)
            .attr("scrollHeight", tt.getScrollHeight(), null)
            .attr("scrollWidth", tt.getScrollWidth(), null)
            .attr("nativeElements", tt.isNativeElements(), false);
        
        encodeClientBehaviors(context, tt);

        wb.finish();
	}

	protected void encodeMarkup(FacesContext context, TreeTable tt) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String clientId = tt.getClientId(context);
        boolean scrollable = tt.isScrollable();
        TreeNode root = tt.getValue();
        
        if(root.getRowKey() == null) {
            root.setRowKey("root");
            tt.buildRowKeys(root);
            tt.initPreselection();
        }
        
        //default sort
        if(tt.getValueExpression("sortBy") != null && !tt.isDefaultSorted()) {
            sort(tt);
        }
        
        String containerClass = tt.isResizableColumns() ? TreeTable.RESIZABLE_CONTAINER_CLASS : TreeTable.CONTAINER_CLASS;
        containerClass = scrollable ? containerClass + " " + TreeTable.SCROLLABLE_CONTAINER_CLASS : containerClass;
		containerClass = tt.getStyleClass() == null ? containerClass : containerClass + " " + tt.getStyleClass();
	
        writer.startElement("div", null);
        writer.writeAttribute("id", clientId, "id");
		writer.writeAttribute("class", containerClass, null);
		if(tt.getStyle() != null)
            writer.writeAttribute("style", tt.getStyle(), null);
        
        if(scrollable)
            encodeScrollableMarkup(context, tt);
        else
            encodeRegularMarkup(context, tt);
        
        if(tt.getSelectionMode() != null)
            encodeStateHolder(context, tt, clientId + "_selection", tt.getSelectedRowKeysAsString());
        
        if(scrollable)
            encodeStateHolder(context, tt, clientId + "_scrollState", tt.getScrollState());
        
        writer.endElement("div");
	}
    
    protected void encodeScrollableMarkup(FacesContext context, TreeTable tt) throws IOException {
        String tableStyle = tt.getStyle();
        String tableStyleClass = tt.getStyleClass();
                        
        encodeScrollAreaStart(context, tt, TreeTable.SCROLLABLE_HEADER_CLASS, TreeTable.SCROLLABLE_HEADER_BOX_CLASS, tableStyle, tableStyleClass, "header", TreeTable.HEADER_CLASS);
        encodeThead(context, tt);
        encodeScrollAreaEnd(context);
        
        encodeScrollBody(context, tt, tableStyle, tableStyleClass);
        
        encodeScrollAreaStart(context, tt, TreeTable.SCROLLABLE_FOOTER_CLASS, TreeTable.SCROLLABLE_FOOTER_BOX_CLASS, tableStyle, tableStyleClass, "footer", TreeTable.FOOTER_CLASS);
        encodeTfoot(context, tt);
        encodeScrollAreaEnd(context);
    }
    
    protected void encodeScrollBody(FacesContext context, TreeTable tt, String tableStyle, String tableStyleClass) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String scrollHeight = tt.getScrollHeight();

        writer.startElement("div", null);
        writer.writeAttribute("class", TreeTable.SCROLLABLE_BODY_CLASS, null);
        if(scrollHeight != null && scrollHeight.indexOf("%") == -1) {
            writer.writeAttribute("style", "height:" + scrollHeight + "px", null);
        }
        writer.startElement("table", null);
        writer.writeAttribute("role", "grid", null);
        
        if(tableStyle != null) writer.writeAttribute("style", tableStyle, null);
        if(tableStyleClass != null) writer.writeAttribute("class", tableStyleClass, null);
        
        encodeColGroup(context, tt);
        encodeTbody(context, tt, false);
        
        writer.endElement("table");
        writer.endElement("div");
    }
    
    public void encodeColGroup(FacesContext context, TreeTable tt) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        
        writer.startElement("colgroup", null);
        for(UIComponent kid : tt.getChildren()) {
            if(kid.isRendered() && kid instanceof Column) {
                writer.startElement("col", null);
                writer.endElement("col");
            }
        }
        writer.endElement("colgroup");
    }
    
    protected void encodeScrollAreaStart(FacesContext context, TreeTable tt, String containerClass, String containerBoxClass, 
                            String tableStyle, String tableStyleClass, String facet, String facetClass) throws IOException {
        
        ResponseWriter writer = context.getResponseWriter();
        
        writer.startElement("div", null);
        writer.writeAttribute("class", containerClass, null);
        
        encodeFacet(context, tt, tt.getFacet(facet), facetClass);

        writer.startElement("div", null);
        writer.writeAttribute("class", containerBoxClass, null);
        
        writer.startElement("table", null);
        writer.writeAttribute("role", "grid", null);
        if(tableStyle != null) writer.writeAttribute("style", tableStyle, null);
        if(tableStyleClass != null) writer.writeAttribute("class", tableStyleClass, null);        
    }
    
    protected void encodeScrollAreaEnd(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        
        writer.endElement("table");
        writer.endElement("div");
        writer.endElement("div");
    }
    
    protected void encodeRegularMarkup(FacesContext context, TreeTable tt) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        
        encodeFacet(context, tt, tt.getFacet("header"), TreeTable.HEADER_CLASS);
                
        writer.startElement("table", tt);
        writer.writeAttribute("role", "treegrid", null);
        if(tt.getTableStyle() != null) writer.writeAttribute("style", tt.getTableStyle(), null);
        if(tt.getTableStyleClass() != null) writer.writeAttribute("class", tt.getTableStyleClass(), null);

        encodeThead(context, tt);
        encodeTfoot(context, tt);
		encodeTbody(context, tt, false);
        
		writer.endElement("table");
        
        encodeFacet(context, tt, tt.getFacet("footer"), TreeTable.FOOTER_CLASS);
    }

	protected void encodeThead(FacesContext context, TreeTable tt) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
        String clientId = tt.getClientId(context);

		writer.startElement("thead", null);
        writer.writeAttribute("id", clientId + "_head", null);
                
		writer.startElement("tr", null);
        writer.writeAttribute("role", "row", null);
		
        for(int i = 0; i < tt.getChildCount(); i++) {
            UIComponent kid = tt.getChildren().get(i);
			
			if(kid instanceof Column && kid.isRendered()) {
                encodeColumnHeader(context, tt, (UIColumn) kid);
			}
		}
        
		writer.endElement("tr");
		writer.endElement("thead");
	}
       
    protected void encodeTbody(FacesContext context, TreeTable tt, boolean dataOnly) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		TreeNode root = (TreeNode) tt.getValue();
        String clientId = tt.getClientId(context);
		boolean empty = (root == null || root.getChildCount() == 0);
        UIComponent emptyFacet = tt.getFacet("emptyMessage");
        
        if(!dataOnly) {
            writer.startElement("tbody", null);
            writer.writeAttribute("id", clientId + "_data", null);
            writer.writeAttribute("class", TreeTable.DATA_CLASS, null);
        }
        
        if(empty) {
            writer.startElement("tr", null);
            writer.writeAttribute("class", TreeTable.EMPTY_MESSAGE_ROW_CLASS, null);

            writer.startElement("td", null);
            writer.writeAttribute("colspan", tt.getColumnsCount(), null);
            
            if(emptyFacet != null)
                emptyFacet.encodeAll(context);
            else
                writer.write(tt.getEmptyMessage());

            writer.endElement("td");
            writer.endElement("tr");
        }
        
		if(root != null) {
            encodeNodeChildren(context, tt, root);
		}

        tt.setRowKey(null);
		
        if(!dataOnly) {
            writer.endElement("tbody");
        }
	}
    
    protected void encodeNode(FacesContext context, TreeTable tt, TreeNode treeNode) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String rowKey = treeNode.getRowKey();
        String parentRowKey = treeNode.getParent().getRowKey();
        tt.setRowKey(rowKey);
        String icon = treeNode.isExpanded() ? TreeTable.COLLAPSE_ICON : TreeTable.EXPAND_ICON;
        int depth = rowKey.split(UITree.SEPARATOR).length - 1;
        String selectionMode = tt.getSelectionMode();
        boolean selectionEnabled = selectionMode != null;
        boolean selectable = treeNode.isSelectable() && selectionEnabled;
        boolean checkboxSelection = selectionEnabled && selectionMode.equals("checkbox");            
        boolean selected = treeNode.isSelected();
        boolean partialSelected = treeNode.isPartialSelected();
        boolean nativeElements = tt.isNativeElements();

        String rowStyleClass = selected ? TreeTable.SELECTED_ROW_CLASS : TreeTable.ROW_CLASS;
        rowStyleClass = selectable ? rowStyleClass + " " + TreeTable.SELECTABLE_NODE_CLASS : rowStyleClass;
        rowStyleClass = rowStyleClass + " " + treeNode.getType();

        if(partialSelected) {
            rowStyleClass = rowStyleClass + " " + TreeTable.PARTIAL_SELECTED_CLASS;
        }

        String userRowStyleClass = tt.getRowStyleClass();
        if(userRowStyleClass != null) {
            rowStyleClass = rowStyleClass + " " + userRowStyleClass;
        }

        writer.startElement("tr", null);
        writer.writeAttribute("id", tt.getClientId(context) + "_node_" + rowKey, null);
        writer.writeAttribute("class", rowStyleClass, null);
        writer.writeAttribute("role", "row", null);
        writer.writeAttribute("aria-expanded", String.valueOf(treeNode.isExpanded()), null);
        writer.writeAttribute("data-rk", rowKey, null);

        if(parentRowKey != null) {
            writer.writeAttribute("data-prk", parentRowKey, null);
        }

        if(selectionEnabled) {
            writer.writeAttribute("aria-selected", String.valueOf(selected), null);
        }

        for(int i=0; i < tt.getChildren().size(); i++) {
            UIComponent kid = (UIComponent) tt.getChildren().get(i);

            if(kid instanceof Column && kid.isRendered()) {
                Column column = (Column) kid;
                String columnStyleClass = column.getStyleClass();
                String columnStyle = column.getStyle();

                writer.startElement("td", null);
                writer.writeAttribute("role", "gridcell", null);
                if(columnStyle != null) writer.writeAttribute("style", columnStyle, null);
                if(columnStyleClass != null) writer.writeAttribute("class", columnStyleClass, null);

                if(i == 0) {
                    for(int j = 0; j < depth; j++) {
                        writer.startElement("span", null);
                        writer.writeAttribute("class", TreeTable.INDENT_CLASS, null);
                        writer.endElement("span");
                    }

                    writer.startElement("span", null);
                    writer.writeAttribute("class", icon, null);
                    if(treeNode.isLeaf()) {
                        writer.writeAttribute("style", "visibility:hidden", null);
                    }
                    writer.endElement("span");

                    if(selectable && checkboxSelection) {
                        if(!nativeElements)
                            RendererUtils.encodeCheckbox(context, selected, partialSelected);
                        else
                            renderNativeCheckbox(context, tt, selected, partialSelected);
                    }
                }

                column.encodeAll(context);

                writer.endElement("td");
            }
        }

        writer.endElement("tr");

        if(treeNode.isExpanded()) {
            encodeNodeChildren(context, tt, treeNode);
        }
    }
    
    protected void encodeColumnHeader(FacesContext context, TreeTable tt, UIColumn column) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        UIComponent header = column.getFacet("header");
        String headerText = column.getHeaderText();
        ValueExpression columnSortByVE = column.getValueExpression("sortBy");
        boolean sortable = (columnSortByVE != null);
        String sortIcon = null;
        String style = column.getStyle();
        String columnClass = sortable ? TreeTable.SORTABLE_COLUMN_HEADER_CLASS : TreeTable.COLUMN_HEADER_CLASS;
        String userColumnClass = column.getStyleClass();
        if(column.isResizable()) columnClass = columnClass + " " + TreeTable.RESIZABLE_COLUMN_CLASS;
        if(userColumnClass != null) columnClass = columnClass + " " + userColumnClass;
        
        if(sortable) {
            ValueExpression tableSortByVE = tt.getValueExpression("sortBy");
            if(tableSortByVE != null) {
                sortIcon = resolveSortIcon(columnSortByVE, tableSortByVE, tt.getSortOrder());
            }
            
            if(sortIcon == null)
                sortIcon = TreeTable.SORTABLE_COLUMN_ICON_CLASS;
            else
                columnClass += " ui-state-active";
        }

        writer.startElement("th", null);
        writer.writeAttribute("id", column.getClientId(context), null);
        writer.writeAttribute("class", columnClass, null);
        writer.writeAttribute("role", "columnheader", null);
        if(style != null) {
            writer.writeAttribute("style", style, null);
        }

        writer.startElement("span", null);
        
        if(header != null) 
            header.encodeAll(context);
        else if(headerText != null)
            writer.write(headerText);
        
        writer.endElement("span");
        
        if(sortable) {
            writer.startElement("span", null);
            writer.writeAttribute("class", sortIcon, null);
            writer.endElement("span");
        }

        writer.endElement("th");
    }
        
    protected void encodeNodeChildren(FacesContext context, TreeTable tt, TreeNode treeNode) throws IOException {
        int childCount = treeNode.getChildCount();
        if(childCount > 0) {
            List<TreeNode> children = treeNode.getChildren();
            for(int i = 0; i < childCount; i++) {
                encodeNode(context, tt, children.get(i));
            }
        }
    }
    
    protected void encodeFacet(FacesContext context, TreeTable tt, UIComponent facet, String styleClass) throws IOException {
        if(facet == null)
            return;
        
        ResponseWriter writer = context.getResponseWriter();

        writer.startElement("div", null);
        writer.writeAttribute("class", styleClass, null);

        facet.encodeAll(context);
        
        writer.endElement("div");
    }
    
    protected void encodeTfoot(FacesContext context, TreeTable tt) throws IOException {
        ResponseWriter writer = context.getResponseWriter();

        writer.startElement("tfoot", null);

        if(tt.hasFooterColumn()) {
            writer.startElement("tr", null);

            for(int i = 0; i < tt.getChildCount(); i++) {
                UIComponent kid = tt.getChildren().get(i);

                if(kid instanceof Column && kid.isRendered()) {
                    Column column = (Column) kid;
                    UIComponent footer = column.getFacet("footer");
                    String footerText = column.getHeaderText();

                    String columnStyleClass = column.getStyleClass() == null ? TreeTable.COLUMN_HEADER_CLASS : TreeTable.COLUMN_HEADER_CLASS + " " + column.getStyleClass();
                    String style = column.getStyle();

                    writer.startElement("td", null);
                    writer.writeAttribute("class", columnStyleClass, null);
                    if(style != null) {
                        writer.writeAttribute("style", style, null);
                    }
                   
                    if(footer != null) 
                        footer.encodeAll(context);
                    else if(footerText != null)
                        writer.write(footerText);

                    writer.endElement("td");
                }
            }

            writer.endElement("tr");
        }
        
        writer.endElement("tfoot");
    }
	
    @Override
	public void encodeChildren(FacesContext facesContext, UIComponent component) throws IOException {
		//Do nothing
	}
	
    @Override
	public boolean getRendersChildren() {
		return true;
	}

    private void encodeStateHolder(FacesContext context, TreeTable tt, String name, String value) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        
        writer.startElement("input", null);
        writer.writeAttribute("id", name, null);
        writer.writeAttribute("name", name, null);
        writer.writeAttribute("type", "hidden", null);
        writer.writeAttribute("value", value, null);
        writer.endElement("input");
    }
    
    protected String resolveSortIcon(ValueExpression columnSortBy, ValueExpression ttSortBy, String sortOrder) {
        String columnSortByExpression = columnSortBy.getExpressionString();
        String ttSortByExpression = ttSortBy.getExpressionString();
        String sortIcon = null;

        if(ttSortByExpression != null && ttSortByExpression.equals(columnSortByExpression)) {
            if(sortOrder.equalsIgnoreCase("ASCENDING"))
                sortIcon = TreeTable.SORTABLE_COLUMN_ASCENDING_ICON_CLASS;
            else if(sortOrder.equalsIgnoreCase("DESCENDING"))
                sortIcon = TreeTable.SORTABLE_COLUMN_DESCENDING_ICON_CLASS;
        }
        
        return sortIcon;
    }
    
    protected void decodeSort(FacesContext context, TreeTable tt) {
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String clientId = tt.getClientId(context);
        String sortKey = params.get(clientId + "_sortKey");
		String sortDir  = params.get(clientId + "_sortDir");
        
        UIColumn sortColumn = tt.findColumn(sortKey);
        ValueExpression sortByVE = sortColumn.getValueExpression("sortBy");
        tt.setValueExpression("sortBy", sortByVE);
        tt.setSortColumn(sortColumn);
        tt.setSortFunction(sortColumn.getSortFunction());
        tt.setSortOrder(sortDir); 
    }
    
    protected void encodeSort(FacesContext context, TreeTable tt) throws IOException {
        sort(tt);
                
        encodeTbody(context, tt, true);
    }
    
    public void sort(TreeTable tt) {
        TreeNode root = tt.getValue();
        if(root == null)
            return;
        
        ValueExpression sortByVE = tt.getValueExpression("sortBy");
        SortOrder sortOrder = SortOrder.valueOf(tt.getSortOrder().toUpperCase(Locale.ENGLISH));
        TreeUtils.sortNode(root, new TreeNodeComparator(sortByVE, tt.getVar(), sortOrder, tt.getSortFunction(), tt.isCaseSensitiveSort(), tt.resolveDataLocale()));
        tt.updateRowKeys(root);
    }

    protected void renderNativeCheckbox(FacesContext context, TreeTable tt, boolean checked, boolean partialSelected) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        
        writer.startElement("input", null);
        writer.writeAttribute("type", "checkbox", null);
        writer.writeAttribute("name", tt.getContainerClientId(context) + "_checkbox", null);
        
        if(checked) {
            writer.writeAttribute("checked", "checked", null);
        }
        
        if(partialSelected) {
            writer.writeAttribute("class", "ui-treetable-indeterminate", null);
        }
                
        writer.endElement("input");
    }
}