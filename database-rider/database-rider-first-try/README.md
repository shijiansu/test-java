# How to start

- database-rider主要作用是帮助导入数据和验证数据

Search keyword `database-rider` in Google,

- 功能汇总页 - <https://database-rider.github.io/database-rider/>
  - 点击`Documentation`查看最近版本的文档
- 详细的文档 - <https://database-rider.github.io/getting-started/>
  - 例子所对应的model在源代码的test里面 - <https://github.com/database-rider/database-rider/tree/master/rider-core/src/test/java/com/github/database/rider/core/model>
  - dataset配置例子 - <https://github.com/database-rider/database-rider/tree/master/rider-core/src/test/resources/datasets>, 其中的XML格式, 是和`dbunit`的`flatxml`格式一致
- 源代码 - <https://github.com/database-rider/database-rider>

# Java development environment

`sdk list java && sdk current java`

# Setup Maven wrapper

- https://github.com/takari/maven-wrapper

`mvn -N io.takari:maven:0.7.7:wrapper -Dmaven=3.5.4`
