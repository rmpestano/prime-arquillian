package org.primefaces.showcase.util;

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
        war.addPackages(true, "org.primefaces.showcase.domain");
        war.addPackages(true, "org.primefaces.showcase.filter");
        war.addPackages(true, "org.primefaces.showcase.service");
        war.addPackages(true, "org.primefaces.showcase.test.view");
        war.addPackages(true, "org.primefaces.showcase.convert");
        war.addPackages(true, "org.primefaces.showcase.view");
        //LIBS
        MavenResolverSystem resolver = Maven.resolver();
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.primefaces:primefaces:5.2-SNAPSHOT").withTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.apache.httpcomponents:httpcore:4.3.1").withTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.primefaces.themes:aristo:1.0.1").withoutTransitivity().asSingleFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.omnifaces:omnifaces:1.6").withoutTransitivity().asSingleFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.apache.commons:commons-io:1.3.2").withTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.codehaus.jackson:jackson-core-asl:1.5.5").withTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("jfree:jfreechart:1.0.5").withoutTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("com.lowagie:itext:2.1.7").withoutTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("commons-fileupload:commons-fileupload:1.3").withoutTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("rome:rome:1.0").withoutTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.atmosphere:atmosphere-runtime:2.1.3").withoutTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("net.sf.ehcache:ehcache:2.7.4").withoutTransitivity().asFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("com.hazelcast:hazelcast:2.6.5").withoutTransitivity().asFile());
        //WEB-INF
        war.addAsWebInfResource("test-beans.xml", "beans.xml");
        war.addAsWebInfResource("test-web.xml", "web.xml");
        war.addAsWebInfResource("test-faces-config.xml", "faces-config.xml");

        //resources
        war.addAsResource("test-ehcache.xml", "ehcache.xml");
        war.addAsResource("test-translate.properties", "translate.properties");
        war.addAsResource("test-twitter4j.properties", "twitter4j.properties");
        war.addAsResource("test-build.properties", "/org/primefaces/examples/build.properties");


        return war;
    }

}
