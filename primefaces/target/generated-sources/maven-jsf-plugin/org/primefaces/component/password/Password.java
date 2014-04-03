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
package org.primefaces.component.password;

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
import javax.faces.component.UIComponent;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import org.primefaces.expression.SearchExpressionFacade;
import org.primefaces.util.MessageFactory;

@ResourceDependencies({
	@ResourceDependency(library="primefaces", name="primefaces.css"),
	@ResourceDependency(library="primefaces", name="jquery/jquery.js"),
	@ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"),
	@ResourceDependency(library="primefaces", name="primefaces.js")
})
public class Password extends HtmlInputText implements org.primefaces.component.api.Widget {


	public static final String COMPONENT_TYPE = "org.primefaces.component.Password";
	public static final String COMPONENT_FAMILY = "org.primefaces.component";
	private static final String DEFAULT_RENDERER = "org.primefaces.component.PasswordRenderer";

	protected enum PropertyKeys {

		placeholder
		,widgetVar
		,feedback
		,inline
		,promptLabel
		,weakLabel
		,goodLabel
		,strongLabel
		,redisplay
		,match;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
}
	}

	public Password() {
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

	public boolean isFeedback() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.feedback, false);
	}
	public void setFeedback(boolean _feedback) {
		getStateHelper().put(PropertyKeys.feedback, _feedback);
	}

	public boolean isInline() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.inline, false);
	}
	public void setInline(boolean _inline) {
		getStateHelper().put(PropertyKeys.inline, _inline);
	}

	public java.lang.String getPromptLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.promptLabel, "Please enter a password");
	}
	public void setPromptLabel(java.lang.String _promptLabel) {
		getStateHelper().put(PropertyKeys.promptLabel, _promptLabel);
	}

	public java.lang.String getWeakLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.weakLabel, "Weak");
	}
	public void setWeakLabel(java.lang.String _weakLabel) {
		getStateHelper().put(PropertyKeys.weakLabel, _weakLabel);
	}

	public java.lang.String getGoodLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.goodLabel, "Good");
	}
	public void setGoodLabel(java.lang.String _goodLabel) {
		getStateHelper().put(PropertyKeys.goodLabel, _goodLabel);
	}

	public java.lang.String getStrongLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.strongLabel, "Strong");
	}
	public void setStrongLabel(java.lang.String _strongLabel) {
		getStateHelper().put(PropertyKeys.strongLabel, _strongLabel);
	}

	public boolean isRedisplay() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.redisplay, false);
	}
	public void setRedisplay(boolean _redisplay) {
		getStateHelper().put(PropertyKeys.redisplay, _redisplay);
	}

	public java.lang.String getMatch() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.match, null);
	}
	public void setMatch(java.lang.String _match) {
		getStateHelper().put(PropertyKeys.match, _match);
	}



    public final static String STYLE_CLASS = "ui-inputfield ui-password ui-widget ui-state-default ui-corner-all";

    public final static String INVALID_MATCH_KEY = "primefaces.password.INVALID_MATCH";

    @Override
	protected void validateValue(FacesContext context, Object value) {
		super.validateValue(context, value);
        String match = this.getMatch();
        Object submittedValue = this.getSubmittedValue();

        if(isValid() && match != null) {
        	Password matchWith = (Password) SearchExpressionFacade.resolveComponent(context, this, match);

            if(submittedValue != null && !submittedValue.equals(matchWith.getSubmittedValue())) {
                this.setValid(false);
                matchWith.setValid(false);

                String validatorMessage = getValidatorMessage();
                FacesMessage msg = null;

                if(validatorMessage != null) {
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, validatorMessage, validatorMessage);
                }
                else {
                    Object[] params = new Object[2];
                    params[0] = MessageFactory.getLabel(context, this);
                    params[1] = MessageFactory.getLabel(context, matchWith);

                    msg = MessageFactory.getMessage(Password.INVALID_MATCH_KEY, FacesMessage.SEVERITY_ERROR, params);
                }

                context.addMessage(getClientId(context), msg);
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