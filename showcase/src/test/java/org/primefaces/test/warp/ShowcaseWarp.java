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
import org.primefaces.examples.view.LoginBean;
import org.primefaces.test.pages.dialog.DialogLogin;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rmpestano on 4/7/14.
 */

public class ShowcaseWarp extends BaseWarp {


    @Test
    @InSequence(0)
    public void init() {
        browser.get(baseUrl + "index.jsp");
    }


    @Test
    @InSequence(1)
    public void shouldLogonWithSuccess(@InitialPage final DialogLogin dialogLogin) {
        Warp.initiate(new Activity() {
            public void perform() {
                dialogLogin.openDialog();
                dialogLogin.doLogon();
            }

        }).inspect(new Inspection() {
            private static final long serialVersionUID = 1L;

             @Inject
             LoginBean loginBean;



            @AfterPhase(value = Phase.UPDATE_MODEL_VALUES)
            public void updateModel(@ArquillianResource FacesContext context) {
                assertEquals(loginBean.getPassword(), "admin");
                assertEquals(loginBean.getUsername(), "admin");
            }



            @AfterPhase(value = Phase.INVOKE_APPLICATION)
            public void invokeApplication(@ArquillianResource FacesContext context) {

                boolean hasMessage = false;
                for (FacesMessage facesMessage : context.getMessageList()) {
                    if(facesMessage.getSummary().equals("Welcome") && facesMessage.getDetail().equals("admin")){
                        hasMessage = true;
                        break;
                    }
                }
                assertTrue(hasMessage);
            }



        });

    }

    ;
}


