package org.conventions.archetype.test.ft.pages.role;

import org.conventions.archetype.test.ft.BasePage;
import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;

/**
 * Created by rmpestano on 3/10/14.
 */

@Location("/ui/datatableHome.xhtml")
public class DatatableHome extends BasePage {

    @FindByJQuery("div[id$=table]")
    private GrapheneElement datatable;



    public GrapheneElement getDatatable() {
        return datatable;
    }




}
