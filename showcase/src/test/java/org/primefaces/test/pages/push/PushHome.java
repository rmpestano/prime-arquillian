package org.primefaces.test.pages.push;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.primefaces.test.ft.BasePage;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created by rafael-pestano on 04/04/2014.
 */
@Location("push/index.jsp")
public class PushHome extends BasePage {

    public static final String COUNTER_HEADER = "PrimePush - Counter";
    public static final String PUSH_HEADER = "PrimePush - Counter";


    @Override
    public boolean isPresent() {
        return header.getText().equals(PUSH_HEADER);
    }


    public void gotoCounterPage(){
        guardHttp(findMenuItemByText(menu,"Counter")).click();
    }

}
