package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.Store;

public interface StoreRepository extends JpaRepository<Store,Integer> {
}
