package test.java.junit4.first_try._2_test_runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/** Example for running test from the command line */
public class MyClassFailureTestRunner {
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(MyClassFailureTests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
    System.out.println("test case count: " + result.getRunCount());
  }
}
