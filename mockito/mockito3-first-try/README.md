# How to know the feature and the examples

- See this source code, it is the best document - <https://github.com/mockito/mockito/blob/release/3.x/src/main/java/org/mockito/Mockito.java>
- References
  - <https://site.mockito.org/>
  - <https://dzone.com/refcardz/mockito>
  - BDD style - <https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/BDDMockito.html>

# Concept

Test doubles can be divided into a few groups:

- Dummy - an empty object passed in an invocation (usually only to satisfy a compiler when a method ar- gument is required)
- Fake - an object having a functional implementation, but usually in a simplified form, just to satisfy the test (e.g., an in-memory database)
- Stub - an object with hardcoded behavior suitable for a given test (or a group of tests)
- Mock - an object with the ability to a) have a programmed expected behavior, and b) verify the interactions occurring in its lifetime (this object is usually created with the help of mocking framework)
- Spy - a mock created as a proxy to an existing real object; some methods can be stubbed, while the un- stubbed ones are forwarded to the covered object

also can view more details from - <https://martinfowler.com/articles/mocksArentStubs.html>

# Limitations

Mockito cannot:

- mock final classes
- mock enums
- mock final methods
- mock static methods (Since 3.4.0)
- mock private methods
- mock hashCode() and equals()

# Java development environment

`sdk list java && sdk current java`

# Setup Maven wrapper

- https://github.com/takari/maven-wrapper

`mvn -N io.takari:maven:0.7.7:wrapper -Dmaven=3.5.4`
