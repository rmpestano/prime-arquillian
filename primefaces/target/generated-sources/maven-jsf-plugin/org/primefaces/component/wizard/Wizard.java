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
package org.primefaces.component.wizard;

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
import java.util.Map;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.FlowEvent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.FacesEvent;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="primefaces.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class Wizard extends UIComponentBase implements org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Wizard";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.WizardRenderer";

	protected enum PropertyKeys {

		widgetVar
		,step
		,style
		,styleClass
		,flowListener
		,showNavBar
		,showStepStatus
		,onback
		,onnext
		,nextLabel
		,backLabel;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public Wizard() {
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

	public java.lang.String getStep() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.step, null);
	}
	public void setStep(java.lang.String _step) {
		getStateHelper().put(PropertyKeys.step, _step);
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

	public javax.el.MethodExpression getFlowListener() {
		return (javax.el.MethodExpression) getStateHelper().eval(PropertyKeys.flowListener, null);
	}
	public void setFlowListener(javax.el.MethodExpression _flowListener) {
		getStateHelper().put(PropertyKeys.flowListener, _flowListener);
	}

	public boolean isShowNavBar() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.showNavBar, true);
	}
	public void setShowNavBar(boolean _showNavBar) {
		getStateHelper().put(PropertyKeys.showNavBar, _showNavBar);
	}

	public boolean isShowStepStatus() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.showStepStatus, true);
	}
	public void setShowStepStatus(boolean _showStepStatus) {
		getStateHelper().put(PropertyKeys.showStepStatus, _showStepStatus);
	}

	public java.lang.String getOnback() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onback, null);
	}
	public void setOnback(java.lang.String _onback) {
		getStateHelper().put(PropertyKeys.onback, _onback);
	}

	public java.lang.String getOnnext() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onnext, null);
	}
	public void setOnnext(java.lang.String _onnext) {
		getStateHelper().put(PropertyKeys.onnext, _onnext);
	}

	public java.lang.String getNextLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.nextLabel, "Next");
	}
	public void setNextLabel(java.lang.String _nextLabel) {
		getStateHelper().put(PropertyKeys.nextLabel, _nextLabel);
	}

	public java.lang.String getBackLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.backLabel, "Back");
	}
	public void setBackLabel(java.lang.String _backLabel) {
		getStateHelper().put(PropertyKeys.backLabel, _backLabel);
	}


    public final static String STEP_STATUS_CLASS = "ui-wizard-step-titles ui-helper-reset ui-helper-clearfix";
	public final static String STEP_CLASS = "ui-wizard-step-title ui-state-default ui-corner-all";
    public final static String ACTIVE_STEP_CLASS = "ui-wizard-step-title ui-state-default ui-state-highlight ui-corner-all";
	public final static String BACK_BUTTON_CLASS = "ui-wizard-nav-back";
	public final static String NEXT_BUTTON_CLASS = "ui-wizard-nav-next";
	
	private Tab current;

	public void processDecodes(FacesContext context) {
        this.decode(context);

		if(!isBackRequest(context)) {
			getStepToProcess().processDecodes(context);
		}
    }
	
	public void processValidators(FacesContext context) {
        if(!isBackRequest(context)) {
			current.processValidators(context);
		}
    }
	
	public void processUpdates(FacesContext context) {
		if(!isBackRequest(context)) {
			current.processUpdates(context);
		}
	}
	
	public Tab getStepToProcess() {
		if(current == null) {
			String currentStepId = getStep();
			
			for(UIComponent child : getChildren()) {
				if(child.getId().equals(currentStepId)) {
					current = (Tab) child;
					
					break;
				}
			}
		}
		
		return current;
	}
	
	public boolean isWizardRequest(FacesContext context) {
		return context.getExternalContext().getRequestParameterMap().containsKey(getClientId(context) + "_wizardRequest");
	}
	
	public boolean isBackRequest(FacesContext context) {
		return isWizardRequest(context) && context.getExternalContext().getRequestParameterMap().containsKey(getClientId(context) + "_backRequest");
	}

    @Override
    public void broadcast(FacesEvent event) throws AbortProcessingException {
        super.broadcast(event);

        if(event instanceof FlowEvent) {
            FlowEvent flowEvent = (FlowEvent) event;
            FacesContext context = getFacesContext();
            MethodExpression me = this.getFlowListener();

            if(me != null) {
                String step = (String) me.invoke(context.getELContext(), new Object[]{event});

                this.setStep(step);
            }
            else {
                this.setStep(flowEvent.getNewStep());
            }
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