package test.java.mockito3.first_try._3_mockito_javadoc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.Test;

public class MockitoJavadocTest {

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
}
