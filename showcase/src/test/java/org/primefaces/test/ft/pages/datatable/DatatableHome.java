package oorg.primefaces.test.ft.pages.role;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;

/**
 * Created by rmpestano on 3/10/14.
 */

@Location("/ui/datatableHome.xhtml")
public class DatatableHome extends org.primefaces.test.ft.BasePage {

    @FindByJQuery("div[id$=table]")
    private GrapheneElement datatable;



    public GrapheneElement getDatatable() {
        return datatable;
    }




}
