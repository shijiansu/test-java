package test.java.junit4.first_try._6_rule_customization;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Usage,
 *
 * <pre>
 *   @Rule
 *   public MyCustomRule myRule = new MyCustomRule();
 * </pre>
 */
public class MyCustomRule implements TestRule {

  private Statement base;
  private Description description;

  @Override
  public Statement apply(Statement base, Description description) {
    this.base = base;
    this.description = description;
    return new MyStatement(base);
  }

  public class MyStatement extends Statement {

    private final Statement base;

    public MyStatement(Statement base) {
      this.base = base;
    }

    @Override
    public void evaluate() throws Throwable {
      System.out.println("MyCustomRule " + description.getMethodName() + "Started");
      try {
        base.evaluate();
      } finally {
        System.out.println("MyCustomRule " + description.getMethodName() + "Finished");
      }
    }
  }
}
