package test.java.dbunit.junit5.springboot2;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

  User findByEmail(String email);
}
