package org.primefaces.test.util;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolverSystem;

/**
 * @author rafael-pestano 20/07/2013 16:49:34
 *         <p/>
 *         Arquillian WebArchive factory
 */
public class Deployments {

    /**
     * @return base WebArchive for all arquillian tests
     */
    public static WebArchive getBaseDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class);
        war.addPackages(true, "org.primefaces.examples.domain");
        war.addPackages(true, "org.primefaces.examples.filter");
        war.addPackages(true, "org.primefaces.examples.service");
        war.addPackages(true, "org.primefaces.examples.test.view");
        war.addPackages(true, "org.primefaces.examples.validate");
        war.addPackages(true, "org.primefaces.examples.view");
        //LIBS
        MavenResolverSystem resolver = Maven.resolver();
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.conventionsframework:conventions-core:1.0.0-SNAPSHOT").withoutTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.apache.httpcomponents:httpcore:4.2.5").withTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.primefaces:primefaces:5.0-SNAPSHOT").withoutTransitivity().asSingleFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.primefaces.themes:all-themes:1.0.10").withoutTransitivity().asSingleFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.omnifaces:omnifaces:1.6").withoutTransitivity().asSingleFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.codehaus.jackson:jackson-core-asl:1.5.5").withTransitivity().asFile());
        //WEB-INF
        war.addAsWebInfResource("test-beans.xml", "beans.xml");
        war.addAsWebInfResource("test-web.xml", "web.xml");
        war.addAsWebInfResource("test-faces-config.xml", "faces-config.xml");

        //resources
        war.addAsResource("test-ehcache.xml", "ehcache.xml");
        war.addAsResource("test-translate.properties", "translate.properties");
        war.addAsResource("test-twitter4j.properties", "twitter4j.properties");

        return war;
    }

}
