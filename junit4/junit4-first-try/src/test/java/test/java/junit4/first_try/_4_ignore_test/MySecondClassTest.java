package test.java.junit4.first_try._4_ignore_test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import test.java.junit4.first_try.MyClass;

/** Example for ignore tests */
public class MySecondClassTest {

  @BeforeClass
  public static void testSetup() {}

  @AfterClass
  public static void testCleanup() {
    // Teardown for data used by the unit tests
  }

  /** Disabling tests - Ignore */
  @Ignore
  @Test(expected = IllegalArgumentException.class)
  public void testExceptionIsThrown() {
    MyClass tester = new MyClass();
    tester.multiply(1, 5);
  }

  /** Disabling tests - Assume */
  @Test
  public void testMultiply() {
    // No way can fix the test case in the other OS besides Linux
    Assume.assumeTrue(System.getProperty("os.name").contains("Linux"));
    MyClass tester = new MyClass();
    assertEquals("Result", 50, tester.multiply(10, 5));
  }
}
