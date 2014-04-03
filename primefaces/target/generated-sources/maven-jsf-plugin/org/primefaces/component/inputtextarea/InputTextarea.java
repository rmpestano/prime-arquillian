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
package org.primefaces.component.inputtextarea;

import javax.faces.component.html.HtmlInputTextarea;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.FacesEvent;
import javax.faces.event.PhaseId;
import javax.el.ValueExpression;
import javax.faces.convert.Converter;
import javax.faces.component.behavior.Behavior;
import javax.el.MethodExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.util.Constants;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="primefaces.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class InputTextarea extends HtmlInputTextarea implements org.primefaces.component.api.Widget,org.primefaces.component.api.MixedClientBehaviorHolder {


	public static final String COMPONENT_TYPE = "org.primefaces.component.InputTextarea";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.InputTextareaRenderer";

	protected enum PropertyKeys {

		placeholder
		,widgetVar
		,autoResize
		,maxlength
		,counter
		,counterTemplate
		,completeMethod
		,minQueryLength
		,queryDelay
		,scrollHeight
		,addLine;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public InputTextarea() {
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

	public boolean isAutoResize() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.autoResize, true);
	}
	public void setAutoResize(boolean _autoResize) {
		getStateHelper().put(PropertyKeys.autoResize, _autoResize);
	}

	public int getMaxlength() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.maxlength, java.lang.Integer.MAX_VALUE);
	}
	public void setMaxlength(int _maxlength) {
		getStateHelper().put(PropertyKeys.maxlength, _maxlength);
	}

	public java.lang.String getCounter() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.counter, null);
	}
	public void setCounter(java.lang.String _counter) {
		getStateHelper().put(PropertyKeys.counter, _counter);
	}

	public java.lang.String getCounterTemplate() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.counterTemplate, null);
	}
	public void setCounterTemplate(java.lang.String _counterTemplate) {
		getStateHelper().put(PropertyKeys.counterTemplate, _counterTemplate);
	}

	public javax.el.MethodExpression getCompleteMethod() {
		return (javax.el.MethodExpression) getStateHelper().eval(PropertyKeys.completeMethod, null);
	}
	public void setCompleteMethod(javax.el.MethodExpression _completeMethod) {
		getStateHelper().put(PropertyKeys.completeMethod, _completeMethod);
	}

	public int getMinQueryLength() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.minQueryLength, 3);
	}
	public void setMinQueryLength(int _minQueryLength) {
		getStateHelper().put(PropertyKeys.minQueryLength, _minQueryLength);
	}

	public int getQueryDelay() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.queryDelay, 700);
	}
	public void setQueryDelay(int _queryDelay) {
		getStateHelper().put(PropertyKeys.queryDelay, _queryDelay);
	}

	public int getScrollHeight() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.scrollHeight, java.lang.Integer.MAX_VALUE);
	}
	public void setScrollHeight(int _scrollHeight) {
		getStateHelper().put(PropertyKeys.scrollHeight, _scrollHeight);
	}

	public boolean isAddLine() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.addLine, false);
	}
	public void setAddLine(boolean _addLine) {
		getStateHelper().put(PropertyKeys.addLine, _addLine);
	}


    private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("blur","change","valueChange","click","dblclick","focus","keydown","keypress","keyup","mousedown","mousemove","mouseout","mouseover","mouseup","select", "itemSelect"));

    public final static String STYLE_CLASS = "ui-inputfield ui-inputtextarea ui-widget ui-state-default ui-corner-all";
    public final static String MOBILE_STYLE_CLASS = "ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all";

    @Override
    public Collection<String> getEventNames() {
        return EVENT_NAMES;
    }

    public Collection<String> getUnobstrusiveEventNames() {
        return Collections.unmodifiableCollection(Arrays.asList("itemSelect"));
    }

    @Override
    public int getCols() {
        int cols = super.getCols();
    
        return cols > 0 ? cols : 20;
    }

    @Override
    public int getRows() {
        int rows = super.getRows();
    
        return rows > 0 ? rows : 3;
    }

    @Override
    public void queueEvent(FacesEvent event) {
        FacesContext context = getFacesContext();
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String eventName = params.get(Constants.RequestParams.PARTIAL_BEHAVIOR_EVENT_PARAM);

        if(eventName != null && event instanceof AjaxBehaviorEvent) {
            AjaxBehaviorEvent ajaxBehaviorEvent = (AjaxBehaviorEvent) event;

            if(eventName.equals("itemSelect")) {
                String selectedItemValue = params.get(this.getClientId(context) + "_itemSelect");
                SelectEvent selectEvent = new SelectEvent(this, (Behavior) ajaxBehaviorEvent.getBehavior(), selectedItemValue);
                selectEvent.setPhaseId(ajaxBehaviorEvent.getPhaseId());
                super.queueEvent(selectEvent);
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

    public List getSuggestions() {
        return this.suggestions;
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