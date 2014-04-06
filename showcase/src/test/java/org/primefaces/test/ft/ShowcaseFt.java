package org.primefaces.test.ft;

import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.primefaces.test.pages.HomePage;
import org.primefaces.test.pages.datatable.DatatableFiltering;
import org.primefaces.test.pages.datatable.DatatableHeaderAndFooter;
import org.primefaces.test.pages.datatable.DatatableHome;
import org.primefaces.test.pages.datatable.DatatablePagination;

import java.util.List;

import static junit.framework.Assert.assertEquals;
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
    @InSequence(1)
    public void shouldBeInInitialPage( ) {

        assertTrue(home.isPresent());
    }

    //datatable tests
    @Test
    @InSequence(2)
    public void shouldBeInDatatableHome(@InitialPage DatatableHome datatableHome){
        assertTrue(datatableHome.isPresent());
        datatableHome.openSimpleDatatable();
    }

    @Test
    @InSequence(3)
    public void shouldRenderSimpleDatatable(){
        assertTrue(browser.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']")).isDisplayed());
    }

    @Test
    @InSequence(4)
    public void shouldRenderHeaderAndFooterTable(@InitialPage DatatableHome datatableHome){
       DatatableHeaderAndFooter datatableFooterAndHeader = datatableHome.getDatatableHeaderAndFooter();
       datatableHome.openHeaderAndFooterTable();
       assertTrue(datatableFooterAndHeader.isPresent());
       assertTrue(datatableFooterAndHeader.isTableHeaderPresent());
       assertTrue(datatableFooterAndHeader.isTableFooterPresent());
    }

    @Test
    @InSequence(5)
    public void shouldPaginateDatatable(@InitialPage DatatableHome datatableHome){
        DatatablePagination datatablePagination = datatableHome.getDatatablePagination();
        datatableHome.openDataTablePagination();
        assertTrue(datatablePagination.isPresent());
        assertEquals(datatablePagination.getDatatable().getTableRows().size(), 10);
        datatablePagination.selectPageByValue("5");
        assertEquals(datatablePagination.getDatatable().getTableRows().size(), 5);
        Integer tablePageBefore = datatablePagination.getCurrentPageValue();
        datatablePagination.goTonextTablePage();
        assertEquals(++tablePageBefore, datatablePagination.getCurrentPageValue());
    }

    @Test
    @InSequence(6)
    public void shouldFilterDatatable(@InitialPage DatatableHome datatableHome){
        DatatableFiltering datatableFiltering = datatableHome.getDatatableFiltering();
        datatableHome.openDataTableFiltering();
        assertTrue(datatableFiltering.isPresent());
        datatableFiltering.filter("55");
        List<WebElement> rows = datatableFiltering.getDatatable().getTableRows();
        for (WebElement row : rows) {
            assertTrue(row.getText().contains("55"));
        }
    }
}
