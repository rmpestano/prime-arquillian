## Arquillian tests for Primefaces


### Running tests:
--------------

1. download the server installation into your local machine(for now only JbossAS 7.x[mojarra 2.1] and  Wildfly 8.x[mojarra 2.2.x] are supported)
2. configure prime-showcase pom.xml by editing property arquillian.serverHome to point to your downloaded server
3. activate server profile(wildfly-managed[default] or jboss-managed) in your IDE or when firing the mvn
4. first time running tests: 
  1. from prime-arquillian dir fire mvn clean install to install primefaces and prime-arquillian components into local maven repo
5. subsequent test commands can be fired from showcase submodule via mvn test.
  1. note that you can run ShowcaseFt.java(functional tests) or ShowcaseAt.java(acceptance tests) via IDE with Run/Debug as JUnit test. In this case no need to mvn install cause IDE should handle maven modules dependencies.   
