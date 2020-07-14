package test.java.junit4.basics;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class _1_CalculatorTest {
  @Test
  public void multiply() {
    Calculator c = new Calculator();
    int x = 1;
    int y = 2;
    int expected = 2;
    int actual = c.multiply(x, y);
    assertEquals(expected, actual);
    // fail("Not yet implemented");
  }

  @Test
  public void addition() {
    int x = 1;
    int y = 1;
    int z = x + y;
    Assert.assertEquals(2, z);
  }
}
