package test.java.dbunit.junit5.springboot2;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DBRider
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DBUnitSpringBoot2Test {

  @Autowired UserRepository userRepository;

  @BeforeEach
  @DataSet("users.yml")
  public void setUpUsers() {
    // Every time will reset to 3 user records
  }

  @AfterAll
  @DataSet("users-empty.yml")
  public static void cleanUp() {}

  @Test
  @Order(1)
  public void given3Users_WhenFindByEmail_ThenReturn1User() {
    assertThat(userRepository).isNotNull();
    assertThat(userRepository.count()).isEqualTo(3);
    assertThat(userRepository.findByEmail("springboot@gmail.com").getId()).isEqualTo(3L);
  }

  @Test
  @Order(2)
  @ExpectedDataSet("users-expected.yml")
  public void given3Users_WhenDeleteUser_ThenRemain2Users() {
    assertThat(userRepository).isNotNull();
    assertThat(userRepository.count()).isEqualTo(3);
    userRepository.findById(2L).ifPresent(userRepository::delete);
    assertThat(userRepository.count()).isEqualTo(2); // assertion is made by @ExpectedDataset
  }

  @Test
  @Order(3)
  public void givenAfterDeleteTestCase_WhenCheckCount_ThenStill3Users() {
    assertThat(userRepository.count()).isEqualTo(3);
  }

  @Test
  @Order(4)
  @DataSet(cleanBefore = true) // as we didn't declared a dataset DBUnit wont clear the table
  @ExpectedDataSet("user.yml")
  public void givenCleanUserTable_WhenSaveUser_ThenInserted1User() {
    assertThat(userRepository).isNotNull();
    assertThat(userRepository.count()).isEqualTo(0);
    userRepository.save(new User("newUser@gmail.com", "new user"));
    assertThat(userRepository.count()).isEqualTo(1); // assertion is made by @ExpectedDataset
  }
}
