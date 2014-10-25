package org.primefaces.showcase.pages.datatable;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.primefaces.showcase.ft.BasePage;

/**
 * Created by rmpestano on 4/5/14.
 */
@Location("ui/data/datatable/facets.jsf")
public class DatatableHeaderAndFooter extends BasePage {

    public static final String HEADER_AND_FOOTER_TABLE_HEADER="Header and Footer";
    public static final String TABLE_HEADER="List of Cars";
    public static final String TABLE_FOOTER="In total there are 10 cars.";

    @FindByJQuery("div.ui-datatable-header")
    private GrapheneElement tableHeader;

    @FindByJQuery("div.ui-datatable-footer")
    private GrapheneElement tableFooter;


    @Override
    public boolean isPresent() {
        return isItemPresent(HEADER_AND_FOOTER_TABLE_HEADER);
    }

    public boolean isTableHeaderPresent(){
        return tableHeader.getText().equals(TABLE_HEADER);
    }

    public boolean isTableFooterPresent(){
        return tableFooter.getText().equals(TABLE_FOOTER);
    }
}
