package umc.umcspring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umcspring.apiPayload.ApiResponse;
import umc.umcspring.converter.ReviewConverter;
import umc.umcspring.converter.StoreConverter;
import umc.umcspring.domain.Store;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.service.ReviewService.ReviewCommandService;
import umc.umcspring.service.StoreOperatingHoursService.StoreOperatingHoursCommandService;
import umc.umcspring.service.StoreService.StoreCommandService;
import umc.umcspring.web.dto.ReviewRequestDTO;
import umc.umcspring.web.dto.ReviewResponseDTO;
import umc.umcspring.web.dto.StoreRequestDTO;
import umc.umcspring.web.dto.StoreResponseDTO;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreOperatingHoursCommandService storeOperatingHoursCommandService;
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.AddResultDto> add(@RequestBody @Valid StoreRequestDTO.AddDto request) {
        Store store = storeCommandService.addStore(request);
        storeOperatingHoursCommandService.addStoreOperatingHours(store.getId(), request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.AddResultDto> addReview(@PathVariable("storeId") Integer storeId,
                                                                 @RequestBody @Valid ReviewRequestDTO.AddDto request,
                                                                 @RequestHeader(value = "userId") Integer userId) {
        Review review = reviewCommandService.addReview(userId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }

}
