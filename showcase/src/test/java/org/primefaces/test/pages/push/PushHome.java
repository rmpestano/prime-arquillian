package org.primefaces.test.pages.push;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.primefaces.test.ft.BasePage;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.junit.Assert.assertTrue;

/**
 * Created by rafael-pestano on 04/04/2014.
 */
@Location("push/index.jsp")
public class PushHome extends BasePage {

    public static final String PUSH_HEADER = "PrimePush";
    public static final String COUNTER_HEADER = "PrimePush - Counter";
    public static final String VIEW_PARAM_HEADER = "PrimePush - ViewParam";


    @FindByJQuery("button:first")
    private GrapheneElement btCounter;

    @FindByJQuery("span[id$=out]")
    private GrapheneElement out;


    @Override
    public boolean isPresent() {
        return header.getText().equals(PUSH_HEADER);
    }


    public void gotoCounterPage(){
        guardHttp(findMenuItemByText(menu,"Counter")).click();
        assertTrue(isHeaderPresent(COUNTER_HEADER));
    }

    public void gotoViewParamPage(){
        findMenuItemByText(menu,"ViewParam").click();
        Graphene.waitModel();
        assertTrue(isHeaderPresent(VIEW_PARAM_HEADER));
    }

    public GrapheneElement getBtCounter() {
        return btCounter;
    }

    public GrapheneElement getOut() {
        return out;
    }
}
