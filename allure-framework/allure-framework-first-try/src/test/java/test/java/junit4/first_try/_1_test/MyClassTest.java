package test.java.junit4.first_try._1_test;

import static org.junit.Assert.assertEquals;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import test.java.junit4.first_try.MyClass;

@Epic("Allure examples")
@Feature("Junit 4 support")
/** Example for test */
public class MyClassTest {

  @BeforeClass
  public static void testSetup() {}

  @AfterClass
  public static void testCleanup() {
    // Teardown for data used by the unit tests
  }

  @Test(expected = IllegalArgumentException.class)
  @Story("Base support for bdd annotations")
  public void testExceptionIsThrown() {
    MyClass tester = new MyClass();
    tester.multiply(1000, 5);
  }

  @Test
  @Story("Advanced support for bdd annotations")
  public void testMultiply() {
    MyClass tester = new MyClass();
    assertEquals("Result", 50, tester.multiply(10, 5));
  }
}
