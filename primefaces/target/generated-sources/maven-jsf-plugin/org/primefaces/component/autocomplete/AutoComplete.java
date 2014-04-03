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
package org.primefaces.component.autocomplete;

import javax.faces.component.html.HtmlInputText;
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
import org.primefaces.component.calendar.Calendar;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.HTML;
import org.primefaces.util.ArrayUtils;
import org.primefaces.util.Constants;
import org.primefaces.component.column.Column;
import javax.faces.component.UIComponent;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.FacesEvent;
import javax.faces.event.PhaseId;
import javax.el.ValueExpression;
import javax.faces.convert.Converter;
import javax.faces.component.behavior.Behavior;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="primefaces.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class AutoComplete extends HtmlInputText implements org.primefaces.component.api.Widget,org.primefaces.component.api.InputHolder,org.primefaces.component.api.MixedClientBehaviorHolder {


	public static final String COMPONENT_TYPE = "org.primefaces.component.AutoComplete";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.AutoCompleteRenderer";

	protected enum PropertyKeys {

		placeholder
		,widgetVar
		,completeMethod
		,var
		,itemLabel
		,itemValue
		,maxResults
		,minQueryLength
		,queryDelay
		,queryDeletionDelay
		,forceSelection
		,scrollHeight
		,effect
		,effectDuration
		,dropdown
		,panelStyle
		,panelStyleClass
		,multiple
		,itemtipMyPosition
		,itemtipAtPosition
		,cache
		,cacheTimeout
		,emptyMessage
		,appendTo;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public AutoComplete() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public java.lang.String getPlaceholder() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.placeholder, null);
	}
	public void setPlaceholder(java.lang.String _placeholder) {
		getStateHelper().put(PropertyKeys.placeholder, _placeholder);
	}

	public java.lang.String getWidgetVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}
	public void setWidgetVar(java.lang.String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}

	public javax.el.MethodExpression getCompleteMethod() {
		return (javax.el.MethodExpression) getStateHelper().eval(PropertyKeys.completeMethod, null);
	}
	public void setCompleteMethod(javax.el.MethodExpression _completeMethod) {
		getStateHelper().put(PropertyKeys.completeMethod, _completeMethod);
	}

	public java.lang.String getVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.var, null);
	}
	public void setVar(java.lang.String _var) {
		getStateHelper().put(PropertyKeys.var, _var);
	}

	public java.lang.String getItemLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.itemLabel, null);
	}
	public void setItemLabel(java.lang.String _itemLabel) {
		getStateHelper().put(PropertyKeys.itemLabel, _itemLabel);
	}

	public java.lang.Object getItemValue() {
		return (java.lang.Object) getStateHelper().eval(PropertyKeys.itemValue, null);
	}
	public void setItemValue(java.lang.Object _itemValue) {
		getStateHelper().put(PropertyKeys.itemValue, _itemValue);
	}

	public int getMaxResults() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.maxResults, java.lang.Integer.MAX_VALUE);
	}
	public void setMaxResults(int _maxResults) {
		getStateHelper().put(PropertyKeys.maxResults, _maxResults);
	}

	public int getMinQueryLength() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.minQueryLength, 1);
	}
	public void setMinQueryLength(int _minQueryLength) {
		getStateHelper().put(PropertyKeys.minQueryLength, _minQueryLength);
	}

	public int getQueryDelay() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.queryDelay, 300);
	}
	public void setQueryDelay(int _queryDelay) {
		getStateHelper().put(PropertyKeys.queryDelay, _queryDelay);
	}

	public int getQueryDeletionDelay() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.queryDeletionDelay, 600);
	}
	public void setQueryDeletionDelay(int _queryDeletionDelay) {
		getStateHelper().put(PropertyKeys.queryDeletionDelay, _queryDeletionDelay);
	}

	public boolean isForceSelection() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.forceSelection, false);
	}
	public void setForceSelection(boolean _forceSelection) {
		getStateHelper().put(PropertyKeys.forceSelection, _forceSelection);
	}

	public int getScrollHeight() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.scrollHeight, java.lang.Integer.MAX_VALUE);
	}
	public void setScrollHeight(int _scrollHeight) {
		getStateHelper().put(PropertyKeys.scrollHeight, _scrollHeight);
	}

	public java.lang.String getEffect() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.effect, null);
	}
	public void setEffect(java.lang.String _effect) {
		getStateHelper().put(PropertyKeys.effect, _effect);
	}

	public int getEffectDuration() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.effectDuration, 400);
	}
	public void setEffectDuration(int _effectDuration) {
		getStateHelper().put(PropertyKeys.effectDuration, _effectDuration);
	}

	public boolean isDropdown() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.dropdown, false);
	}
	public void setDropdown(boolean _dropdown) {
		getStateHelper().put(PropertyKeys.dropdown, _dropdown);
	}

	public java.lang.String getPanelStyle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.panelStyle, null);
	}
	public void setPanelStyle(java.lang.String _panelStyle) {
		getStateHelper().put(PropertyKeys.panelStyle, _panelStyle);
	}

	public java.lang.String getPanelStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.panelStyleClass, null);
	}
	public void setPanelStyleClass(java.lang.String _panelStyleClass) {
		getStateHelper().put(PropertyKeys.panelStyleClass, _panelStyleClass);
	}

	public boolean isMultiple() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.multiple, false);
	}
	public void setMultiple(boolean _multiple) {
		getStateHelper().put(PropertyKeys.multiple, _multiple);
	}

	public java.lang.String getItemtipMyPosition() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.itemtipMyPosition, null);
	}
	public void setItemtipMyPosition(java.lang.String _itemtipMyPosition) {
		getStateHelper().put(PropertyKeys.itemtipMyPosition, _itemtipMyPosition);
	}

	public java.lang.String getItemtipAtPosition() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.itemtipAtPosition, null);
	}
	public void setItemtipAtPosition(java.lang.String _itemtipAtPosition) {
		getStateHelper().put(PropertyKeys.itemtipAtPosition, _itemtipAtPosition);
	}

	public boolean isCache() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.cache, false);
	}
	public void setCache(boolean _cache) {
		getStateHelper().put(PropertyKeys.cache, _cache);
	}

	public int getCacheTimeout() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.cacheTimeout, 300000);
	}
	public void setCacheTimeout(int _cacheTimeout) {
		getStateHelper().put(PropertyKeys.cacheTimeout, _cacheTimeout);
	}

	public java.lang.String getEmptyMessage() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.emptyMessage, null);
	}
	public void setEmptyMessage(java.lang.String _emptyMessage) {
		getStateHelper().put(PropertyKeys.emptyMessage, _emptyMessage);
	}

	public java.lang.String getAppendTo() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.appendTo, null);
	}
	public void setAppendTo(java.lang.String _appendTo) {
		getStateHelper().put(PropertyKeys.appendTo, _appendTo);
	}


    private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("blur","change","valueChange","click","dblclick","focus","keydown","keypress","keyup","mousedown","mousemove","mouseout","mouseover","mouseup","select", "itemSelect", "itemUnselect", "query"));
    
    public final static String STYLE_CLASS = "ui-autocomplete";
    public final static String MULTIPLE_STYLE_CLASS = "ui-autocomplete-multiple";
    public final static String INPUT_CLASS = "ui-autocomplete-input ui-inputfield ui-widget ui-state-default ui-corner-all";
    public final static String INPUT_WITH_DROPDOWN_CLASS = "ui-autocomplete-input ui-inputfield ui-widget ui-state-default ui-corner-left";
    public final static String DROPDOWN_CLASS = "ui-autocomplete-dropdown ui-button ui-widget ui-state-default ui-corner-right ui-button-icon-only";
    public final static String PANEL_CLASS = "ui-autocomplete-panel ui-widget-content ui-corner-all ui-helper-hidden ui-shadow";
    public final static String LIST_CLASS = "ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset";
    public final static String TABLE_CLASS = "ui-autocomplete-items ui-autocomplete-table ui-widget-content ui-widget ui-corner-all ui-helper-reset";
    public final static String ITEM_CLASS = "ui-autocomplete-item ui-autocomplete-list-item ui-corner-all";
    public final static String ROW_CLASS = "ui-autocomplete-item ui-autocomplete-row ui-corner-all";
    public final static String TOKEN_DISPLAY_CLASS = "ui-autocomplete-token ui-state-active ui-corner-all";
    public final static String TOKEN_LABEL_CLASS = "ui-autocomplete-token-label";
    public final static String TOKEN_ICON_CLASS = "ui-autocomplete-token-icon ui-icon ui-icon-close";
    public final static String TOKEN_INPUT_CLASS = "ui-autocomplete-input-token";
    public final static String MULTIPLE_CONTAINER_CLASS = "ui-autocomplete-multiple-container ui-widget ui-inputfield ui-state-default ui-corner-all";
    public final static String ITEMTIP_CONTENT_CLASS = "ui-autocomplete-itemtip-content";

    public final static String MOBILE_INPUT_CONTAINER_CLASS = "ui-input-search ui-body-inherit ui-corner-all ui-shadow-inset ui-input-has-clear";
    public final static String MOBILE_PANEL_CLASS = "ui-controlgroup ui-controlgroup-vertical ui-corner-all ui-screen-hidden";
    public final static String MOBILE_ITEM_CONTAINER_CLASS = "ui-controlgroup-controls";
    public final static String MOBILE_ITEM_CLASS = "ui-autocomplete-item ui-btn ui-corner-all ui-shadow";
    public final static String MOBILE_CLEAR_ICON_CLASS = "ui-input-clear ui-btn ui-icon-delete ui-btn-icon-notext ui-corner-all ui-input-clear-hidden";

    @Override
    public Collection<String> getEventNames() {
        return EVENT_NAMES;
    }

    public Collection<String> getUnobstrusiveEventNames() {
        return Collections.unmodifiableCollection(Arrays.asList("itemSelect", "itemUnselect", "query"));
    }

    @Override
    public void queueEvent(FacesEvent event) {
        FacesContext context = getFacesContext();
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String eventName = params.get(Constants.RequestParams.PARTIAL_BEHAVIOR_EVENT_PARAM);

        if(eventName != null && event instanceof AjaxBehaviorEvent) {
            AjaxBehaviorEvent ajaxBehaviorEvent = (AjaxBehaviorEvent) event;

            if(eventName.equals("itemSelect")) {
                Object selectedItemValue = convertValue(context, params.get(this.getClientId(context) + "_itemSelect"));
                SelectEvent selectEvent = new SelectEvent(this, (Behavior) ajaxBehaviorEvent.getBehavior(), selectedItemValue);
                selectEvent.setPhaseId(ajaxBehaviorEvent.getPhaseId());
                super.queueEvent(selectEvent);
            }
            else if(eventName.equals("itemUnselect")) {
                Object unselectedItemValue = convertValue(context, params.get(this.getClientId(context) + "_itemUnselect"));
                UnselectEvent unselectEvent = new UnselectEvent(this, (Behavior) ajaxBehaviorEvent.getBehavior(), unselectedItemValue);
                unselectEvent.setPhaseId(ajaxBehaviorEvent.getPhaseId());
                super.queueEvent(unselectEvent);
            }
            else {
                //e.g. blur, focus, change
                super.queueEvent(event);
            }
        }
        else {
            //e.g. valueChange, autoCompleteEvent
            super.queueEvent(event);
        }
    }

    private List suggestions = null;

    public void broadcast(javax.faces.event.FacesEvent event) throws javax.faces.event.AbortProcessingException {
		super.broadcast(event);
		
		FacesContext facesContext = getFacesContext();
		MethodExpression me = getCompleteMethod();
		
		if(me != null && event instanceof org.primefaces.event.AutoCompleteEvent) {
			suggestions = (List) me.invoke(facesContext.getELContext(), new Object[] {((org.primefaces.event.AutoCompleteEvent) event).getQuery()});
            
            if(suggestions == null) {
                suggestions = new ArrayList();
            }

            facesContext.renderResponse();
		}
	}

    public List<Column> getColums() {
        List<Column> columns = new ArrayList<Column>();
        
        for(UIComponent kid : this.getChildren()) {
            if(kid instanceof Column)
                columns.add((Column) kid);
        }

        return columns;
    }

    public List getSuggestions() {
        return this.suggestions;
    }

    private Object convertValue(FacesContext context, String submittedItemValue) {
        Converter converter = ComponentUtils.getConverter(context, this);

        if(converter == null)
            return submittedItemValue;
        else 
            return converter.getAsObject(context, this, submittedItemValue);
    }

    public String getInputClientId() {
        return this.getClientId(getFacesContext()) + "_input";
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