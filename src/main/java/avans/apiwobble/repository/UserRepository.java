package avans.apiwobble.repository;

import avans.apiwobble.domain.Car;
import avans.apiwobble.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserById(String id);
    List<User> findUserByUserNameIgnoringCase(String userName);
    List<User> findUserByUserMailIgnoringCase(String userName);
}
