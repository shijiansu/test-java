![](https://img.shields.io/badge/language-java-blue)
![](https://img.shields.io/badge/technology-junit5,%20junit4,%20mockito3,%20easymock3-blue)
![](https://img.shields.io/badge/development%20year-2020-orange)
![](https://img.shields.io/badge/contributor-shijian%20su-purple)
![](https://img.shields.io/badge/license-MIT-lightgrey)

![](https://img.shields.io/github/languages/top/shijiansu/)
![](https://img.shields.io/github/languages/count/shijiansu/)
![](https://img.shields.io/github/languages/code-size/shijiansu/)
![](https://img.shields.io/github/repo-size/shijiansu/)
![](https://img.shields.io/github/last-commit/shijiansu/?color=red)

![](https://github.com/shijiansu//workflows/ci%20build/badge.svg)

--------------------------------------------------------------------------------

- junit4
  - junit4-basics - examples of junit4 basics syntax and usage
  - junit4-first-try - examples of junit4 all features + pl.pragmatists.JUnitParams for parameterizing
- junit5
  - junit5-first-try - examples of junit5 basics syntax and usage
- easymock
  - easymock-basics - examples of easymock basic syntax and usage
- mockito
  - mockito3-first-try - examples of mockito to with mock features, BDD, static method, and all features mentions from official Mockito.java JavaDoc
- dbunit
  - dbunit-junit5-springboot2 - examples of dbunit + database-rider (enhancer of dbunit) + Spring Boot2 + Junit5 + H2. This example is using SpringBoot2 +  
    - @DBRider is with @ExtendWith(DBUnitExtension.class) - to support all annotations for DBUnit
    - @SpringBootTest is with @ExtendWith(SpringExtension.class)
    - Pre-condition
      - Need to prepare the database structure e.g. schema and tables;
      - The tables can be created via,
        - Flyway, etc. database migration tool + embedded database environment;
        - Hibernate auto-ddl = create, with or without Spring + embedded database environment;
        - Existing database server with tables.
    - Few possible use cases
      - Use DBUnit to unit test on data access layer, e.g. Entity and Repository behaviour
      - Use DBUnit to set up testing data in slicing testing on controller (saving effort from saving data all the time by JPA Entity)
      - Data validation together with `database-rider`
  - dbunit-first-try - examples of dbunit + H2 + Flyway + Apache Druid + JUnit4 (as default). Understand how to connect to database; export to dataset file; verify tables. 
  - dbunit-first-try-junit5 -  examples of dbunit + H2 + Flyway + Apache Druid + JUnit5
- database-rider
  - database-rider-first-try
  - database-rider-first-try-junit5

--------------------------------------------------------------------------------

# Execute all tests in repo

`/bin/bash run-repo-test.sh`

--------------------------------------------------------------------------------
