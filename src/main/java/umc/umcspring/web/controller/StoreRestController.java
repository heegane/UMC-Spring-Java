package umc.umcspring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.umcspring.apiPayload.ApiResponse;
import umc.umcspring.converter.MissionConverter;
import umc.umcspring.converter.ReviewConverter;
import umc.umcspring.converter.StoreConverter;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.Store;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.service.MissionService.MissionCommandService;
import umc.umcspring.service.ReviewService.ReviewCommandService;
import umc.umcspring.service.StoreService.StoreCommandService;
import umc.umcspring.validation.annotation.ExistStores;
import umc.umcspring.validation.annotation.ExistUsers;
import umc.umcspring.web.dto.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.AddResultDto> add(@RequestBody @Valid StoreRequestDTO.AddDto request) {
        Store store = storeCommandService.addStore(request);
        storeCommandService.addStoreOperatingHours(store.getId(), request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.AddResultDto> addReview(@ExistStores @PathVariable("storeId") Integer storeId,
                                                                 @RequestBody @Valid ReviewRequestDTO.AddDto request,
                                                                 @ExistUsers @RequestHeader(value = "userId") Integer userId) {
        Review review = reviewCommandService.addReview(userId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.AddResultDto> addMission(@ExistStores @PathVariable("storeId") Integer storeId,
                                                                   @RequestBody @Valid MissionRequestDTO.AddDto request) {
        Mission mission = missionCommandService.addMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }

}
