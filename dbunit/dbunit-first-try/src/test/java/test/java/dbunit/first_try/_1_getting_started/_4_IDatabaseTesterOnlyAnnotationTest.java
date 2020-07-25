package test.java.dbunit.first_try._1_getting_started;

import static test.java.dbunit.first_try.Constants.DB_DRIVER;
import static test.java.dbunit.first_try.Constants.DB_PASSWORD;
import static test.java.dbunit.first_try.Constants.DB_URL;
import static test.java.dbunit.first_try.Constants.DB_USER;

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
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// Base on "_3_IDatabaseTesterTest", to remove dependency of "extends DBTestCase".
// After remove "extends DBTestCase", next step is to onboard the JUnit5
public class _4_IDatabaseTesterOnlyAnnotationTest {

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

  @BeforeClass
  public static void initTables() {
    // one time only for the database tables creation
    // initiate database - default folder scanning at test/resources/db/migration
    Location location = new Location("_1_getting_started");
    Flyway flyway = Flyway.configure().dataSource(ds).locations(location).load();
    flyway.migrate();
  }

  @SneakyThrows
  @Before
  public void setUp() { // called by the parent class extends from JUnit Test
    databaseTester = new DataSourceDatabaseTester(ds); // another one - JdbcDatabaseTester
    databaseTester.setDataSet(dataSet());
    databaseTester.onSetup(); // will call default setUpOperation
  }

  @SneakyThrows
  @After
  public void tearDown() { // called by the parent class extends from JUnit Test
    databaseTester.onTearDown();
  }

  @Test
  public void test() {}
}
