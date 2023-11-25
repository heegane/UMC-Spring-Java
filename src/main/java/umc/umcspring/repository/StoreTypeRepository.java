package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.StoreType;

public interface StoreTypeRepository extends JpaRepository<StoreType,Integer> {
}
