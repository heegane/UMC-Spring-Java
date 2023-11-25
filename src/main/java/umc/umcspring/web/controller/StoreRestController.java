package umc.umcspring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umcspring.apiPayload.ApiResponse;
import umc.umcspring.converter.StoreConverter;
import umc.umcspring.domain.Store;
import umc.umcspring.service.StoreOperatingHoursService.StoreOperatingHoursCommandService;
import umc.umcspring.service.StoreService.StoreCommandService;
import umc.umcspring.web.dto.StoreRequestDTO;
import umc.umcspring.web.dto.StoreResponseDTO;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreOperatingHoursCommandService storeOperatingHoursCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.AddResultDto> add(@RequestBody @Valid StoreRequestDTO.AddDto request) {
        Store store = storeCommandService.addStore(request);
        storeOperatingHoursCommandService.addStoreOperatingHours(store.getId(), request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }
}
