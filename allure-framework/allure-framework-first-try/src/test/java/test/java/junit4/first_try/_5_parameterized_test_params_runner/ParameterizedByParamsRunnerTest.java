package test.java.junit4.first_try._5_parameterized_test_params_runner;

import static org.junit.Assert.assertEquals;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.java.junit4.first_try.MyClass;

/**
 * Example for parameterized test with JUnitParams
 *
 * <p>
 *
 * @see <a href="https://github.com/Pragmatists/JUnitParams">JUnitParams</a>
 */
@RunWith(JUnitParamsRunner.class)
public class ParameterizedByParamsRunnerTest {

  @Test
  // be careful, here imports different Parameters class
  @junitparams.Parameters({"1, 2, 2", "5, 3, 15", "121, 4, 484"})
  public void testMultiplyException(int m1, int m2, int result) {
    MyClass tester = new MyClass();
    assertEquals("Result", result, tester.multiply(m1, m2));
  }
}
