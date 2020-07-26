# About JUnit 5 dependencies issue

JUnit 5 dependencies issue happens if using older version of Intellij

> Exception in the thread "main" java.lang.NoClassDefFoundError: org/junit/platform/commons/logging/LoggerFactory

- https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000669264--SOLVED-JUnit-tests-fail-with-Emtpy-test-suite-and-exception-from-LoggerFactory-IntelliJ-2017-2-5
- https://junit.org/junit5/docs/current/user-guide/#running-tests-ide-intellij-idea
  - > recommended to use IDEA 2017.3 or newer since these newer versions of IDEA will download the following JARs automatically based on the API version used in the project: junit-platform-launcher, junit-jupiter-engine, and junit-vintage-engine.

# Java development environment

`sdk list java && sdk current java`

# Setup Maven wrapper

- https://github.com/takari/maven-wrapper

`mvn -N io.takari:maven:0.7.7:wrapper -Dmaven=3.5.4`
