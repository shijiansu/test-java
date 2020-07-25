package test.java.dbunit.first_try._1_getting_started;

import static test.java.dbunit.first_try.Constants.DB_DRIVER;
import static test.java.dbunit.first_try.Constants.DB_PASSWORD;
import static test.java.dbunit.first_try.Constants.DB_URL;
import static test.java.dbunit.first_try.Constants.DB_USER;

import com.alibaba.druid.pool.DruidDataSource;
import java.io.FileInputStream;
import javax.sql.DataSource;
import org.dbunit.DBTestCase;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;

// Share the same data source, so that can use the in-memory database
public class _3_IDatabaseTesterTest extends DBTestCase { // it is a JUnit Test

  IDatabaseTester databaseTester;

  public _3_IDatabaseTesterTest(String name) {
    super(name);
  }

  DataSource ds = dataSource(); // a shared data source

  DataSource dataSource() {
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

  protected void setUp() throws Exception { // called by the parent class extends from JUnit Test
    // initiate database - default folder scanning at test/resources/db/migration
    Location location = new Location("_1_getting_started");
    Flyway flyway = Flyway.configure().dataSource(ds).locations(location).load();
    flyway.migrate();

    databaseTester = new DataSourceDatabaseTester(ds); // another one - JdbcDatabaseTester
    databaseTester.setDataSet(dataSet());
    databaseTester.onSetup(); // will call default setUpOperation
  }

  protected void tearDown() throws Exception { // called by the parent class extends from JUnit Test
    databaseTester.onTearDown();
  }

  @Override
  protected IDataSet getDataSet() {
    // would not use "DBTestCase" to get dataset
    throw new UnsupportedOperationException();
  }

  public void test() {}
}
