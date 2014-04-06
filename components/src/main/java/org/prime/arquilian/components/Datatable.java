package org.prime.arquilian.components;

import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.fragment.Root;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by rmpestano on 4/5/14.
 */
public class Datatable {

    @Root
    WebElement datatable;

    @FindByJQuery("span.ui-paginator-current")
    private PaginatorCurrentPage currentPage;

    @FindByJQuery("span.ui-paginator-pages")
    private PaginatorPages paginatorPages;

    @FindByJQuery("select.ui-paginator-rpp-options")
    private PaginatorDropdown paginatorDropdown;


    public PaginatorCurrentPage getCurrentPage() {
        return currentPage;
    }

    public PaginatorPages getPaginatorPages() {
        return paginatorPages;
    }

    public PaginatorDropdown getPaginatorDropdown() {
        return paginatorDropdown;
    }


    public List<WebElement> getTableRowsWithTDs(){
        String tableId = datatable.getAttribute("id");
        return datatable.findElements(By.xpath("//tbody[contains(@id,'" + tableId + "')]//tr[@role='row']//td[@role='gridcell']"));
    }

    public List<WebElement> getTableRows(){
        String tableId = datatable.getAttribute("id");
        return datatable.findElements(By.xpath("//tbody[contains(@id,'" +tableId +"')]//tr[@role='row']"));
    }

}
