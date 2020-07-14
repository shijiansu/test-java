package test.java.junit4.basics;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class _3_ParameterizedTest {
  private int expected;
  private int x;
  private int y;

  private Calculator calculator;

  @Parameters
  public static Collection<Object[]> prepareData() {
    Object[][] objects = {{1, 2, 2}, {2, 3, 6}, {4, 8, 32}};
    return Arrays.asList(objects);
  }

  public _3_ParameterizedTest(int x, int y, int expected) {
    this.x = x;
    this.y = y;
    this.expected = expected;
  }

  @Before
  public void setUp() {
    calculator = new Calculator();
  }

  @After
  public void tearDown() {
    calculator = null;
  }

  @Test
  public void testMultiply() {
    assertEquals(expected, calculator.multiply(x, y));
  }
}
