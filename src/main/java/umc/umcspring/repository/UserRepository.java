package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
