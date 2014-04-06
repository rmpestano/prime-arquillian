package org.primefaces.test.pages.components;

import org.jboss.arquillian.graphene.fragment.Root;
import org.openqa.selenium.WebElement;

/**
 * Created by rmpestano on 4/5/14.
 */
public class PaginatorCurrentPage {

    @Root
    private WebElement currentPage;


    public Integer getCurrentPageValue(){
        return Integer.parseInt(currentPage.getText().substring(1,2));
    }
}

