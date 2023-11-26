package umc.umcspring.service.StoreOperatingHoursService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.BaseHandler;
import umc.umcspring.converter.StoreOperatingHoursConverter;
import umc.umcspring.domain.Store;
import umc.umcspring.domain.StoreOperatingHours;
import umc.umcspring.repository.StoreOperatingHoursRepository;
import umc.umcspring.repository.StoreRepository;
import umc.umcspring.web.dto.StoreRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreOperatingHoursCommandServiceImpl implements StoreOperatingHoursCommandService {

    private final StoreRepository storeRepository;
    private final StoreOperatingHoursRepository storeOperatingHoursRepository;

    @Override
    @Transactional
    public List<StoreOperatingHours> addStoreOperatingHours(Integer storeId, StoreRequestDTO.AddDto request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new BaseHandler(ErrorStatus.STORE_NOT_FOUND));

        List<StoreOperatingHours> storeOperatingHoursList = StoreOperatingHoursConverter.toStoreOperatingHoursList(store,request);

        storeOperatingHoursRepository.saveAll(storeOperatingHoursList);

        return storeOperatingHoursList;
    }
}
