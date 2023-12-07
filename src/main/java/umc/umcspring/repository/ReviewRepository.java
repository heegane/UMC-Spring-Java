package umc.umcspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.Store;
import umc.umcspring.domain.User;
import umc.umcspring.domain.mapping.Review;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByUser(User user, PageRequest pageRequest);
}
