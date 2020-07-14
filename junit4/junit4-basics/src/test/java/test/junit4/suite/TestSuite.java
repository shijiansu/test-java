package test.junit4.suite;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import test.junit4._1_CalculatorTest;
import test.junit4._2_StartupAndTearDownTest;

@RunWith(Suite.class)
@SuiteClasses({_1_CalculatorTest.class, _2_StartupAndTearDownTest.class})
public class TestSuite {
  private static PrintStream systemErr;

  @BeforeClass
  public static void redirectStderr() {
    systemErr = System.err; // Hold on to the original value
    System.setErr(new PrintStream(new ByteArrayOutputStream()));
  }

  @AfterClass
  public static void tearDown() {
    // restore the original value
    System.setErr(systemErr);
  }
}
