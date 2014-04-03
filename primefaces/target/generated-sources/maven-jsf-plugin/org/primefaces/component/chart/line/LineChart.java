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
package org.primefaces.component.chart.line;

import org.primefaces.component.chart.CartesianChart;
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
public class LineChart extends CartesianChart implements org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.component.chart.LineChart";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.chart.LineChartRenderer";

	protected enum PropertyKeys {

		widgetVar
		,minY
		,maxY
		,minX
		,maxX
		,breakOnNull
		,fill
		,stacked
		,showMarkers
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

	public LineChart() {
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

	public double getMinY() {
		return (java.lang.Double) getStateHelper().eval(PropertyKeys.minY, java.lang.Double.MIN_VALUE);
	}
	public void setMinY(double _minY) {
		getStateHelper().put(PropertyKeys.minY, _minY);
	}

	public double getMaxY() {
		return (java.lang.Double) getStateHelper().eval(PropertyKeys.maxY, java.lang.Double.MAX_VALUE);
	}
	public void setMaxY(double _maxY) {
		getStateHelper().put(PropertyKeys.maxY, _maxY);
	}

	public double getMinX() {
		return (java.lang.Double) getStateHelper().eval(PropertyKeys.minX, java.lang.Double.MIN_VALUE);
	}
	public void setMinX(double _minX) {
		getStateHelper().put(PropertyKeys.minX, _minX);
	}

	public double getMaxX() {
		return (java.lang.Double) getStateHelper().eval(PropertyKeys.maxX, java.lang.Double.MAX_VALUE);
	}
	public void setMaxX(double _maxX) {
		getStateHelper().put(PropertyKeys.maxX, _maxX);
	}

	public boolean isBreakOnNull() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.breakOnNull, false);
	}
	public void setBreakOnNull(boolean _breakOnNull) {
		getStateHelper().put(PropertyKeys.breakOnNull, _breakOnNull);
	}

	public boolean isFill() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.fill, false);
	}
	public void setFill(boolean _fill) {
		getStateHelper().put(PropertyKeys.fill, _fill);
	}

	public boolean isStacked() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.stacked, false);
	}
	public void setStacked(boolean _stacked) {
		getStateHelper().put(PropertyKeys.stacked, _stacked);
	}

	public boolean isShowMarkers() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.showMarkers, true);
	}
	public void setShowMarkers(boolean _showMarkers) {
		getStateHelper().put(PropertyKeys.showMarkers, _showMarkers);
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