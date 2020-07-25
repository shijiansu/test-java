package test.java.junit5.first_try._2_test_launcher;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import test.java.junit5.first_try._1_test.MyClassJunit5Tests;

/**
 * @see <a href="https://junit.org/junit5/docs/current/user-guide/#launcher-api">7.1. JUnit Platform
 *     Launcher API</a>
 */
public class MyClassJunit5TestLauncher {

  public static void main(String[] args) {

    LauncherDiscoveryRequest request =
        LauncherDiscoveryRequestBuilder.request()
            .selectors(selectPackage("com.example.first"), selectClass(MyClassJunit5Tests.class))
            .filters(includeClassNamePatterns(".*Tests"))
            .build();

    Launcher launcher = LauncherFactory.create();

    TestPlan testPlan = launcher.discover(request);
  }
}
