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
package org.primefaces.component.dialog;

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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.primefaces.event.CloseEvent;
import org.primefaces.util.Constants;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.FacesEvent;
import javax.faces.event.PhaseId;
import javax.el.ELContext;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="primefaces.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class Dialog extends UIPanel implements org.primefaces.component.api.Widget,org.primefaces.component.api.RTLAware,javax.faces.component.behavior.ClientBehaviorHolder {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Dialog";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.DialogRenderer";

	protected enum PropertyKeys {

		widgetVar
		,header
		,draggable
		,resizable
		,modal
		,visible
		,width
		,height
		,minWidth
		,minHeight
		,style
		,styleClass
		,showEffect
		,hideEffect
		,position
		,closable
		,onShow
		,onHide
		,appendTo
		,showHeader
		,footer
		,dynamic
		,minimizable
		,maximizable
		,closeOnEscape
		,dir
		,focus
		,fitViewport;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public Dialog() {
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

	public java.lang.String getHeader() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.header, null);
	}
	public void setHeader(java.lang.String _header) {
		getStateHelper().put(PropertyKeys.header, _header);
	}

	public boolean isDraggable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.draggable, true);
	}
	public void setDraggable(boolean _draggable) {
		getStateHelper().put(PropertyKeys.draggable, _draggable);
	}

	public boolean isResizable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.resizable, true);
	}
	public void setResizable(boolean _resizable) {
		getStateHelper().put(PropertyKeys.resizable, _resizable);
	}

	public boolean isModal() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.modal, false);
	}
	public void setModal(boolean _modal) {
		getStateHelper().put(PropertyKeys.modal, _modal);
	}

	public boolean isVisible() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.visible, false);
	}
	public void setVisible(boolean _visible) {
		getStateHelper().put(PropertyKeys.visible, _visible);
	}

	public java.lang.String getWidth() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.width, null);
	}
	public void setWidth(java.lang.String _width) {
		getStateHelper().put(PropertyKeys.width, _width);
	}

	public java.lang.String getHeight() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.height, null);
	}
	public void setHeight(java.lang.String _height) {
		getStateHelper().put(PropertyKeys.height, _height);
	}

	public int getMinWidth() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.minWidth, java.lang.Integer.MIN_VALUE);
	}
	public void setMinWidth(int _minWidth) {
		getStateHelper().put(PropertyKeys.minWidth, _minWidth);
	}

	public int getMinHeight() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.minHeight, java.lang.Integer.MIN_VALUE);
	}
	public void setMinHeight(int _minHeight) {
		getStateHelper().put(PropertyKeys.minHeight, _minHeight);
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

	public java.lang.String getShowEffect() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.showEffect, null);
	}
	public void setShowEffect(java.lang.String _showEffect) {
		getStateHelper().put(PropertyKeys.showEffect, _showEffect);
	}

	public java.lang.String getHideEffect() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.hideEffect, null);
	}
	public void setHideEffect(java.lang.String _hideEffect) {
		getStateHelper().put(PropertyKeys.hideEffect, _hideEffect);
	}

	public java.lang.String getPosition() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.position, null);
	}
	public void setPosition(java.lang.String _position) {
		getStateHelper().put(PropertyKeys.position, _position);
	}

	public boolean isClosable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.closable, true);
	}
	public void setClosable(boolean _closable) {
		getStateHelper().put(PropertyKeys.closable, _closable);
	}

	public java.lang.String getOnShow() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onShow, null);
	}
	public void setOnShow(java.lang.String _onShow) {
		getStateHelper().put(PropertyKeys.onShow, _onShow);
	}

	public java.lang.String getOnHide() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onHide, null);
	}
	public void setOnHide(java.lang.String _onHide) {
		getStateHelper().put(PropertyKeys.onHide, _onHide);
	}

	public java.lang.String getAppendTo() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.appendTo, null);
	}
	public void setAppendTo(java.lang.String _appendTo) {
		getStateHelper().put(PropertyKeys.appendTo, _appendTo);
	}

	public boolean isShowHeader() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.showHeader, true);
	}
	public void setShowHeader(boolean _showHeader) {
		getStateHelper().put(PropertyKeys.showHeader, _showHeader);
	}

	public java.lang.String getFooter() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.footer, null);
	}
	public void setFooter(java.lang.String _footer) {
		getStateHelper().put(PropertyKeys.footer, _footer);
	}

	public boolean isDynamic() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.dynamic, false);
	}
	public void setDynamic(boolean _dynamic) {
		getStateHelper().put(PropertyKeys.dynamic, _dynamic);
	}

	public boolean isMinimizable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.minimizable, false);
	}
	public void setMinimizable(boolean _minimizable) {
		getStateHelper().put(PropertyKeys.minimizable, _minimizable);
	}

	public boolean isMaximizable() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.maximizable, false);
	}
	public void setMaximizable(boolean _maximizable) {
		getStateHelper().put(PropertyKeys.maximizable, _maximizable);
	}

	public boolean isCloseOnEscape() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.closeOnEscape, false);
	}
	public void setCloseOnEscape(boolean _closeOnEscape) {
		getStateHelper().put(PropertyKeys.closeOnEscape, _closeOnEscape);
	}

	public java.lang.String getDir() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.dir, "ltr");
	}
	public void setDir(java.lang.String _dir) {
		getStateHelper().put(PropertyKeys.dir, _dir);
	}

	public java.lang.String getFocus() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.focus, null);
	}
	public void setFocus(java.lang.String _focus) {
		getStateHelper().put(PropertyKeys.focus, _focus);
	}

	public boolean isFitViewport() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.fitViewport, false);
	}
	public void setFitViewport(boolean _fitViewport) {
		getStateHelper().put(PropertyKeys.fitViewport, _fitViewport);
	}


    public static final String CONTAINER_CLASS = "ui-dialog ui-widget ui-widget-content ui-overlay-hidden ui-corner-all ui-shadow";
    public static final String TITLE_BAR_CLASS = "ui-dialog-titlebar ui-widget-header ui-helper-clearfix ui-corner-top";
    public static final String TITLE_CLASS = "ui-dialog-title";
    public static final String TITLE_BAR_CLOSE_CLASS = "ui-dialog-titlebar-icon ui-dialog-titlebar-close ui-corner-all";
    public static final String CLOSE_ICON_CLASS = "ui-icon ui-icon-closethick";
    public static final String TITLE_BAR_MINIMIZE_CLASS = "ui-dialog-titlebar-icon ui-dialog-titlebar-minimize ui-corner-all";
    public static final String MINIMIZE_ICON_CLASS = "ui-icon ui-icon-minus";
    public static final String TITLE_BAR_MAXIMIZE_CLASS = "ui-dialog-titlebar-icon ui-dialog-titlebar-maximize ui-corner-all";
    public static final String MAXIMIZE_ICON_CLASS = "ui-icon ui-icon-extlink";
    public static final String CONTENT_CLASS = "ui-dialog-content ui-widget-content";
    public static final String FOOTER_CLASS = "ui-dialog-footer ui-widget-content";

    public static final String MOBILE_CONTAINER_CLASS = "ui-dialog-container";
    public static final String MOBILE_TITLE_BAR_CLASS = "ui-header ui-bar-inherit";
    public static final String MOBILE_TITLE_CLASS = "ui-title";
    public static final String MOBILE_CONTENT_CLASS = "ui-content";
    public static final String MOBILE_CLOSE_ICON_CLASS = "ui-btn ui-corner-all ui-icon-delete ui-btn-icon-notext ui-btn-left";

    private final static String DEFAULT_EVENT = "close";

    private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("close","minimize","maximize"));

    @Override
    public Collection<String> getEventNames() {
        return EVENT_NAMES;
    }

    @Override
    public String getDefaultEventName() {
        return DEFAULT_EVENT;
    }

    @Override
    public void queueEvent(FacesEvent event) {
        FacesContext context = getFacesContext();

        if(isRequestSource(context) && event instanceof AjaxBehaviorEvent) {
            String eventName = context.getExternalContext().getRequestParameterMap().get(Constants.RequestParams.PARTIAL_BEHAVIOR_EVENT_PARAM);
            AjaxBehaviorEvent ajaxBehaviorEvent = (AjaxBehaviorEvent) event;

            if(eventName.equals("close")) {
                setVisible(false);
                CloseEvent closeEvent = new CloseEvent(this, ((AjaxBehaviorEvent) event).getBehavior());
                closeEvent.setPhaseId(ajaxBehaviorEvent.getPhaseId());
                super.queueEvent(closeEvent);
            }
            else {
                //minimize and maximize
                super.queueEvent(event);
            }
        } else {
            super.queueEvent(event);
        }
    }

    @Override
    public void processDecodes(FacesContext context) {
        if(isRequestSource(context)) {
            this.decode(context);
        }
        else {
            super.processDecodes(context);
        }
    }

    @Override
    public void processValidators(FacesContext context) {
        if(!isRequestSource(context)) {
            super.processValidators(context);
        }
    }

    @Override
    public void processUpdates(FacesContext context) {
        if(!isRequestSource(context)) {
            super.processUpdates(context);
        }
        else {
            ValueExpression visibleVE = this.getValueExpression("visible");
            if(visibleVE != null) {
                FacesContext facesContext = getFacesContext();
                ELContext eLContext = facesContext.getELContext();

                if(!visibleVE.isReadOnly(eLContext)) {
                    visibleVE.setValue(eLContext, this.isVisible());
                    this.getStateHelper().put(PropertyKeys.visible, null);
                }
            }
        }
    }

    private boolean isRequestSource(FacesContext context) {
        return this.getClientId(context).equals(context.getExternalContext().getRequestParameterMap().get(Constants.RequestParams.PARTIAL_SOURCE_PARAM));
    }

    public boolean isContentLoadRequest(FacesContext context) {
        return context.getExternalContext().getRequestParameterMap().containsKey(this.getClientId(context) + "_contentLoad");
    }

    public boolean isRTL() {
        return this.getDir().equalsIgnoreCase("rtl");
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