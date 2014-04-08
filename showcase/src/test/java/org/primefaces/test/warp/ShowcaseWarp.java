package org.primefaces.test.warp;

import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.warp.Activity;
import org.jboss.arquillian.warp.Inspection;
import org.jboss.arquillian.warp.Warp;
import org.jboss.arquillian.warp.jsf.AfterPhase;
import org.jboss.arquillian.warp.jsf.Phase;
import org.junit.Test;
import org.primefaces.test.pages.exceptionhandler.ExceptionHandlerHome;

import javax.faces.context.FacesContext;

/**
 * Created by rmpestano on 4/7/14.
 */

public class ShowcaseWarp extends BaseWarp  {


    @Test
    @InSequence(0)
    public void init(){
        browser.get(baseUrl +"index.jsp");
    }


    @Test
    @InSequence(1)
    public void shouldThrowViewExpired(@InitialPage final ExceptionHandlerHome exceptionHandlerHome){
        Warp.initiate(new Activity() {
            public void perform() {
                exceptionHandlerHome.fireViewExpired();
            }

        }).inspect(new Inspection() {
            private static final long serialVersionUID = 1L;

            @AfterPhase(value = Phase.RENDER_RESPONSE)
            public void verify(@ArquillianResource FacesContext context) {
                  context.getMessageList();
                  context.getExceptionHandler().getHandledExceptionQueuedEvent();
            }

        });

    }

}
