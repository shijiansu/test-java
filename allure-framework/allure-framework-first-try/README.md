Test case copies from project `test-java/junit4/junit4-first-try`

# How to start

一个报表为主的框架, 主要工作是配置而非写代码.

- <https://docs.qameta.io/allure/#_about>

## 1. 使用配置JUnit4 + Maven Surefire

这里两个维度可以配置, (1) 测试框架 - 本例子使用Java的JUnit4; 还有JUnit5, Python等 和 (2) 测试报告生成工具 - 本例子使用Maven Surefire; 还有Gradle

`JUnit4`对应的依赖, 提供API在Java代码使用, 主要是注释, 将测试用例分组(e.g. @Epic, @Feature, @Story - <https://docs.qameta.io/allure/#_behaviours_mapping>)

```xml
<dependency>
  <groupId>io.qameta.allure</groupId>
  <artifactId>allure-junit4</artifactId>
  <version>2.13.5</version>
  <scope>test</scope>
</dependency>
```

`Maven Surefire`配置是告诉`mvn test`时候生成`allure`测试报告, 具体配置参见`pom.xml`

`mvn clean test`

## 运行可视化测试报告

多种执行方式, 执行后会运行一个本地网站, 例如`http://192.168.1.192:64684/`

### 2.1 Maven插件方式

- <https://docs.qameta.io/allure/#_maven_6>

```xml
<plugin>
  <groupId>io.qameta.allure</groupId>
  <artifactId>allure-maven</artifactId>
  <version>2.10.0</version>
</plugin>
```

其中Allure报表默认版本是2.7.0 (20200726). 不要混饶API版本, Maven插件版本和Allure报表版本(感觉上类似对应网站版本)

```bash
# 生成
mvn clean test
# 运行
mvn allure:serve # 注意 allure-results要一致
```

### 2.2 命令行方式

- MacOS环境 - <https://docs.qameta.io/allure/#_installing_a_commandline>

```bash
# 安装
brew install allure
allure --version
# 生成
mvn clean test
# 运行
allure serve target/allure-results  # 注意 allure-results要一致
```
