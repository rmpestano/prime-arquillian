/*
 * Copyright 2009-2014 PrimeTek.
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
import java.util.Map;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.datatable.DataTableRenderer;

public class ScrollFeature implements DataTableFeature {

    public void decode(FacesContext context, DataTable table) {
        throw new RuntimeException("RowScrollFeature should not decode.");
    }

    public void encode(FacesContext context, DataTableRenderer renderer, DataTable table) throws IOException {
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        int scrollOffset = Integer.parseInt(params.get(table.getClientId(context) + "_scrollOffset"));
        int scrollRows = table.getScrollRows();
        String clientId = table.getClientId(context);
        table.setScrollOffset(scrollOffset);

        if (table.isLazy()) {
            table.loadLazyScrollData(scrollOffset, scrollRows);
        }
        
        if (table.isSelectionEnabled()) {
            table.findSelectedRowKeys();
        }

        for (int i = scrollOffset; i < (scrollOffset + table.getScrollRows()); i++) {
            table.setRowIndex(i);

            if (table.isRowAvailable()) {
                renderer.encodeRow(context, table, clientId, i);
            }
        }
    }

    public boolean shouldDecode(FacesContext context, DataTable table) {
        return false;
    }

    public boolean shouldEncode(FacesContext context, DataTable table) {
        return context.getExternalContext().getRequestParameterMap().containsKey(table.getClientId(context) + "_scrolling");
    }
    
}