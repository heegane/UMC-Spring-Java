package umc.umcspring.service.MissionService;

import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.mapping.MissionProgress;
import umc.umcspring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(Integer storeId, MissionRequestDTO.AddDto request);

    MissionProgress progressMission(Integer userId, Integer missionId);

    boolean isMissionExists(Integer missionId);
}
