## Arquillian tests for Primefaces


### Running tests:
--------------

1. download the server installation into your local machine(for now only jboss 7.x[mojarra 2.1] and  wildfly 8.x[mojarra 2.2.x] are supported)
2. configure prime-showcase pom.xml by editing property arquillian.serverHome to point to your download server
3. activate server profile(wildfly-managed or jboss-managed) in your IDE or when firing the mvn
4. cd into showcase submodule and run mvn test
  1. note that first time you will need to cd into primefaces and do a mvn clean install to install primefaces-5.0-SNAPSHOT into your local maven repository
  2. also note that you can run org/primefaces/test/ft/ShowcaseFt.java via IDE with Run/Debug as JUnit test  
