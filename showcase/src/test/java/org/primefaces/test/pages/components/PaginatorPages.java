package org.primefaces.test.pages.components;

import org.jboss.arquillian.graphene.fragment.Root;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardAjax;

/**
 * Created by rmpestano on 4/5/14.
 */
public class PaginatorPages {

    @Root
    private WebElement paginatorPages;

    public void gotoPage(Integer page){
        guardAjax(paginatorPages.findElement(By.xpath("//span[text()='" + page + "']"))).click();
    }
}
