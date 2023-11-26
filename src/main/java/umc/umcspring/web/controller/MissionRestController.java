package umc.umcspring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umcspring.apiPayload.ApiResponse;
import umc.umcspring.converter.MissionProgressConverter;
import umc.umcspring.domain.mapping.MissionProgress;
import umc.umcspring.service.MissionService.MissionCommandService;
import umc.umcspring.web.dto.MissionProgressResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{missionId}")
    public ApiResponse<MissionProgressResponseDTO.AddResultDto> progress(@PathVariable("missionId") Integer missionId,
                                                                         @RequestHeader(value = "userId") Integer userId) {
        MissionProgress missionProgress = missionCommandService.progressMission(userId, missionId);
        return ApiResponse.onSuccess(MissionProgressConverter.toProgressResultDTO(missionProgress));
    }
}
