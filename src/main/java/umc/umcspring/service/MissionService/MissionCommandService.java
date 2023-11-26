package umc.umcspring.service.MissionService;

import umc.umcspring.domain.Mission;
import umc.umcspring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(Integer storeId, MissionRequestDTO.AddDto request);
}
