package org.primefaces.test.pages;

import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.By;
import org.primefaces.test.ft.BasePage;

/**
 * Created by rmpestano on 3/9/14.
 */
@Location("ui/home.jsf")
public class HomePage extends BasePage {

    public static final String H1_TEXT = "Welcome to PrimeFaces ShowCase";


    @Override
    public boolean isPresent() {
        return H1_TEXT.equals(browser.findElement(By.tagName("H1")).getText());
    }
}
