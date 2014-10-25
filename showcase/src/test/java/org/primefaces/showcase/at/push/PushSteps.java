package org.primefaces.showcase.at.push;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.WebDriver;
import org.primefaces.showcase.at.BaseAtStep;
import org.primefaces.showcase.pages.push.PushHome;

import java.io.Serializable;
import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.guardAjax;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA. User: rmpestano Date: 10/31/13 Time: 8:49 PM To
 * change this template use File | Settings | File Templates.
 */
public class PushSteps extends BaseAtStep implements Serializable {

    @Drone
    private WebDriver browser;

    private String counterBefore;

    @ArquillianResource
    private URL baseUrl;

    @Page
    private PushHome pushHome;


    @Given("user is at push home")
    public void shouldBeInPushHome() {
        goToPage(pushHome);
        assertTrue(pushHome.isPresent());
    }

    @Given("user go to counter page")
    public void gotoCounter() {
        pushHome.gotoCounterPage();
    }

    @When("user click in counter button")
    public void userClick() {
        counterBefore = pushHome.getOut().getText();
        guardAjax(pushHome.getBtCounter()).click();
    }

    @Then("counter value should be incremented")
    public void counterIsIncremented() {
        assertEquals(Integer.parseInt(counterBefore) + 1, Integer.parseInt(pushHome.getOut().getText()));
    }

    //@Composite(steps = {"Given user is at push home"})
    @Given("user is at viewparam page")
    public void userAtViewpPramPage() {
        pushHome.gotoViewParamPage();
    }

    @When("user refreshes the browser passing $value as viewparam")
    public void userRefreshedBrowserWithParam(@Named("value") String value) {
        browser.get(baseUrl + "/push/viewparam.jsf?data=" + value);
    }

    @Then("$value is displayed in the page")
    public void valueShouldBeDisplayed(@Named("value") String value){
        assertEquals(pushHome.getOut().getText(),value);
    }
}
