package org.primefaces.test.pages.datatable;

import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.primefaces.test.ft.BasePage;
import org.primefaces.test.pages.components.Datatable;

/**
 * Created by rmpestano on 4/5/14.
 */
@Location("ui/datatablePagination.jsf")
public class DatatablePagination extends BasePage {

    public static final String HEADER="DataTable - Pagination";

    @FindByJQuery("div[id=dataTable]")
    private Datatable datatable;


    @Override
    public boolean isPresent() {
        return isHeaderPresent(HEADER);
    }

    public void selectPageByValue(String value){
        datatable.getPaginatorDropdown().selectOptionByValue(value);
    }

    public void goTonextTablePage(){
          Integer nextPage = getCurrentPageValue()+1;
          datatable.getPaginatorPages().gotoPage(nextPage);

    }

    public Integer getCurrentPageValue(){
          return datatable.getCurrentPage().getCurrentPageValue();
    }

    public Datatable getDatatable() {
        return datatable;
    }
}
