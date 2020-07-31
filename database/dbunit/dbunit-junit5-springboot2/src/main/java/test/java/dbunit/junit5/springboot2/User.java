package test.java.dbunit.junit5.springboot2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "dbunit_users")
public class User {

  public User() {}

  public User(Long id) {
    this.id = id;
  }

  public User(String email, String name) {
    this.email = email;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull private String email;

  @NotNull private String name;
}
