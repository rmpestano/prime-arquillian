package org.primefaces.test.ft;

import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;
import org.openqa.selenium.By;
import org.primefaces.test.ft.pages.DatatableHome;
import org.primefaces.test.ft.pages.HomePage;

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
       datatableHome.openHeaderAndFooterTable();
       assertTrue(browser.findElement(By.xpath("//h1[contains(@class,'title ')]")).getText().equals(datatableHome.HEADER_AND_FOOTER_TABLE_HEADER));
       //todo verify header and footer
    }
}
