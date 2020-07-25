package test.java.dbunit.first_try._1_getting_started;

import static org.dbunit.PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL;
import static org.dbunit.PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS;
import static org.dbunit.PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD;
import static org.dbunit.PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME;
import static test.java.dbunit.first_try.Constants.DB_PASSWORD;
import static test.java.dbunit.first_try.Constants.DB_URL;
import static test.java.dbunit.first_try.Constants.DB_USER;

import java.io.FileInputStream;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;

// Next step is to improve decoupling from the "DBTestCase"
public class _1_DBTestCaseTest extends DBTestCase { // it is a JUnit Test

  public _1_DBTestCaseTest(String name) {
    super(name);
    // initiate database - default folder scanning at test/resources/db/migration
    Location location = new Location("_1_getting_started");
    Flyway flyway =
        Flyway.configure().dataSource(DB_URL, DB_USER, DB_PASSWORD).locations(location).load();
    flyway.migrate();

    // in DBTestCase.java, below loading the system properties
    //    protected IDatabaseTester newDatabaseTester() throws Exception {
    //      return new PropertiesBasedJdbcDatabaseTester();
    //    }
    System.setProperty(DBUNIT_DRIVER_CLASS, "org.h2.Driver");
    System.setProperty(DBUNIT_CONNECTION_URL, DB_URL);
    System.setProperty(DBUNIT_USERNAME, DB_USER);
    System.setProperty(DBUNIT_PASSWORD, DB_PASSWORD);
  }

  @Override
  protected IDataSet getDataSet() throws Exception {
    return new FlatXmlDataSetBuilder()
        .build(new FileInputStream("data/_1_getting_started/dataset.xml"));
  }

  public void test() {}
}
