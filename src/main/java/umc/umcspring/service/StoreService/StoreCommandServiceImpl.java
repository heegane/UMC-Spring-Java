package umc.umcspring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.StoreTypeHandler;
import umc.umcspring.converter.StoreConverter;
import umc.umcspring.domain.Store;
import umc.umcspring.domain.StoreType;
import umc.umcspring.repository.StoreRepository;
import umc.umcspring.repository.StoreTypeRepository;
import umc.umcspring.web.dto.StoreRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final StoreTypeRepository storeTypeRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddDto request) {

        StoreType storeType = storeTypeRepository.findById(request.getStoreType())
                .orElseThrow(() -> new StoreTypeHandler(ErrorStatus.STORE_TYPE_NOT_FOUND));

        Store store = StoreConverter.toStore(request, storeType);

        return storeRepository.save(store);
    }

}
