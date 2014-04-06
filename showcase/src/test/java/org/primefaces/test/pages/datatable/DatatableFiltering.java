package org.primefaces.test.pages.datatable;

import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.prime.arquilian.components.Datatable;
import org.primefaces.test.ft.BasePage;

/**
 * Created by rmpestano on 4/5/14.
 */
@Location("ui/datatableFiltering.jsf")
public class DatatableFiltering extends BasePage {

    public static final String HEADER = "DataTable - Filtering";

    @FindByJQuery("div[id$=dataTable]")
    private Datatable datatable;


    @Override
    public boolean isPresent() {
        return isHeaderPresent(HEADER);
    }

    public void filterInput(String query) {
        datatable.filterInputColumn("modelColumn", query);
    }
    public void filterSelect(String query) {
        datatable.filterSelectColumn("manufacturerColumn", query);
    }

    public void goTonextTablePage() {
        Integer nextPage = getCurrentPageValue() + 1;
        datatable.getPaginatorPages().gotoPage(nextPage);

    }

    public Integer getCurrentPageValue() {
        return datatable.getCurrentPage().getCurrentPageValue();
    }

    public Datatable getDatatable() {
        return datatable;
    }
}
