package umc.umcspring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.BaseHandler;
import umc.umcspring.converter.MissionConverter;
import umc.umcspring.converter.MissionProgressConverter;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.Store;
import umc.umcspring.domain.User;
import umc.umcspring.domain.mapping.MissionProgress;
import umc.umcspring.repository.MissionProgressRepository;
import umc.umcspring.repository.MissionRepository;
import umc.umcspring.repository.StoreRepository;
import umc.umcspring.repository.UserRepository;
import umc.umcspring.web.dto.MissionRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final MissionProgressRepository missionProgressRepository;

    @Override
    @Transactional
    public Mission addMission(Integer storeId, MissionRequestDTO.AddDto request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new BaseHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(store,request);

        return missionRepository.save(mission);
    }

    @Override
    @Transactional
    public MissionProgress progressMission(Integer userId, Integer missionId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BaseHandler(ErrorStatus.USER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new BaseHandler(ErrorStatus.USER_NOT_FOUND));

        if(missionProgressRepository.findByMissionAndUser(mission,user).isPresent())
            throw new BaseHandler(ErrorStatus.DUPLICATED_MISSION);

        MissionProgress missionProgress = MissionProgressConverter.toMissionProgress(user,mission);

        return missionProgressRepository.save(missionProgress);
    }
}
