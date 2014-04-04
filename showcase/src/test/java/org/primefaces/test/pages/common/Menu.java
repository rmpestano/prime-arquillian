package org.primefaces.test.pages.common;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.fragment.Root;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by rmpestano on 3/9/14.
 */
public class Menu {

    @Root
    private GrapheneElement leftMenu;

    private WebElement datatableMenu;


    private WebElement getDatatableMenu() {
        if (datatableMenu == null) {
            datatableMenu = findItemByText("datatable");
        }
        return datatableMenu;
    }


    private WebElement findItemByText(String text){
        return leftMenu.findElement(By.xpath("//span[@class='ui-menuitem-text' and text() = '" + text +"']"));
    }

    public boolean isPresent(){
        return leftMenu.isPresent();
    }

}
