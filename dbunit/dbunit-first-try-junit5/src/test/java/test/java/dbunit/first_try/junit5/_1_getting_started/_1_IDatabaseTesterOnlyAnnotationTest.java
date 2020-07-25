package test.java.dbunit.first_try.junit5._1_getting_started;

import static test.java.dbunit.first_try.junit5.Constants.DB_DRIVER;
import static test.java.dbunit.first_try.junit5.Constants.DB_PASSWORD;
import static test.java.dbunit.first_try.junit5.Constants.DB_URL;
import static test.java.dbunit.first_try.junit5.Constants.DB_USER;

import com.alibaba.druid.pool.DruidDataSource;
import java.io.FileInputStream;
import javax.sql.DataSource;
import lombok.SneakyThrows;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _1_IDatabaseTesterOnlyAnnotationTest {

  IDatabaseTester databaseTester;

  static DataSource ds = dataSource(); // a shared data source

  static DataSource dataSource() {
    DruidDataSource ds = new DruidDataSource();
    ds.setDriverClassName(DB_DRIVER);
    ds.setUrl(DB_URL);
    ds.setUsername(DB_USER);
    ds.setPassword(DB_PASSWORD);
    return ds;
  }

  IDataSet dataSet() throws Exception {
    return new FlatXmlDataSetBuilder()
        .build(new FileInputStream("data/_1_getting_started/dataset.xml"));
  }

  @BeforeAll
  public static void initTables() {
    // one time only for the database tables creation
    // initiate database - default folder scanning at test/resources/db/migration
    Location location = new Location("_1_getting_started");
    Flyway flyway = Flyway.configure().dataSource(ds).locations(location).load();
    flyway.migrate();
  }

  @SneakyThrows
  @BeforeEach
  public void setUp() { // called by the parent class extends from JUnit Test
    databaseTester = new DataSourceDatabaseTester(ds); // another one - JdbcDatabaseTester
    databaseTester.setDataSet(dataSet());
    databaseTester.onSetup(); // will call default setUpOperation
  }

  @SneakyThrows
  @AfterEach
  public void tearDown() { // called by the parent class extends from JUnit Test
    databaseTester.onTearDown();
  }

  @Test
  public void test() {}
}
