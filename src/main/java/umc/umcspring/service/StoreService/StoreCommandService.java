package umc.umcspring.service.StoreService;

import umc.umcspring.domain.Store;
import umc.umcspring.domain.StoreOperatingHours;
import umc.umcspring.web.dto.StoreRequestDTO;

import java.util.List;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO.AddDto request);

    List<StoreOperatingHours> addStoreOperatingHours(Integer storeId, StoreRequestDTO.AddDto request);

    boolean isStoreExists(Integer storeId);

    boolean isStoreTypeExists(Integer storeTypeId);
}
