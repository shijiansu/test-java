package test.java.junit5.first_try._1_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import test.java.junit5.first_try.MyClass;

/** First example of unit test 5 */
public class MyClassJunit5Tests {

  @Test
  public void multiplicationOfZeroIntegersShouldReturnZero() {
    MyClass tester = new MyClass(); // MyClass is tested

    // assert statements
    assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
    assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
    assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");
  }
}
