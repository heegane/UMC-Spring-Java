package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.mapping.Review;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
