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
package org.primefaces.component.chart.ohlc;

import org.primefaces.component.chart.UIChart;
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

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="charts/charts.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js"),
	@ResourceDependency(library="primefaces", name="charts/charts.js")
})
public class OhlcChart extends UIChart implements org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.component.chart.OhlcChart";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.chart.OhlcChartRenderer";

	protected enum PropertyKeys {

		widgetVar
		,value
		,candleStick
		,zoom
		,animate
		,showDatatip
		,datatipFormat;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public OhlcChart() {
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

	public org.primefaces.model.chart.OhlcChartModel getValue() {
		return (org.primefaces.model.chart.OhlcChartModel) getStateHelper().eval(PropertyKeys.value, null);
	}
	public void setValue(org.primefaces.model.chart.OhlcChartModel _value) {
		getStateHelper().put(PropertyKeys.value, _value);
	}

	public boolean isCandleStick() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.candleStick, false);
	}
	public void setCandleStick(boolean _candleStick) {
		getStateHelper().put(PropertyKeys.candleStick, _candleStick);
	}

	public boolean isZoom() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.zoom, false);
	}
	public void setZoom(boolean _zoom) {
		getStateHelper().put(PropertyKeys.zoom, _zoom);
	}

	public boolean isAnimate() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.animate, false);
	}
	public void setAnimate(boolean _animate) {
		getStateHelper().put(PropertyKeys.animate, _animate);
	}

	public boolean isShowDatatip() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.showDatatip, true);
	}
	public void setShowDatatip(boolean _showDatatip) {
		getStateHelper().put(PropertyKeys.showDatatip, _showDatatip);
	}

	public java.lang.String getDatatipFormat() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.datatipFormat, null);
	}
	public void setDatatipFormat(java.lang.String _datatipFormat) {
		getStateHelper().put(PropertyKeys.datatipFormat, _datatipFormat);
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