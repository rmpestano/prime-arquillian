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
package org.primefaces.component.datatable.feature;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import org.primefaces.component.api.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import org.primefaces.component.api.DynamicColumn;
import org.primefaces.component.column.Column;
import org.primefaces.component.columngroup.ColumnGroup;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.datatable.DataTableRenderer;
import org.primefaces.component.row.Row;
import org.primefaces.context.RequestContext;
import org.primefaces.model.filter.*;
import org.primefaces.util.Constants;

public class FilterFeature implements DataTableFeature {
    
    private final static Logger logger = Logger.getLogger(DataTable.class.getName());
    
    private final static String STARTS_WITH_MATCH_MODE = "startsWith";
    private final static String ENDS_WITH_MATCH_MODE = "endsWith";
    private final static String CONTAINS_MATCH_MODE = "contains";
    private final static String EXACT_MATCH_MODE = "exact";
    private final static String LESS_THAN_MODE = "lt";
    private final static String LESS_THAN_EQUALS_MODE = "lte";
    private final static String GREATER_THAN_MODE = "gt";
    private final static String GREATER_THAN_EQUALS_MODE = "gte";
    private final static String EQUALS_MODE = "equals";
    private final static String IN_MODE = "in";
    private final static String GLOBAL_MODE = "global";
  
    final static Map<String,FilterConstraint> FILTER_CONSTRAINTS;
    
    static {
        FILTER_CONSTRAINTS = new HashMap<String,FilterConstraint>();
        FILTER_CONSTRAINTS.put(STARTS_WITH_MATCH_MODE, new StartsWithFilterConstraint());
        FILTER_CONSTRAINTS.put(ENDS_WITH_MATCH_MODE, new EndsWithFilterConstraint());
        FILTER_CONSTRAINTS.put(CONTAINS_MATCH_MODE, new ContainsFilterConstraint());
        FILTER_CONSTRAINTS.put(EXACT_MATCH_MODE, new ExactFilterConstraint());
        FILTER_CONSTRAINTS.put(LESS_THAN_MODE, new LessThanFilterConstraint());
        FILTER_CONSTRAINTS.put(LESS_THAN_EQUALS_MODE, new LessThanEqualsFilterConstraint());
        FILTER_CONSTRAINTS.put(GREATER_THAN_MODE, new GreaterThanFilterConstraint());
        FILTER_CONSTRAINTS.put(GREATER_THAN_EQUALS_MODE, new GreaterThanEqualsFilterConstraint());
        FILTER_CONSTRAINTS.put(EQUALS_MODE, new EqualsFilterConstraint());
        FILTER_CONSTRAINTS.put(IN_MODE, new InFilterConstraint());
        FILTER_CONSTRAINTS.put(GLOBAL_MODE, new GlobalFilterConstraint());
    }
    
    private boolean isFilterRequest(FacesContext context, DataTable table) {
        return context.getExternalContext().getRequestParameterMap().containsKey(table.getClientId(context) + "_filtering");
    }
    
    public boolean shouldDecode(FacesContext context, DataTable table) {
        return false;
    }
    
    public boolean shouldEncode(FacesContext context, DataTable table) {
        return isFilterRequest(context, table);
    }

    public void decode(FacesContext context, DataTable table) {
        String globalFilterParam = table.getClientId(context) + UINamingContainer.getSeparatorChar(context) + "globalFilter";
        List<FilterMeta> filterMetadata = this.populateFilterMetaData(context, table);
        Map<String,Object> filterParameterMap = this.populateFilterParameterMap(context, table, filterMetadata, globalFilterParam);
        table.setFilters(filterParameterMap);
        table.setFilterMetadata(filterMetadata);
    }
            
    public void encode(FacesContext context, DataTableRenderer renderer, DataTable table) throws IOException {
        //reset state
        updateFilteredValue(context, table, null);
        table.setFirst(0);
        table.setRowIndex(-1);
        
        if(table.isLazy()) {
            table.loadLazyData();
        }
        else {
            String globalFilterParam = table.getClientId(context) + UINamingContainer.getSeparatorChar(context) + "globalFilter";
            filter(context, table, table.getFilterMetadata(), globalFilterParam);
            
            //sort new filtered data to restore sort state
            boolean sorted = (table.getValueExpression("sortBy") != null || table.getSortBy() != null);
            if(sorted) {
                SortFeature sortFeature = (SortFeature) table.getFeature(DataTableFeatureKey.SORT);
                
                if(table.isMultiSort())
                    sortFeature.multiSort(context, table);
                else
                    sortFeature.singleSort(context, table);
            }
        }
                
        renderer.encodeTbody(context, table, true);
    }
    
    private void filter(FacesContext context, DataTable table, List<FilterMeta> filterMetadata, String globalFilterParam) {
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        List filteredData = new ArrayList();
        Locale filterLocale = table.resolveDataLocale();
        boolean hasGlobalFilter = params.containsKey(globalFilterParam);
        String globalFilterValue = hasGlobalFilter ? params.get(globalFilterParam): null;
        GlobalFilterConstraint globalFilterConstraint = (GlobalFilterConstraint) FILTER_CONSTRAINTS.get(GLOBAL_MODE);
        ELContext elContext = context.getELContext();
        
        for(int i = 0; i < table.getRowCount(); i++) {
            table.setRowIndex(i);
            boolean localMatch = true;
            boolean globalMatch = false;

            for(FilterMeta filterMeta : filterMetadata) {
                Object filterValue = filterMeta.getFilterValue();
                UIColumn column = filterMeta.getColumn();
                MethodExpression filterFunction = column.getFilterFunction();
                ValueExpression filterByVE = filterMeta.getFilterByVE();
                Object columnValue = filterByVE.getValue(elContext);
                
                if(column instanceof DynamicColumn) {
                    ((DynamicColumn) column).applyStatelessModel();
                }
                
                FilterConstraint filterConstraint = this.getFilterConstraint(column);

                if(hasGlobalFilter && !globalMatch) {
                    globalMatch = globalFilterConstraint.applies(columnValue, globalFilterValue, filterLocale);
                }

                if(filterFunction != null) {
                    localMatch = (Boolean) filterFunction.invoke(elContext, new Object[]{columnValue, filterValue, filterLocale});
                }
                else if(!filterConstraint.applies(columnValue, filterValue, filterLocale)) {
                    localMatch = false;
                }
                
                if(!localMatch) {
                    break;
                }
            }

            boolean matches = localMatch;
            if(hasGlobalFilter) {
                matches = localMatch && globalMatch;
            }

            if(matches) {
                filteredData.add(table.getRowData());
            }
        }

        //Metadata for callback
        if(table.isPaginator()) {
            RequestContext requestContext = RequestContext.getCurrentInstance();

            if(requestContext != null) {
                requestContext.addCallbackParam("totalRecords", filteredData.size());
            }
        }

        //save filtered data
        updateFilteredValue(context, table, filteredData);

        table.setRowIndex(-1);  //reset datamodel
    }
    
    public void updateFilteredValue(FacesContext context, DataTable table, List<?> value) {
        table.setSelectableDataModelWrapper(null);
        ValueExpression ve = table.getValueExpression("filteredValue");
        
        if(ve != null) {
            ve.setValue(context.getELContext(), value);
        }
        else {
            if(value != null) {
                logger.log(Level.WARNING, "DataTable {0} has filtering enabled but no filteredValue model reference is defined"
                    + ", for backward compatibility falling back to page viewstate method to keep filteredValue."
                    + " It is highly suggested to use filtering with a filteredValue model reference as viewstate method is deprecated and will be removed in future."
                    , new Object[]{table.getClientId(context)});
            
            }
            
            table.setFilteredValue(value);
        }
    }
    
    private Map<String,Object> populateFilterParameterMap(FacesContext context, DataTable table, List<FilterMeta> filterMetadata, String globalFilterParam) {
        Map<String,String> params = context.getExternalContext().getRequestParameterMap(); 
        Map<String,Object> filterParameterMap = new HashMap<String, Object>();

        for(FilterMeta filterMeta : filterMetadata) {
            Object filterValue = filterMeta.getFilterValue();
            UIColumn column = filterMeta.getColumn();
            
            if(filterValue != null && !filterValue.toString().trim().equals(Constants.EMPTY_STRING)) {
                String filterField = null;
                ValueExpression filterByVE = column.getValueExpression("filterBy");
                
                if(column.isDynamic()) {
                    ((DynamicColumn) column).applyStatelessModel();
                    Object filterByProperty = column.getSortBy();
                    filterField = (filterByProperty == null) ? table.resolveDynamicField(filterByVE) : filterByProperty.toString();
                }
                else {
                    filterField = (filterByVE == null) ? (String) column.getFilterBy(): table.resolveStaticField(filterByVE);
                }

                filterParameterMap.put(filterField, filterValue);
            }
        }

        if(params.containsKey(globalFilterParam)) {
            filterParameterMap.put("globalFilter", params.get(globalFilterParam));
        }
        
        return filterParameterMap;
    }
    
    private List<FilterMeta> populateFilterMetaData(FacesContext context, DataTable table) {
        List<FilterMeta> filterMetadata = new ArrayList<FilterMeta>();
        String separator = String.valueOf(UINamingContainer.getSeparatorChar(context));
        String var = table.getVar();
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();

        ColumnGroup group = getColumnGroup(table, "header");
        if(group != null) {
            for(UIComponent child : group.getChildren()) {
                Row headerRow = (Row) child;

                if(headerRow.isRendered()) {
                    for(UIComponent headerRowChild : headerRow.getChildren()) {
                        Column column = (Column) headerRowChild;

                        if(column.isRendered()) {
                            ValueExpression columnFilterByVE = column.getValueExpression("filterBy");
                            Object filterByProperty = column.getFilterBy();
                            
                            if(columnFilterByVE != null || filterByProperty != null) {
                                ValueExpression filterByVE = (columnFilterByVE != null) ? columnFilterByVE : createFilterByVE(context, var, filterByProperty);
                                UIComponent filterFacet = column.getFacet("filter");
                                Object filterValue;
                                
                                if(filterFacet == null)
                                    filterValue = params.get(column.getClientId(context) + separator + "filter");
                                else
                                    filterValue = ((ValueHolder) filterFacet).getLocalValue();

                                filterMetadata.add(new FilterMeta(column, filterByVE, filterValue));
                            }
                        }
                    }
                }
            }
        } 
        else {
            for(UIColumn column : table.getColumns()) {
                ValueExpression columnFilterByVE = column.getValueExpression("filterBy");
                Object filterByProperty = column.getFilterBy();
                
                if (columnFilterByVE != null || filterByProperty != null) {
                    UIComponent filterFacet = column.getFacet("filter");
                    Object filterValue = null;
                    ValueExpression filterByVE = null;
                    String filterId = null;
                    
                    if(column instanceof Column) {
                        filterByVE = (columnFilterByVE != null) ? columnFilterByVE : createFilterByVE(context, var, filterByProperty);
                        filterId = column.getClientId(context) + separator + "filter";
                    }
                    else if(column instanceof DynamicColumn) {
                        DynamicColumn dynamicColumn = (DynamicColumn) column;
                        dynamicColumn.applyStatelessModel();
                        filterByVE = (filterByProperty == null) ? columnFilterByVE : createFilterByVE(context, var, filterByProperty);
                        filterId = dynamicColumn.getContainerClientId(context) + separator + "filter";
                    }  
                    
                    if(filterFacet == null)
                        filterValue = params.get(filterId);
                    else
                        filterValue = ((ValueHolder) filterFacet).getLocalValue();

                    filterMetadata.add(new FilterMeta(column, filterByVE, filterValue));
                }
            }
        }

      return filterMetadata;
   }
    
   private ColumnGroup getColumnGroup(DataTable table, String target) {
        for(UIComponent child : table.getChildren()) {
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
   
    public FilterConstraint getFilterConstraint(UIColumn column) {
        String filterMatchMode = column.getFilterMatchMode();
        FilterConstraint filterConstraint  = FILTER_CONSTRAINTS.get(filterMatchMode);
        
        if(filterConstraint == null) { 
            throw new FacesException("Illegal filter match mode:" + filterMatchMode);
        }

        return filterConstraint;
    }
    
    private ValueExpression createFilterByVE(FacesContext context, String var, Object filterBy) {
        ELContext elContext = context.getELContext();
        return context.getApplication().getExpressionFactory().createValueExpression(elContext, "#{" + var + "." + filterBy + "}", Object.class);
    }
    
    private class FilterMeta {
        
        private UIColumn column;
        private ValueExpression filterByVE;
        private Object filterValue;

        public FilterMeta(UIColumn column, ValueExpression filterByVE, Object filterValue) {
            this.column = column;
            this.filterByVE = filterByVE;
            this.filterValue = filterValue;
        }

        public UIColumn getColumn() {
            return column;
        }

        public ValueExpression getFilterByVE() {
            return filterByVE;
        }

        public Object getFilterValue() {
            return filterValue;
        }        
        
    }
}