package test.java.junit4.basics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class _2_StartupAndTearDownTest {
  Calculator c;
  int x = 1;
  int y = 2;

  // handle by JUnit + annotation
  @Before
  public void setUp() {
    System.out.println("SetUp....");
    // create resource as connect database...
    c = new Calculator();
  }

  // handle by JUnit+ annotation
  @After
  public void tearDown() {
    System.out.println("turnDown....");
    // release resource
    c = null;
  }

  @Test
  @Ignore
  public void multiply() {
    System.out.println("testMultiply....");
    int expected = 2;
    int actual = c.multiply(x, y);
    assertEquals(expected, actual);
    // fail("Not yet implemented");
  }

  @Test
  public void divide() {
    System.out.println("testDivide....");
    BigDecimal expected = new BigDecimal(0.5);
    BigDecimal actual = c.divide(x, y);
    assertEquals(expected, actual);
    // fail("Not yet implemented");
  }

  @Test(expected = ArithmeticException.class)
  public void divide_zero() {
    System.out.println("testDivide....");
    BigDecimal expected = new BigDecimal(0.5);
    BigDecimal actual = c.divide(x, 0);
    assertEquals(expected, actual);
    // fail("Not yet implemented");
  }

  @Ignore
  @Test(timeout = 100)
  public void is_time_out() {
    // this one failed as time out > 100
    System.out.println("testIsTimeOut....");
    boolean input = true;
    assertEquals(input, c.isTimeOut(input));
  }

  @Test(timeout = 100)
  public void is_time_out2() {
    System.out.println("testIsTimeOut2....");
    boolean input = false;
    assertEquals(input, c.isTimeOut(input));
  }
}
