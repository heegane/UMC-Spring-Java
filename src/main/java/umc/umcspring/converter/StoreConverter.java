package umc.umcspring.converter;

import umc.umcspring.domain.Store;
import umc.umcspring.domain.StoreType;
import umc.umcspring.web.dto.StoreRequestDTO;
import umc.umcspring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.AddResultDto toAddResultDTO(Store store) {
        return StoreResponseDTO.AddResultDto.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddDto request, StoreType storeType) {
        return Store.builder()
                .name(request.getName())
                .address(request.getRoadAddress() + " " + request.getDetailAddress())
                .storeType(storeType)
                .build();
    }
}
