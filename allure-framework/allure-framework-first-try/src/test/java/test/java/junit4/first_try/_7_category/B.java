package test.java.junit4.first_try._7_category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({SlowTests.class, FastTests.class})
public class B {

  @Test
  public void c() {}
}
