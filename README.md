![](https://img.shields.io/badge/language-java-blue)
![](https://img.shields.io/badge/technology-junit5,%20junit4,%20mockito3,%20database-rider,%20dbunit,%20easymock3-blue)
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

- allure-framework
  - allure-framework-first-try (**TEST REPORT**) - examples of Allure configuration for Allure test report
- assertj
- cucumber
- database-rider
  - database-rider-first-try - examples of database-rdier + JPA + HSQLDB + Assertj + JUnit4
    - `database-rider` enhance `DBUnit` for below features,
      - Integrating with JUnit4 (`@Rule`) and JUnit5 (`@ExtendWith`) + JPA (`EntityManagerProvider`)
      - 也有支持`rider-spring` - 这个是支持JUnit4 + Spring (不用`Spring Test DBUnit` - 这个项目很久了, 最近更新是2016)
        - 文档 - <https://github.com/database-rider/database-rider#8-spring>
      - Import data - `@DataSet`
      - Verify data - `@ExpectedDataSet`
      - Export data - `@ExportDataSet`
      - More file type support - e.g. yml
      - Build to create DBUnit `IDataSet`
  - database-rider-first-try-bdd (TBD) - examples of database-rdier + Cucumber (BDD) + CDI (Contexts and Dependency Injection for the Java EE platform)
  - database-rider-first-try-junit5 - examples of database-rdier + JPA + HSQLDB + Assertj + JUnit5
    - 直接支持JUnit5 + Spring, 不需要使用`rider-spring`
- dbunit
  - dbunit-first-try - examples of dbunit + H2 + Flyway (default folder is resources/db/migration) + Apache Druid + JUnit4 (as default). Understand how to connect to database; export to dataset file; verify tables.
    - Pre-condition, need to prepare the database structure e.g. schema and tables, the tables can be created via,
      - Flyway, etc. database migration tool + embedded database environment;
      - Hibernate auto-ddl = create, with or without Spring + embedded database environment;
      - Existing database server with tables.
    - Key features
      - Wrapper with database connection
      - Import dataset file to database data
      - Export database data to dataset file
      - Verify data
        - 单纯的`DBUnit`, 是通过DBUnit的API, 直接verify其ITable
        - 如果使用`database-rider`, 可通过JPA读取数据, 使用第三方lib(e.g. Assertj), verify对应的Entity
    - Few possible use cases
      - Use DBUnit to unit test on data access layer, e.g. Entity and Repository behaviour
      - Use DBUnit to set up testing data in slicing testing on a controller (saving effort from saving data all the time by JPA Entity)
      - Data import and validation together with `database-rider`
  - dbunit-first-try-junit5 -  examples of dbunit + H2 + Flyway + Apache Druid + JUnit5
  - dbunit-junit5-springboot2 - examples of dbunit + database-rider (mostly) + Spring Boot2 + Junit5 + H2
    - Refer to <https://github.com/database-rider/database-rider/tree/master/rider-examples/spring-boot-dbunit-sample>
    - @DBRider is with @ExtendWith(DBUnitExtension.class) - to support all annotations for DBUnit
    - @SpringBootTest is with @ExtendWith(SpringExtension.class)
- easymock
  - easymock-basics - examples of easymock basic syntax and usage
- hamcrest
- junit4
  - junit4-basics - examples of junit4 basics syntax and usage
  - junit4-first-try (**TEST REPORT**) + (**test report baseline project**) - examples of junit4 all features + pl.pragmatists.JUnitParams for parameterizing
    - JUnit report - Maven Surefire report plugin -> run-test.sh
- junit5
  - junit5-first-try - examples of junit5 basics syntax and usage
    - JUnit report - Maven Surefire report plugin -> run-test.sh
- mockito
  - mockito3-first-try - examples of mockito to with mock features, BDD, static method, and all features mentions at Mockito.java JavaDoc
- rest-assured
- robot-framework
- selenium
- spock-framework
- testng
- wire-mock

--------------------------------------------------------------------------------

# Execute all tests in repo

`/bin/bash run-repo-test.sh`

--------------------------------------------------------------------------------
