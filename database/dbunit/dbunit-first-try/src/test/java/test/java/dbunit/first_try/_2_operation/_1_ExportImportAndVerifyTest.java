package test.java.dbunit.first_try._2_operation;

import static test.java.dbunit.first_try.Constants.DB_DRIVER;
import static test.java.dbunit.first_try.Constants.DB_PASSWORD;
import static test.java.dbunit.first_try.Constants.DB_URL;
import static test.java.dbunit.first_try.Constants.DB_USER;

import com.alibaba.druid.pool.DruidDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.sql.DataSource;
import org.dbunit.Assertion;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.DefaultTable;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.csv.CsvDataSetWriter;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// This example also can use JUnit5, but not JUnit4
public class _1_ExportImportAndVerifyTest {

  static DataSource ds = dataSource(); // a shared data source

  static DataSource dataSource() {
    DruidDataSource ds = new DruidDataSource();
    ds.setDriverClassName(DB_DRIVER);
    ds.setUrl(DB_URL);
    ds.setUsername(DB_USER);
    ds.setPassword(DB_PASSWORD);
    ds.setTestWhileIdle(false);
    return ds;
  }

  @BeforeClass
  public static void initTables() {
    // one time only for the database tables creation
    // initiate database - default folder scanning at test/resources/db/migration
    Location location = new Location("_2_operation");
    Flyway flyway = Flyway.configure().dataSource(ds).locations(location).load();
    flyway.migrate();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() {}

  @Test
  public void exportFlatXml() throws Exception {
    DatabaseConnection conn = new DatabaseConnection(ds.getConnection());
    DatabaseConfig dbConfig = conn.getConfig();
    // add this line to get rid of the warning - telling which database vendor
    dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

    // exporting data as backup
    QueryDataSet backup = new QueryDataSet(conn); // also a "IDataSet"
    backup.addTable("person");
    FlatXmlDataSet.write(
        backup, new FileOutputStream("data/_2_operation_out/person_backup_flat.xml"));
    conn.close();
  }

  @Test
  public void exportXml() throws Exception {
    DatabaseConnection conn = new DatabaseConnection(ds.getConnection());
    DatabaseConfig dbConfig = conn.getConfig();
    // add this line to get rid of the warning - telling which database vendor
    dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

    // exporting data as backup
    QueryDataSet backup = new QueryDataSet(conn); // also a "IDataSet"
    backup.addTable("person");
    XmlDataSet.write(backup, new FileOutputStream("data/_2_operation_out/person_backup.xml"));
    conn.close();
  }

  @Test
  public void exportCsv() throws Exception {
    DatabaseConnection conn = new DatabaseConnection(ds.getConnection());
    DatabaseConfig dbConfig = conn.getConfig();
    // add this line to get rid of the warning - telling which database vendor
    dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

    // exporting data as backup
    QueryDataSet backup = new QueryDataSet(conn);
    backup.addTable("person");
    CsvDataSetWriter.write(backup, new File("data/_2_operation_out/person_backup_csv"));
    conn.close();
  }

  @Test
  public void exportXls() throws Exception {
    DatabaseConnection conn = new DatabaseConnection(ds.getConnection());
    DatabaseConfig dbConfig = conn.getConfig();
    // add this line to get rid of the warning - telling which database vendor
    dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

    // exporting data as backup
    QueryDataSet backup = new QueryDataSet(conn);
    backup.addTable("person");
    XlsDataSet.write(backup, new FileOutputStream("data/_2_operation_out/person_backup.xls"));
    conn.close();
  }

  @Test
  public void exportPersonWhichIdEqual1() throws Exception {
    DatabaseConnection conn = new DatabaseConnection(ds.getConnection());
    DatabaseConfig dbConfig = conn.getConfig();
    // add this line to get rid of the warning - telling which database vendor
    dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

    // exporting data as backup
    QueryDataSet backup = new QueryDataSet(conn);
    backup.addTable("person", "SELECT * FROM person WHERE id = 1");
    FlatXmlDataSet.write(
        backup, new FileOutputStream("data/_2_operation_out/person_backup_id_1.xml"));
    conn.close();
  }

  @Test
  public void given3PersonRecords_WhenExportAndImport_ThenVerifyAsTheSame() throws Exception {
    // GIVEN
    // As in Flyway
    DatabaseConnection conn = new DatabaseConnection(ds.getConnection());
    DatabaseConfig dbConfig = conn.getConfig();
    // add this line to get rid of the warning - telling which database vendor
    dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

    // WHEN
    // importing data as expected result
    IDataSet expected = // also a "IDataSet"
        new FlatXmlDataSetBuilder()
            .setColumnSensing(true)
            .build(new FileInputStream("data/_2_operation/dataset.xml"));
    ITable expectedTable = expected.getTable("person");
    // actual from database
    IDataSet databaseDataSet = conn.createDataSet();
    ITable actualTable = databaseDataSet.getTable("person");
    // to exclude columns
    // ITable filteredExpectedTable = DefaultColumnFilter.excludedColumnsTable(expectedTable, new
    // String[]{"birthday"});

    // THEN
    Assertion.assertEquals(expectedTable, actualTable);
    Assert.assertEquals(3, actualTable.getRowCount());
    conn.close();
  }

  @Test
  public void giveCleanPersonTable_WhenQuery_ThenNoRecord() throws Exception {
    // GIVEN
    DatabaseConnection conn = new DatabaseConnection(ds.getConnection());
    DatabaseConfig dbConfig = conn.getConfig();
    // add this line to get rid of the warning - telling which database vendor
    dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
    // clean
    DefaultDataSet dataset = new DefaultDataSet();
    dataset.addTable(new DefaultTable("person"));
    DatabaseOperation.DELETE_ALL.execute(conn, dataset);

    // WHEN
    IDataSet databaseDataSet = conn.createDataSet();
    ITable actualTable = databaseDataSet.getTable("person");

    // THEN
    Assert.assertEquals(0, actualTable.getRowCount());
    conn.close();
  }
}
