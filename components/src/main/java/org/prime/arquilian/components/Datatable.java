package org.prime.arquilian.components;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.fragment.Root;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardAjax;
import static org.jboss.arquillian.graphene.Graphene.guardNoRequest;

/**
 * Created by rmpestano on 4/5/14.
 */
public class Datatable {

    @Root
    private WebElement datatable;

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

    public void filterInputColumn(String colId, String query) {
        WebElement column = datatable.findElement(By.xpath("//th[contains(@class,'ui-filter-column') and contains(@id,'" + colId + "')]//input"));
        guardAjax(column).sendKeys(query);
    }

    public void clearColumn(String colId){
        WebElement column = datatable.findElement(By.xpath("//th[contains(@class,'ui-filter-column') and contains(@id,'" + colId + "')]//input"));
        guardNoRequest(column).clear();
    }

    public void filterSelectColumn(String colId, String query) {
        StringBuilder xpath = new StringBuilder("//th[contains(@class,'ui-filter-column') and contains(@id,'" + colId + "')]");
        xpath.append("//div[contains(@class,'ui-selectonemenu-trigger')]//span[contains(@class,'ui-icon-triangle-1-s')]");
        datatable.findElement(By.xpath(xpath.toString())).click();
        Graphene.waitAjax().until().element(By.className("ui-selectonemenu-items-wrapper")).is().present();
        WebElement selectItem = datatable.findElement(By.xpath("//li[contains(@class,'ui-selectonemenu-item') and contains(text(),'" + query +"')]"));
        guardAjax(selectItem).click();
    }




}
