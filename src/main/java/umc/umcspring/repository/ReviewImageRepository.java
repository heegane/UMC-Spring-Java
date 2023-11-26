package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.ReviewImage;

public interface ReviewImageRepository extends JpaRepository<ReviewImage,Integer> {
}
