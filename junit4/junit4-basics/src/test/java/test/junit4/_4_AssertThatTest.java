package test.junit4;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class _4_AssertThatTest {
  Calculator c;
  int x = 1;
  int y = 2;

  @Before
  public void setUp() {
    System.out.println("SetUp....");
    c = new Calculator();
  }

  @Test
  public void multiply() {
    System.out.println("testMultiply....");
    int expected = 2;
    int actual = c.multiply(x, y);
    // Matchers API
    assertThat(expected, is(actual));
  }

  @Test
  public void divide() {
    System.out.println("testDivide....");
    BigDecimal expected = new BigDecimal(0.5);
    BigDecimal actual = c.divide(x, y);
    // Matchers API
    assertThat(expected, is(actual));
  }
}
