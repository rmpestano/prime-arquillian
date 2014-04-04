package org.primefaces.test.ft.pages;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.primefaces.test.ft.BasePage;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created by rmpestano on 3/10/14.
 */

@Location("ui/datatableHome.jsf")
public class DatatableHome extends BasePage {

    public static final String DATATABLE_HEADER="DataTable";
    public static final String HEADER_AND_FOOTER_TABLE_HEADER="DataTable - Header and Footer";

    @FindByJQuery("div[id$=table]")
    private GrapheneElement datatable;

    @FindByJQuery("h1.ui-widget-header")
    private GrapheneElement header;

    @FindByJQuery("ul.ui-menu-list")
    private GrapheneElement menu;



    public GrapheneElement getDatatable() {
        return datatable;
    }


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
}
