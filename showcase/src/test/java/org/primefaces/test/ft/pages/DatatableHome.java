package org.primefaces.test.ft.pages;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.primefaces.test.ft.BasePage;

/**
 * Created by rmpestano on 3/10/14.
 */

@Location("/ui/datatableHome.xhtml")
public class DatatableHome extends BasePage {

    @FindByJQuery("div[id$=table]")
    private GrapheneElement datatable;

    @FindByJQuery("H1.title ui-widget-header")
    private GrapheneElement header;



    public GrapheneElement getDatatable() {
        return datatable;
    }


    @Override
    public boolean isPresent() {
        return header.isPresent();
    }
}
