package org.primefaces.showcase.warp;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.warp.WarpTest;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.primefaces.showcase.ft.BasePage;
import org.primefaces.showcase.util.Deployments;

import java.net.URL;

@RunWith(Arquillian.class)
@WarpTest
@RunAsClient
public class BaseWarp {

    protected static final String WEBAPP_SRC = "src/main/webapp";

    protected static final String TEST_RESOURCES = "src/test/resources";

    @Drone
    protected WebDriver browser;

    @ArquillianResource
    protected URL baseUrl;



    @Deployment(testable = true)
    public static Archive<?> createDeployment() {
        WebArchive war = Deployments.getBaseDeployment();

        //web resources
        war.merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(WEBAPP_SRC).as(GenericArchive.class), "/", Filters.include(".*\\.(xhtml|html|jsp|css|js|png|gif|jpg|txt)$"));
        System.out.println(war.toString(true));
        return war;
    }



    public void goToPage(BasePage page) {
        //Graphene.goTo(page.getClass());
        browser.get(baseUrl.toString() + page.getLocation());
    }
}