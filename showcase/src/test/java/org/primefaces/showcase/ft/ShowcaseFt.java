package org.primefaces.showcase.ft;

import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.primefaces.showcase.pages.HomePage;
import org.primefaces.showcase.pages.datatable.DatatableFiltering;
import org.primefaces.showcase.pages.datatable.DatatableHeaderAndFooter;
import org.primefaces.showcase.pages.datatable.DatatableHome;
import org.primefaces.showcase.pages.datatable.DatatablePagination;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

/**
 * Created by rafael-pestano on 03/04/2014.
 */
public class ShowcaseFt extends BaseFt{


    @Page
    HomePage home;


    @Test
    @InSequence(1)
    public void shouldBeInInitialPage() {
        browser.get(baseUrl +"index.xhtml");
        assertTrue(home.isPresent());
    }

    //datatable tests
    @Test
    @InSequence(2)
    public void shouldBeInDatatableHome(@InitialPage DatatableHome datatableHome){
        assertTrue(datatableHome.isPresent());
    }

    @Test
    @InSequence(3)
    public void shouldRenderSimpleDatatable(){
        assertTrue(browser.findElement(By.xpath("//div[contains(@class, 'ui-datatable')]")).isDisplayed());
    }

    @Test
    @InSequence(4)
    public void shouldRenderHeaderAndFooterTable(@InitialPage DatatableHeaderAndFooter datatableFooterAndHeader){
       assertTrue(datatableFooterAndHeader.isPresent());
       assertTrue(datatableFooterAndHeader.isTableHeaderPresent());
       assertTrue(datatableFooterAndHeader.isTableFooterPresent());
    }

    @Test
    @InSequence(5)
    public void shouldPaginateDatatable(@InitialPage DatatablePagination datatablePagination){
        assertTrue(datatablePagination.isPresent());
        assertEquals(datatablePagination.getDatatable().getTableRows().size(), 10);
        datatablePagination.selectPageByValue("15");
        assertEquals(datatablePagination.getDatatable().getTableRows().size(), 15);
        datatablePagination.selectPageByValue("5");
        assertEquals(datatablePagination.getDatatable().getTableRows().size(), 5);
        Integer tablePageBefore = datatablePagination.getCurrentPageValue();
        datatablePagination.goToNextTablePage();
        assertEquals(++tablePageBefore, datatablePagination.getCurrentPageValue());
        datatablePagination.goToNextTablePage();
        assertEquals(++tablePageBefore, datatablePagination.getCurrentPageValue());
        datatablePagination.goToNextTablePage();
        assertEquals(++tablePageBefore, datatablePagination.getCurrentPageValue());
        datatablePagination.goToNextTablePage();
        assertEquals(++tablePageBefore, datatablePagination.getCurrentPageValue());
        datatablePagination.goToPreviousTablePage();
        assertEquals(--tablePageBefore, datatablePagination.getCurrentPageValue());
        datatablePagination.goToPreviousTablePage();
        assertEquals(--tablePageBefore, datatablePagination.getCurrentPageValue());
        datatablePagination.goToPreviousTablePage();
        assertEquals(--tablePageBefore, datatablePagination.getCurrentPageValue());
    }

    @Test
    @InSequence(6)
    public void shouldFilterDatatable(@InitialPage DatatableFiltering datatableFiltering){
        assertTrue(datatableFiltering.isPresent());
        datatableFiltering.filterInput("1");
        List<WebElement> rows = datatableFiltering.getDatatable().getTableRows();
        for (WebElement row : rows) {
            assertTrue(row.getText().contains("1"));
        }
        datatableFiltering.getDatatable().clearFilterColumn("modelColumn");
        datatableFiltering.filterInput("2");
        datatableFiltering.filterInput("313");
        assertTrue(datatableFiltering.getDatatable().getTableRows().isEmpty());
        datatableFiltering.getDatatable().clearFilterColumn("modelColumn");
        datatableFiltering.filterInput("a");
        waitGui();
        datatableFiltering.filterSelect("BMW");
        rows = datatableFiltering.getDatatable().getTableRows();
        for (WebElement row : rows) {
            assertTrue(row.getText().contains("BMW"));
        }
    }
}
