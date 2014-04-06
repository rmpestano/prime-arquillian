package org.primefaces.test.pages.datatable;

import org.jboss.arquillian.graphene.page.Location;
import org.jboss.arquillian.graphene.page.Page;
import org.primefaces.test.ft.BasePage;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created by rmpestano on 3/10/14.
 */

@Location("ui/datatableHome.jsf")
public class DatatableHome extends BasePage {

    public static final String DATATABLE_HEADER="DataTable";

    @Page
    private DatatableHeaderAndFooter datatableHeaderAndFooter;

    @Page
    private DatatablePagination datatablePagination;

    @Page
    private DatatableFiltering datatableFiltering;


    @Override
    public boolean isPresent() {
        return header.getText().equals(DATATABLE_HEADER);
    }

    public void openSimpleDatatable(){
        guardHttp(findMenuItemByText(menu,"Simple DataTable")).click();
    }

    public void openHeaderAndFooterTable(){
        guardHttp(findMenuItemByText(menu,"Header and Footer")).click();
    }

    public void openDataTablePagination(){
        guardHttp(findMenuItemByText(menu,"Pagination")).click();
    }

    public void openDataTableFiltering(){
        guardHttp(findMenuItemByText(menu,"Filtering")).click();
    }

    public DatatableHeaderAndFooter getDatatableHeaderAndFooter() {
        return datatableHeaderAndFooter;
    }

    public DatatablePagination getDatatablePagination() {
        return datatablePagination;
    }

    public DatatableFiltering getDatatableFiltering() {
        return datatableFiltering;
    }
}
