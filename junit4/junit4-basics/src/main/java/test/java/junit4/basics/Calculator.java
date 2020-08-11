package test.java.junit4.basics;

import java.math.BigDecimal;

public class Calculator {
  public int multiply(int x, int y) {
    return x * y;
  }

  public BigDecimal divide(int x, int y) {
    return new BigDecimal(x).divide(new BigDecimal(y));
  }

  public boolean isTimeOut(boolean isTimeOut) {
    if (isTimeOut) {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return isTimeOut;
  }
}
