package org.primefaces.test.ft;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Default;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.primefaces.test.util.Deployments;

import java.io.File;
import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

@RunWith(Arquillian.class)
public class BaseFt {

    protected static final String WEBAPP_SRC = "src/main/webapp";

    protected static final String TEST_RESOURCES = "src/test/resources";

    @Drone
    protected WebDriver browser;

    @ArquillianResource
    protected URL baseUrl;

    @FindByJQuery("a[id$=logout]")
    protected GrapheneElement logoutButton;


    @Deployment(testable = false)
    public static Archive<?> createDeployment() {
        WebArchive war = Deployments.getBaseDeployment();

        //web resources
        war.merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(WEBAPP_SRC).as(GenericArchive.class), "/", Filters.include(".*\\.(xhtml|html|jsp|css|js|png|gif|jpg|txt)$"));
        System.out.println(war.toString(true));
        return war;
    }



    public void logout() {
        guardHttp(logoutButton).click();
    }

    public void goToPage(BasePage page) {
        //Graphene.goTo(page.getClass());
        browser.get(baseUrl.toString() + page.getLocation());
    }
}