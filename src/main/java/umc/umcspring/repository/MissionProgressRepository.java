package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.User;
import umc.umcspring.domain.mapping.MissionProgress;

import java.util.Optional;

public interface MissionProgressRepository extends JpaRepository<MissionProgress,Integer> {
    Optional<MissionProgress> findByMissionAndUser(Mission mission, User user);
}
