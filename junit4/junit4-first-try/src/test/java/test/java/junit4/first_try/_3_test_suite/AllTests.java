package test.java.junit4.first_try._3_test_suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import test.java.junit4.first_try._1_test.MyClassTest;

/** Example for test suite */
@RunWith(Suite.class)
@SuiteClasses({MyClassTest.class, MySecondClassTest.class})
public class AllTests {}
