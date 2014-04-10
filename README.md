## Arquillian tests for Primefaces


### Running tests:
--------------


1. activate server profile(wildfly-managed[default] or jboss-managed) in your IDE or when firing the mvn
2. chose a test profile(all-tests[default], ft-tests, at-tests or warp-tests)
3. example: mvn clean test -Pjboss-managed -Pft-tests (will run functional tests on jboss as 7)

#### first time running tests:

1. from prime-arquillian dir fire mvn clean install to install primefaces and prime-arquillian components into local maven repo
2. subsequent test commands can be fired from showcase submodule via mvn test.
  1. note that you can run ShowcaseFt.java(functional tests), ShowcaseAt.java(acceptance tests) or ShowcaseWarp.java(gray box tests) via IDE with Run/Debug as JUnit test. In this case no need to mvn install cause IDE should handle maven modules dependencies.
