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
package org.primefaces.component.radiobutton;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.expression.SearchExpressionFacade;
import org.primefaces.renderkit.InputRenderer;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.HTML;
import org.primefaces.util.SharedStringBuilder;

public class RadioButtonRenderer extends InputRenderer {
    
    private static final String SB_ENCODE_OPTION_INPUT = RadioButtonRenderer.class.getName() + "#encodeOptionInput";
    
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        RadioButton radioButton = (RadioButton) component;
        SelectOneRadio selectOneRadio = (SelectOneRadio) SearchExpressionFacade.resolveComponent(
        		context, radioButton, radioButton.getFor());

        encodeMarkup(context, radioButton, selectOneRadio);
    }
    
    protected void encodeMarkup(FacesContext context, RadioButton radio, SelectOneRadio selectOneRadio) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String masterClientId = selectOneRadio.getClientId(context);
        String inputId = selectOneRadio.getRadioButtonId(context);
        String clientId = radio.getClientId(context);
        boolean disabled = radio.isDisabled() || selectOneRadio.isDisabled();
        Converter converter = ComponentUtils.getConverter(context, selectOneRadio);
        SelectItem selecItem = selectOneRadio.getSelectItems().get(radio.getItemIndex());
        Object itemValue = selecItem.getValue();
        String itemValueAsString = getOptionAsString(context, selectOneRadio, converter, itemValue);
        
        //selected
        Object value = selectOneRadio.getSubmittedValue();
        if(value == null) {
            value = selectOneRadio.getValue();
        }
        Class type = value == null ? String.class : value.getClass();
        Object coercedItemValue = coerceToModelType(context, itemValue, type);
        boolean selected = (coercedItemValue != null) && coercedItemValue.equals(value);

        //render markup
        String style = radio.getStyle();
        String defaultStyleClass = selectOneRadio.isPlain() ? HTML.RADIOBUTTON_NATIVE_CLASS : HTML.RADIOBUTTON_CLASS;
        String styleClass = radio.getStyleClass();
        styleClass = styleClass == null ? defaultStyleClass : defaultStyleClass + " " + styleClass;
        
        writer.startElement("div", null);
        writer.writeAttribute("id", clientId, null);
        writer.writeAttribute("class", styleClass, null);
        if(style != null) {
            writer.writeAttribute("style", style, null);
        }

        encodeOptionInput(context, selectOneRadio, radio, inputId, masterClientId, selected, disabled, itemValueAsString);
        encodeOptionOutput(context, selected, disabled);

        writer.endElement("div");
    }
    
    protected void encodeOptionInput(FacesContext context, SelectOneRadio radio, RadioButton button, String id, String name, boolean checked, boolean disabled, String value) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String tabindex = button.getTabindex();
        if(tabindex == null) {
            tabindex = radio.getTabindex();
        }

        writer.startElement("div", null);
        writer.writeAttribute("class", "ui-helper-hidden-accessible", null);

        writer.startElement("input", null);
        writer.writeAttribute("id", id, null);
        writer.writeAttribute("name", name, null);
        writer.writeAttribute("type", "radio", null);
        writer.writeAttribute("value", value, null);

        if(tabindex != null) writer.writeAttribute("tabindex", tabindex, null);
        if(checked) writer.writeAttribute("checked", "checked", null);
        if(disabled) writer.writeAttribute("disabled", "disabled", null);

        //onchange
        String radioOnchange = buildDomEvent(context, radio, "onchange", "change", "valueChange", null);
        String buttonOnchange = buildDomEvent(context, button, "onchange", "change", "valueChange", null);
        StringBuilder onchangeBuilder = SharedStringBuilder.get(context, SB_ENCODE_OPTION_INPUT);
        if (radioOnchange != null) onchangeBuilder.append(radioOnchange);
        if (buttonOnchange != null) onchangeBuilder.append(buttonOnchange);
        
        if (onchangeBuilder.length() > 0) {  
            writer.writeAttribute("onchange", onchangeBuilder.toString(), null);
        }

        writer.endElement("input");
        writer.endElement("div");
    }

    protected void encodeOptionOutput(FacesContext context, boolean selected, boolean disabled) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String boxClass = HTML.RADIOBUTTON_BOX_CLASS;
        boxClass = selected ? boxClass + " ui-state-active" : boxClass;
        boxClass = disabled ? boxClass + " ui-state-disabled" : boxClass;
        String iconClass = selected ? HTML.RADIOBUTTON_CHECKED_ICON_CLASS: HTML.RADIOBUTTON_UNCHECKED_ICON_CLASS;

        writer.startElement("div", null);
        writer.writeAttribute("class", boxClass, null);

        writer.startElement("span", null);
        writer.writeAttribute("class", iconClass, null);
        writer.endElement("span");

        writer.endElement("div");
    }

}
