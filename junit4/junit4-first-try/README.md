# How to run JUnit report

添加`src/site/site.xml`

```bash
#!/bin/bash
# 解释 - surefire-report:report是触发test并生成有测试报告HTML (从${basedir}/target/surefire-reports获取 <- surefire插件生成的测试数据目录).
# 这个HTML没有样式, 只是依赖Maven site的默认样式 (可在src/site/site.xml配置最新版, 默认取版本1.0)
# surefire-report:report - will trigger mvn test;
# site -DgenerateReports=false - generate the css files to surefire-report, but not the full site
# a default maven skin library is at src/site/site.xml
./mvnw clean surefire-report:report site -DgenerateReports=false
# 结果生成在target/site/surefire-report.html

# 不触发mvn test, 可和mvn test分开执行
./mvnw clean surefire-report:report-only site -DgenerateReports=false

# 将测试报表打包在Maven site里面
./mvnw site
```

# Java development environment

`sdk list java && sdk current java`

# Setup Maven wrapper

- https://github.com/takari/maven-wrapper

`mvn -N io.takari:maven:0.7.7:wrapper -Dmaven=3.5.4`
