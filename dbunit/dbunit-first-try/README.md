# The examples here

这里代码的例子是渐进改进的

# How to start

- 这里有几个例子, 不是太实用 - <http://dbunit.sourceforge.net/howto.html>
- 在Maven repository里面发现这个命名为`DbUnit Extension`, 是不是暗示应该直接使用JUnit5的extension呢?
  - <https://mvnrepository.com/artifact/org.dbunit/dbunit/2.7.0>
  - dbUnit is a JUnit extension (also usable from Ant and Maven) targeted for database-driven projects that, among other things, puts your database into a known state between test runs. This is an excellent way to avoid the myriad of problems that can occur when one test case corrupts the database and causes subsequent tests to fail or exacerbate the damage.

# Some knowledge

- 建立数据库连接 -> 备份表 -> 调用Dao层接口 -> 从数据库取实际结果-> 事先准备的期望结果 -> 断言 -> 回滚数据库 -> 关闭数据库连接
- FlatXmlDataSet - 要注意, 如果数据库中某一条字段为null, 在flat XML中将不会显示该attribute. 另外, FlatXmlDataSet用XML文件中该表的第一行数据来制定表的结构. 因此, 如果数据库中某个字段所有记录都为null, 或者恰巧第一条记录为null, 那么得到的表结构与原数据库的表结构就不一致了, 测试就会失败. FlatXmlDataSet中存在一个column sensing的概念, 在从文件加载数据时, 将该属性设置为true, 就会根据第一行展现出来的表结构, 自动将别的行的列补齐.
- Extra columns on line x. Those columns will be ignored. Please add the extra columns to line 1, or use a DTD to make sure the value of those columns are populated. - 则需要用setColumnSensing = true
- 再一个关于`setColumnSensing = true`; 遇到导入某个 dataaset 文件(XML格式, 里面有多个表), 发现数据没有导入, 由于目标数据库是H2, 导致排查困难
  - 启动更多的日志 - 通过查看dbunit在Maven的依赖, 发现依赖`slf4j`, 在本例子已经有logback, 所以配置`logback.xml`
  - 在日志中定位`insert into`
  - 发现`WARN` - FlatXmlProducer - Extra columns .... or specify 'columnSensing=true'
  - 原因: 某些数据问题导致后面数据提示额外的列, 从而导致某些表所有列都被忽略, 然后整个表都没有被插入数据
  - 解决: 在`new FlatXmlDataSetBuilder().setColumnSensing(true)`

# Java development environment

`sdk list java && sdk current java`

# Setup Maven wrapper

- https://github.com/takari/maven-wrapper

`mvn -N io.takari:maven:0.7.7:wrapper -Dmaven=3.5.4`
