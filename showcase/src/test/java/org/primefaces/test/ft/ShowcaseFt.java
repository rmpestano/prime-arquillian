package org.primefaces.test.ft;

import junit.framework.Assert;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.openqa.selenium.By;
import org.primefaces.test.ft.pages.HomePage;

import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * Created by rafael-pestano on 03/04/2014.
 */
public class ShowcaseFt extends BaseFt{


    @Page
    HomePage home;

    @Test
    @InSequence(0)//tests in same dozen are dependent
    public void init( ) {
        browser.get(baseUrl +"/index.jsp");

    }

    @Test
    @InSequence(1)//tests in same dozen are dependent
    public void shouldOpenInitialPage( ) {

        assertTrue(home.isPresent());
    }


}
