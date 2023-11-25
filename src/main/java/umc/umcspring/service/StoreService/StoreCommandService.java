package umc.umcspring.service.StoreService;

import umc.umcspring.domain.Store;
import umc.umcspring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO.AddDto request);
}
