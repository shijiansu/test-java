package test.java.junit4.first_try._6_rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import test.java.junit4.first_try.MyClass;

/**
 * Example for rule
 *
 * <p>
 *
 * @see <a href="https://github.com/junit-team/junit4/wiki/rules">Junit4 Rules</a>
 *     <p>Some pre-defined rules,
 *     <p>
 *     <ul>
 *       <li><code>TemporaryFolder</code>
 *       <li><code>ExternalResource</code>
 *       <li><code>ErrorCollector</code>
 *       <li><code>Verifier</code>
 *       <li><code>TestWatchman</code>/<code>TestWatcher</code>
 *       <li><code>TestName</code>
 *       <li><code>Timeout</code>
 *       <li><code>ExpectedException</code>
 *       <li><code>ClassRule</code>
 *       <li><code>RuleChain</code>
 *     </ul>
 */
public class RuleExpectedExceptionTest {

  // Via JUnit rules you can add behavior to each tests in a test class
  @Rule public ExpectedException exception = ExpectedException.none();

  @Test
  public void throwsIllegalArgumentExceptionIfIconIsNull() {
    exception.expect(IllegalArgumentException.class);
    // error message must match also
    exception.expectMessage("X should be less than 1000");
    MyClass tester = new MyClass();
    tester.multiply(1000, 5);
  }
}
