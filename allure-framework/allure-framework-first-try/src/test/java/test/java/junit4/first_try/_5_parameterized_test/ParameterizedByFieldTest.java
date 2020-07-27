package test.java.junit4.first_try._5_parameterized_test;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import test.java.junit4.first_try.MyClass;

/**
 * Example for parameterized test
 *
 * <p>Mark a test class as a parameterized test with the @RunWith(Parameterized.class) annotation.
 */
@RunWith(Parameterized.class)
public class ParameterizedByFieldTest {

  // fields used together with @Parameter must be public
  @Parameter(0)
  public int m1;

  @Parameter(1)
  public int m2;

  @Parameter(2)
  public int result;

  // creates the test data
  @Parameters
  public static Collection<Object[]> data() {
    Object[][] data =
        new Object[][] {
          {1, 2, 2},
          {5, 3, 15},
          {121, 4, 484}
        };
    return Arrays.asList(data);
  }

  @Test
  public void testMultiplyException() {
    MyClass tester = new MyClass();
    assertEquals("Result", result, tester.multiply(m1, m2));
  }
}
