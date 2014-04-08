package org.primefaces.test.pages.exceptionhandler;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.primefaces.test.ft.BasePage;

import static org.jboss.arquillian.graphene.Graphene.guardAjax;

/**
 * Created by rmpestano on 4/7/14.
 */
@Location("ui/exceptionHandler.jsf")
public class ExceptionHandlerHome extends BasePage{

    @FindByJQuery("button:first")
    private GrapheneElement btViewExpired;

    @Override
    public boolean isPresent() {
        return isHeaderPresent("ExceptionHandler");
    }

    public void fireViewExpired(){
        guardAjax(btViewExpired).click();
    }
}
