package umc.umcspring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.StoreTypeHandler;
import umc.umcspring.converter.MissionConverter;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.Store;
import umc.umcspring.repository.MissionRepository;
import umc.umcspring.repository.StoreRepository;
import umc.umcspring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission addMission(Integer storeId, MissionRequestDTO.AddDto request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreTypeHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(store,request);

        return missionRepository.save(mission);
    }
}
