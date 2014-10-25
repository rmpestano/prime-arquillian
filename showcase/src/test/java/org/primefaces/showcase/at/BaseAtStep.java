package org.primefaces.showcase.at;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.WebDriver;
import org.primefaces.showcase.ft.BasePage;

import java.net.URL;

/**
 * Created by rmpestano on 3/30/14.
 */
public abstract class BaseAtStep {

    @Drone
    WebDriver browser;

    @ArquillianResource
    protected URL baseUrl;


    public void goToPage(BasePage page) {
        //Graphene.goTo(page.getClass());
        browser.get(baseUrl.toString() + page.getLocation());
    }
}
