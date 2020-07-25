package test.java.junit4.first_try._2_test_runner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import test.java.junit4.first_try.MyClass;

public class MyClassFailureTests {
  @Test
  public void multiplicationOfZeroIntegersShouldReturnZero() {
    MyClass tester = new MyClass(); // MyClass is tested

    // assert statements
    assertEquals(0, tester.multiply(10, 0)); // "10 x 0 must be 0"
    assertEquals(0, tester.multiply(0, 10)); // "0 x 10 must be 0"
    assertEquals(0, tester.multiply(0, 0)); // "0 x 0 must be 0"
  }

  @Test(expected = ArithmeticException.class)
  public void divideOfZeroIntegersShouldFailed() {
    MyClass tester = new MyClass(); // MyClass is tested

    // assert statements
    assertEquals(0, tester.divide(10, 0)); // "10 x 0 must be 0"
  }
}
