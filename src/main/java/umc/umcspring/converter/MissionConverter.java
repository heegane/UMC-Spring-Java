package umc.umcspring.converter;

import umc.umcspring.domain.Mission;
import umc.umcspring.domain.Store;
import umc.umcspring.web.dto.MissionRequestDTO;
import umc.umcspring.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.AddResultDto toAddResultDTO(Mission mission) {
        return MissionResponseDTO.AddResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(Store store, MissionRequestDTO.AddDto request) {
        return Mission.builder()
                .point(request.getPoint())
                .content(request.getContent())
                .deadline(LocalDate.of(request.getDeadYear(),request.getDeadMonth(),request.getDeadDay()))
                .store(store)
                .build();

    }
}
