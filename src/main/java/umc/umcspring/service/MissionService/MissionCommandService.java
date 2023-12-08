package umc.umcspring.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.mapping.MissionProgress;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(Integer storeId, MissionRequestDTO.AddDto request);

    MissionProgress progressMission(Integer userId, Integer missionId);

    boolean isMissionExists(Integer missionId);

    Page<Mission> getMissionListByStore(Integer storeId, Integer page);

    Page<MissionProgress> getMissionListByUserAndStatus(Integer userId, Integer page);
}
