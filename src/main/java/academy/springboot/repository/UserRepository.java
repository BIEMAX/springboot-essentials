package academy.springboot.repository;

import academy.springboot.domain.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("{ 'user': ?0, 'password': ?1 }")
    List<User> findByUserAndPassword(String user, String password);
}
