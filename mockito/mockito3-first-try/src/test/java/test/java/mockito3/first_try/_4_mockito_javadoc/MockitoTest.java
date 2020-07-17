package test.java.mockito3.first_try._4_mockito_javadoc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MockitoTest {

  @Test
  public void _1_verify_some_behaviour() {
    // mock creation
    List<String> mockedList = mock(List.class);

    // using mock object
    mockedList.add("one");
    mockedList.clear();

    // verification
    verify(mockedList).add("one");
    verify(mockedList).clear();
  }

  @Test
  public void _2_how_about_some_stubbing() {
    // You can mock concrete classes, not just interfaces
    LinkedList<String> mockedList = mock(LinkedList.class);

    // stubbing
    when(mockedList.get(0)).thenReturn("first");
    when(mockedList.get(1)).thenThrow(new RuntimeException());

    // following prints "first"
    System.out.println(mockedList.get(0));

    try {
      // following throws runtime exception
      System.out.println(mockedList.get(1));
    } catch (Exception e) {
      System.out.println(e.getClass());
    }

    // following prints "null" because get(999) was not stubbed
    System.out.println(mockedList.get(999));

    // Although it is possible to verify a stubbed invocation, usually <b>it's just redundant</b>
    // If your code cares what get(0) returns, then something else breaks (often even before
    // verify() gets executed).
    // If your code doesn't care what get(0) returns, then it should not be stubbed.
    verify(mockedList).get(0);
  }

  @Test
  public void _3_argument_matchers() {
    List<String> mockedList = mock(LinkedList.class);
    // stubbing using built-in anyInt() argument matcher
    when(mockedList.get(anyInt())).thenReturn("element");

    // stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
    // when(mockedList.contains(argThat(isValid()))).thenReturn(true);
    when(mockedList.contains(argThat("element"::equalsIgnoreCase))).thenReturn(true);
    System.out.println(mockedList.contains("element"));

    // following prints "element"
    System.out.println(mockedList.get(999));
    // <b>you can also verify using an argument matcher</b>
    verify(mockedList).get(anyInt());

    // <b>argument matchers can also be written as Java 8 Lambdas</b>
    when(mockedList.add("10000000")).thenReturn(true);
    mockedList.add("10000000");
    verify(mockedList).add(argThat(someString -> someString.length() > 5));
  }

  @Test
  public void _4_verifying_exact_number_of_invocations() {
    List<String> mockedList = mock(LinkedList.class);

    // using mock
    mockedList.add("once");

    mockedList.add("twice");
    mockedList.add("twice");

    mockedList.add("three times");
    mockedList.add("three times");
    mockedList.add("three times");

    // following two verifications work exactly the same - times(1) is used by default
    verify(mockedList).add("once");
    verify(mockedList, times(1)).add("once");

    // exact number of invocations verification
    verify(mockedList, times(2)).add("twice");
    verify(mockedList, times(3)).add("three times");

    // verification using never(). never() is an alias to times(0)
    verify(mockedList, never()).add("never happened");

    // verification using atLeast()/atMost()
    verify(mockedList, atMostOnce()).add("once");
    verify(mockedList, atLeastOnce()).add("three times");
    verify(mockedList, atLeast(2)).add("three times");
    verify(mockedList, atMost(5)).add("three times");
  }

  @Test
  public void _40_stricter_mockito() {
    // Strict stubbing with JUnit Rules - {@link MockitoRule#strictness(Strictness)} with {@link
    // Strictness#STRICT_STUBS}
    // Strict stubbing with JUnit Runner - {@link MockitoJUnitRunner.StrictStubs}
    // Strict stubbing if you cannot use runner/rule (like TestNG) - {@link MockitoSession}
    // Unnecessary stubbing detection with {@link MockitoJUnitRunner}
    // Stubbing argument mismatch warnings, documented in {@link MockitoHint}
  }

  @Test
  public void _41_advanced_framework_integrations() {
    // https://www.linkedin.com/pulse/mockito-vs-powermock-opinionated-dogmatic-static-mocking-faber
    // https://github.com/mockito/mockito/issues/1110
  }

  @Test
  public void _42_VerificationStartedListener() {}

  @Test
  public void _43_MockitoSession() {}

  @Test
  public void _44_InstantiatorProvider2() {
    // replace InstantiatorProvider as it was leaking internal API
  }

  public void _45_junit5_extension() {
    // org.mockito:mockito-junit-jupiter
  }

  @Test
  public void _46_lenient() {
    Foo mock = mock(Foo.class);
    //  Strict stubbing feature is available since early Mockito 2.
    lenient().when(mock.foo()).thenReturn("ok");
    // for the given mock
    Foo mock2 = mock(Foo.class, withSettings().lenient());
    mock2.foo();
  }

  @Test
  public void _47_clearing_mock_state_in_inline_mocking() {
    // MockitoFramework.clearInlineMocks()
    // 只针对inline mocking, 有极少情况会有memory leaks.
    // 该API是显式清除mock state (only make sense in inline mocking!)
    // @After // normally put to here
    // public void clearMocks() {
    Mockito.framework().clearInlineMocks();
    // }
  }

  @Test
  public void _48_mocking_static_methods() {
    assertEquals("foo", Foo.method());
    // To make sure a static mock remains temporary,
    // it is recommended to define the scope within a try-with-resources construct.
    try (MockedStatic<Foo> mocked = mockStatic(Foo.class)) {
      mocked.when(Foo::method).thenReturn("bar");
      assertEquals("bar", Foo.method());
      mocked.verify(Foo::method);
    }
    assertEquals("foo", Foo.method());
    Mockito.framework().clearInlineMocks(); // example for 47
  }
}
