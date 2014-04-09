package org.primefaces.test.pages.dialog;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.primefaces.test.ft.BasePage;

import static org.jboss.arquillian.graphene.Graphene.guardAjax;
import static org.jboss.arquillian.graphene.Graphene.guardNoRequest;

/**
 * Created by rmpestano on 4/7/14.
 */
@Location("ui/dialogLogin.jsf")
public class DialogLogin extends BasePage{

    @FindByJQuery("a[id$=loginLink] > img")
    private GrapheneElement login;

    @FindByJQuery("input[id$=username]")
    private GrapheneElement username;

    @FindByJQuery("input[id$=password]")
    private GrapheneElement password;

    @FindByJQuery("button[id$=loginButton]")
    private GrapheneElement btLogon;



    @Override
    public boolean isPresent() {
        return isHeaderPresent("Messages");
    }

    public void openDialog(){
        guardNoRequest(login).click();
    }

    public void doLogon(){
        username.sendKeys("admin");
        password.sendKeys("admin");
        guardAjax(btLogon).click();
    }
}
