package umc.umcspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.Store;

public interface MissionRepository extends JpaRepository<Mission,Integer> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
