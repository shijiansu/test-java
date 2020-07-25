package test.java.dbunit.first_try._1_getting_started;

import static test.java.dbunit.first_try.Constants.DB_DRIVER;
import static test.java.dbunit.first_try.Constants.DB_PASSWORD;
import static test.java.dbunit.first_try.Constants.DB_URL;
import static test.java.dbunit.first_try.Constants.DB_USER;

import com.alibaba.druid.pool.DruidDataSource;
import java.io.FileInputStream;
import javax.sql.DataSource;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;

// Use data source test case class. Know this class directly from source code.
public class _2_DataSourceBasedDBTestCaseTest
    extends DataSourceBasedDBTestCase { // it is a JUnit Test

  DataSource ds = dataSource(); // a shared data source

  DataSource dataSource() {
    DruidDataSource ds = new DruidDataSource();
    ds.setDriverClassName(DB_DRIVER);
    ds.setUrl(DB_URL);
    ds.setUsername(DB_USER);
    ds.setPassword(DB_PASSWORD);
    return ds;
  }

  public _2_DataSourceBasedDBTestCaseTest(String name) {
    super(name);
    // initiate database - default folder scanning at test/resources/db/migration
    Location location = new Location("_1_getting_started");
    Flyway flyway = Flyway.configure().dataSource(ds).locations(location).load();
    flyway.migrate();
  }

  @Override
  protected DataSource getDataSource() {
    return ds;
  }

  @Override
  protected IDataSet getDataSet() throws Exception {
    return new FlatXmlDataSetBuilder()
        .build(new FileInputStream("data/_1_getting_started/dataset.xml"));
  }

  public void test() {}
}
