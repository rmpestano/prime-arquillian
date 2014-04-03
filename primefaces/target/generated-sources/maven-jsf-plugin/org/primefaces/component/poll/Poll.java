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
package org.primefaces.component.poll;

import javax.faces.component.UIComponentBase;
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
import javax.el.ValueExpression;
import org.primefaces.context.RequestContext;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class Poll extends UIComponentBase implements org.primefaces.component.api.AjaxSource,org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Poll";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.PollRenderer";

	protected enum PropertyKeys {

		widgetVar
		,interval
		,update
		,listener
		,immediate
		,onstart
		,oncomplete
		,process
		,onerror
		,onsuccess
		,global
		,delay
		,async
		,autoStart
		,stop
		,partialSubmit
		,resetValues
		,ignoreAutoUpdate;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public Poll() {
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

	public int getInterval() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.interval, 2);
	}
	public void setInterval(int _interval) {
		getStateHelper().put(PropertyKeys.interval, _interval);
	}

	public java.lang.String getUpdate() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.update, null);
	}
	public void setUpdate(java.lang.String _update) {
		getStateHelper().put(PropertyKeys.update, _update);
	}

	public javax.el.MethodExpression getListener() {
		return (javax.el.MethodExpression) getStateHelper().eval(PropertyKeys.listener, null);
	}
	public void setListener(javax.el.MethodExpression _listener) {
		getStateHelper().put(PropertyKeys.listener, _listener);
	}

	public boolean isImmediate() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.immediate, false);
	}
	public void setImmediate(boolean _immediate) {
		getStateHelper().put(PropertyKeys.immediate, _immediate);
	}

	public java.lang.String getOnstart() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onstart, null);
	}
	public void setOnstart(java.lang.String _onstart) {
		getStateHelper().put(PropertyKeys.onstart, _onstart);
	}

	public java.lang.String getOncomplete() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.oncomplete, null);
	}
	public void setOncomplete(java.lang.String _oncomplete) {
		getStateHelper().put(PropertyKeys.oncomplete, _oncomplete);
	}

	public java.lang.String getProcess() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.process, null);
	}
	public void setProcess(java.lang.String _process) {
		getStateHelper().put(PropertyKeys.process, _process);
	}

	public java.lang.String getOnerror() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onerror, null);
	}
	public void setOnerror(java.lang.String _onerror) {
		getStateHelper().put(PropertyKeys.onerror, _onerror);
	}

	public java.lang.String getOnsuccess() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onsuccess, null);
	}
	public void setOnsuccess(java.lang.String _onsuccess) {
		getStateHelper().put(PropertyKeys.onsuccess, _onsuccess);
	}

	public boolean isGlobal() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.global, true);
	}
	public void setGlobal(boolean _global) {
		getStateHelper().put(PropertyKeys.global, _global);
	}

	public java.lang.String getDelay() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.delay, null);
	}
	public void setDelay(java.lang.String _delay) {
		getStateHelper().put(PropertyKeys.delay, _delay);
	}

	public boolean isAsync() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.async, false);
	}
	public void setAsync(boolean _async) {
		getStateHelper().put(PropertyKeys.async, _async);
	}

	public boolean isAutoStart() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.autoStart, true);
	}
	public void setAutoStart(boolean _autoStart) {
		getStateHelper().put(PropertyKeys.autoStart, _autoStart);
	}

	public boolean isStop() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.stop, false);
	}
	public void setStop(boolean _stop) {
		getStateHelper().put(PropertyKeys.stop, _stop);
	}

	public boolean isPartialSubmit() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.partialSubmit, false);
	}
	public void setPartialSubmit(boolean _partialSubmit) {
		getStateHelper().put(PropertyKeys.partialSubmit, _partialSubmit);
	}

	public boolean isResetValues() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.resetValues, false);
	}
	public void setResetValues(boolean _resetValues) {
		getStateHelper().put(PropertyKeys.resetValues, _resetValues);
	}

	public boolean isIgnoreAutoUpdate() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.ignoreAutoUpdate, false);
	}
	public void setIgnoreAutoUpdate(boolean _ignoreAutoUpdate) {
		getStateHelper().put(PropertyKeys.ignoreAutoUpdate, _ignoreAutoUpdate);
	}


    public void broadcast(javax.faces.event.FacesEvent event) throws javax.faces.event.AbortProcessingException {
		super.broadcast(event); //backward compatibility

		FacesContext facesContext = getFacesContext();
		MethodExpression me = getListener();

		if (me != null) {
			me.invoke(facesContext.getELContext(), new Object[] {});
		}

        ValueExpression expr = getValueExpression("stop");
        if(expr != null) {
        	Boolean stop = (Boolean) expr.getValue(facesContext.getELContext());
        	
        	if (Boolean.TRUE.equals(stop)) {
        		String widgetVar = resolveWidgetVar();
        		RequestContext requestContext = RequestContext.getCurrentInstance();
        		requestContext.execute("PF('" + widgetVar + "').stop();");
        	}
        }
	}

    public boolean isPartialSubmitSet() {
        return (getStateHelper().get(PropertyKeys.partialSubmit) != null) || (this.getValueExpression("partialSubmit") != null);
    }
    
    public boolean isResetValuesSet() {
        return (getStateHelper().get(PropertyKeys.resetValues) != null) || (this.getValueExpression("resetValues") != null);
    }
    
    public boolean isAjaxified() {
        return true;
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