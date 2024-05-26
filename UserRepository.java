package Testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Testing.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByEmail(String email);

}
