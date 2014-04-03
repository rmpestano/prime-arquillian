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
package org.primefaces.component.layout;

import javax.faces.component.UIPanel;
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
import javax.faces.component.UIComponent;
import org.primefaces.component.layout.LayoutUnit;
import java.util.Map;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.primefaces.util.Constants;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ResizeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.FacesEvent;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="primefaces.css"),
	@ResourceDependency(library="primefaces", name="layout/layout.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js"),
	@ResourceDependency(library="primefaces", name="layout/layout.js")
})
public class Layout extends UIPanel implements org.primefaces.component.api.Widget,javax.faces.component.behavior.ClientBehaviorHolder {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Layout";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.LayoutRenderer";

	protected enum PropertyKeys {

		widgetVar
		,fullPage
		,style
		,styleClass
		,onResize
		,onClose
		,onToggle
		,resizeTitle
		,collapseTitle
		,expandTitle
		,closeTitle
		,stateful;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public Layout() {
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

	public boolean isFullPage() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.fullPage, false);
	}
	public void setFullPage(boolean _fullPage) {
		getStateHelper().put(PropertyKeys.fullPage, _fullPage);
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

	public java.lang.String getOnResize() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onResize, null);
	}
	public void setOnResize(java.lang.String _onResize) {
		getStateHelper().put(PropertyKeys.onResize, _onResize);
	}

	public java.lang.String getOnClose() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onClose, null);
	}
	public void setOnClose(java.lang.String _onClose) {
		getStateHelper().put(PropertyKeys.onClose, _onClose);
	}

	public java.lang.String getOnToggle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onToggle, null);
	}
	public void setOnToggle(java.lang.String _onToggle) {
		getStateHelper().put(PropertyKeys.onToggle, _onToggle);
	}

	public java.lang.String getResizeTitle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.resizeTitle, null);
	}
	public void setResizeTitle(java.lang.String _resizeTitle) {
		getStateHelper().put(PropertyKeys.resizeTitle, _resizeTitle);
	}

	public java.lang.String getCollapseTitle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.collapseTitle, "Collapse");
	}
	public void setCollapseTitle(java.lang.String _collapseTitle) {
		getStateHelper().put(PropertyKeys.collapseTitle, _collapseTitle);
	}

	public java.lang.String getExpandTitle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.expandTitle, null);
	}
	public void setExpandTitle(java.lang.String _expandTitle) {
		getStateHelper().put(PropertyKeys.expandTitle, _expandTitle);
	}

	public java.lang.String getCloseTitle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.closeTitle, "Close");
	}
	public void setCloseTitle(java.lang.String _closeTitle) {
		getStateHelper().put(PropertyKeys.closeTitle, _closeTitle);
	}

	public boolean isStateful() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.stateful, false);
	}
	public void setStateful(boolean _stateful) {
		getStateHelper().put(PropertyKeys.stateful, _stateful);
	}


    public final static String UNIT_CLASS = "ui-layout-unit ui-widget ui-widget-content ui-corner-all";
    public final static String UNIT_HEADER_CLASS = "ui-layout-unit-header ui-widget-header ui-corner-all";
    public final static String UNIT_CONTENT_CLASS = "ui-layout-unit-content ui-widget-content";
    public final static String UNIT_FOOTER_CLASS = "ui-layout-unit-footer ui-widget-header ui-corner-all";
    public final static String UNIT_HEADER_TITLE_CLASS = "ui-layout-unit-header-title";
    public final static String UNIT_FOOTER_TITLE_CLASS = "ui-layout-unit-footer-title";
    public final static String UNIT_HEADER_ICON_CLASS = "ui-layout-unit-header-icon ui-state-default ui-corner-all";

    private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("toggle","close", "resize"));

	protected LayoutUnit getLayoutUnitByPosition(String name) {
		for(UIComponent child : getChildren()) {
			if(child instanceof LayoutUnit) {
				LayoutUnit layoutUnit = (LayoutUnit) child;
				
				if(layoutUnit.getPosition().equalsIgnoreCase(name))
					return layoutUnit;
			}
		}
		
		return null;
	}
	
    public boolean isNested() {
        return this.getParent() instanceof LayoutUnit;
    }

    public boolean isElementLayout() {
        return !isNested() && !isFullPage();
    }

    @Override
    public Collection<String> getEventNames() {
        return EVENT_NAMES;
    }

    @Override
    public void processDecodes(FacesContext context) {
        if(isSelfRequest(context)) {
            this.decode(context);
        }
        else {
            super.processDecodes(context);
        }
    }

    @Override
    public void processValidators(FacesContext context) {
        if(!isSelfRequest(context)) {
            super.processValidators(context);
        }
    }

    @Override
    public void processUpdates(FacesContext context) {
        if(!isSelfRequest(context)) {
            super.processUpdates(context);
        }
    }

    private boolean isSelfRequest(FacesContext context) {
        return this.getClientId(context).equals(context.getExternalContext().getRequestParameterMap().get(Constants.RequestParams.PARTIAL_SOURCE_PARAM));
    }

    @Override
    public void queueEvent(FacesEvent event) {
        FacesContext context = getFacesContext();
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        String eventName = params.get(Constants.RequestParams.PARTIAL_BEHAVIOR_EVENT_PARAM);
        String clientId = this.getClientId(context);

        if(isSelfRequest(context)) {

            AjaxBehaviorEvent behaviorEvent = (AjaxBehaviorEvent) event;
            FacesEvent wrapperEvent = null;

            if(eventName.equals("toggle")) {
                boolean collapsed = Boolean.valueOf(params.get(clientId + "_collapsed"));
                LayoutUnit unit = getLayoutUnitByPosition(params.get(clientId + "_unit"));
                Visibility visibility = collapsed ? Visibility.HIDDEN : Visibility.VISIBLE;
                unit.setCollapsed(collapsed);
                
                wrapperEvent = new ToggleEvent(unit, behaviorEvent.getBehavior(), visibility);
            }
            else if(eventName.equals("close")) {
                LayoutUnit unit = getLayoutUnitByPosition(params.get(clientId + "_unit"));
                unit.setVisible(false);

                wrapperEvent = new CloseEvent(unit, behaviorEvent.getBehavior());
            }
            else if(eventName.equals("resize")) {
                LayoutUnit unit = getLayoutUnitByPosition(params.get(clientId + "_unit"));
                String position = unit.getPosition();
                int width = Integer.valueOf(params.get(clientId + "_width"));
                int height = Integer.valueOf(params.get(clientId + "_height"));

                if(position.equals("west") || position.equals("east")) {
                    unit.setSize(String.valueOf(width));
                } else if(position.equals("north") || position.equals("south")) {
                    unit.setSize(String.valueOf(height));
                }

                wrapperEvent = new ResizeEvent(unit, behaviorEvent.getBehavior(), width, height);
            }

            wrapperEvent.setPhaseId(behaviorEvent.getPhaseId());

            super.queueEvent(wrapperEvent);
        }
        else {
            super.queueEvent(event);
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