# How does it work

- 参考 - <https://my.oschina.net/tree/blog/3003601>
- database-rider - 和Junit5一起使用 - <https://database-rider.github.io/getting-started/#example_2>

# 基本加载流程

- Embedded database (H2) -> call database URL + H2 lib
- Data source - Spring -> SPring Data -> JDBC -> HikariCP
- JPA - Spring -> Spring Data -> yml -> Data source + properties -> Entity manager
- JDBC Driver - properties + H2 lib -> load the driver and adaptor (if any)

database-rider rider-junit5 -> 依赖 database-rider rider-core -> 依赖 dbunit


# Java development environment

`sdk list java && sdk current java`

# Setup Maven wrapper

- https://github.com/takari/maven-wrapper

`mvn -N io.takari:maven:0.7.7:wrapper -Dmaven=3.5.4`

# Script step by step

```bash
./mvnw clean spring-boot:run
```

# One stop script

```bash
/bin/bash run.sh
/bin/bash run-test.sh
/bin/bash run-stop.sh
```
