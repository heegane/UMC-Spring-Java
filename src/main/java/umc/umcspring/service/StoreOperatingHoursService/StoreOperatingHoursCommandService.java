package umc.umcspring.service.StoreOperatingHoursService;

import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.domain.StoreOperatingHours;
import umc.umcspring.web.dto.StoreRequestDTO;

import java.util.List;

public interface StoreOperatingHoursCommandService {
    @Transactional
    List<StoreOperatingHours> addStoreOperatingHours(Integer storeId, StoreRequestDTO.AddDto request);
}
