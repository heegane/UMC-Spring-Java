package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission,Integer> {
}
