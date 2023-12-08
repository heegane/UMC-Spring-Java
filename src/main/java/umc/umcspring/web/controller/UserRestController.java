package umc.umcspring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.umcspring.apiPayload.ApiResponse;
import umc.umcspring.converter.UserConverter;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.mapping.MissionProgress;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.service.MissionService.MissionCommandService;
import umc.umcspring.service.ReviewService.ReviewCommandService;
import umc.umcspring.validation.annotation.ExistUsers;
import umc.umcspring.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class UserRestController {

    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;

    @GetMapping("/{userId}/reviews")
    public ApiResponse<UserResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistUsers @PathVariable(name = "userId") Integer userId, @RequestParam(name = "page") Integer page) {

        Page<Review> reviewPage = reviewCommandService.getReviewListByUser(userId, page);
        return ApiResponse.onSuccess(UserConverter.reviewPreViewListDTO(reviewPage));
    }

    @GetMapping("/{userId}/missions")
    public ApiResponse<UserResponseDTO.MissionPreViewListDTO> getMissionList(@ExistUsers @PathVariable(name = "userId") Integer userId, @RequestParam(name = "page") Integer page) {

        Page<MissionProgress> missionPage = missionCommandService.getMissionListByUserAndStatus(userId, page);
        return ApiResponse.onSuccess(UserConverter.missionPreViewListDTO(missionPage));
    }
}
