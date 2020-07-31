package test.java.junit4.basics.suite;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteMain {
  public static void main(String[] args) {
    // in maven, this way can not work... as different classpath
    Result result = org.junit.runner.JUnitCore.runClasses(TestSuite.class);
    echo("ignore count", result.getIgnoreCount());
    echo("run count", result.getRunCount());
    echo("run time", result.getRunTime());
    echo("is success", result.wasSuccessful());
    echo("failure count", result.getFailureCount());
    for (Failure failure : result.getFailures()) {
      echo("", failure.getDescription());
    }
  }

  public static void echo(String key, Object msg) {
    System.out.println(key + " : " + msg);
  }
}
