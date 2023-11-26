package umc.umcspring.converter;

import umc.umcspring.domain.Mission;
import umc.umcspring.domain.User;
import umc.umcspring.domain.mapping.MissionProgress;
import umc.umcspring.web.dto.MissionProgressResponseDTO;

import java.time.LocalDateTime;

public class MissionProgressConverter {

    public static MissionProgressResponseDTO.AddResultDto toProgressResultDTO(MissionProgress missionProgress) {
        return MissionProgressResponseDTO.AddResultDto.builder()
                .missionProgressId(missionProgress.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MissionProgress toMissionProgress(User user, Mission mission) {
        return MissionProgress.builder()
                .mission(mission)
                .user(user)
                .build();
    }

}
