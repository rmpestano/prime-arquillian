package org.primefaces.test.at;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import org.primefaces.test.at.push.PushSteps;
import org.primefaces.test.bdd.Steps;

/**
 * Created by rafael-pestano on 04/04/2014.
 *
 * Acceptance tests
 */
@RunWith(Arquillian.class)
@Steps(PushSteps.class)
public class ShowcaseAt extends BaseAt {


    @Deployment(testable = false)
    public static WebArchive createDeployment()
    {
        WebArchive archive = createBaseDeployment();

        System.out.println(archive.toString(true));
        return archive;
    }

}
