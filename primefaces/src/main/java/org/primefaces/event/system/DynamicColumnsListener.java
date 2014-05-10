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
package org.primefaces.event.system;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import org.primefaces.component.columns.Columns;
import org.primefaces.component.datatable.DataTable;

public class DynamicColumnsListener implements SystemEventListener {

    public void processEvent(SystemEvent event) throws AbortProcessingException {
        Columns columns = (Columns) event.getSource();
        
        if (columns.getParent() instanceof DataTable) {
        	((DataTable) columns.getParent()).setDynamicColumns(columns);
        }
    }

    public boolean isListenerForSource(Object source) {
        return true;
    }
    
}
