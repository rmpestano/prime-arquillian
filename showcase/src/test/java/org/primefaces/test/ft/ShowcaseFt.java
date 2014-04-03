package org.primefaces.test.ft;

import junit.framework.Assert;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;
import org.openqa.selenium.By;
import org.primefaces.test.ft.pages.HomePage;

import static org.junit.Assert.assertTrue;

/**
 * Created by rafael-pestano on 03/04/2014.
 */
public class ShowcaseFt extends BaseFt{



    @Test
    @InSequence(1)//tests in same dozen are dependent
    public void shouldOpenInitialPage(@InitialPage
                                          HomePage home) {

        assertTrue(home.isPresent());
    }


}
