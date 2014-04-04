package org.primefaces.test.at.push;

import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.primefaces.test.at.BaseAtStep;
import org.primefaces.test.pages.push.PushHome;

import java.io.Serializable;
import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA. User: rmpestano Date: 10/31/13 Time: 8:49 PM To
 * change this template use File | Settings | File Templates.
 */
public class PushSteps extends BaseAtStep implements Serializable {

    @Drone
    private WebDriver browser;

    @ArquillianResource
    private URL baseUrl;

    @Page
    private PushHome pushHome;


    @Given("i am at push home")
    public void shouldBeInPushHome(){
        goToPage(pushHome);
        assertTrue(pushHome.isPresent());
    }




}
