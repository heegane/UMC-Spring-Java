package umc.umcspring.converter;

import org.springframework.data.domain.Page;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.Store;
import umc.umcspring.domain.StoreType;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.web.dto.ReviewRequestDTO;
import umc.umcspring.web.dto.StoreRequestDTO;
import umc.umcspring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .nickName(review.getUser().getNickname())
                .score(review.getScore())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .point(mission.getPoint())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .storeName(mission.getStore().getName())
                .build();
    }
    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){

        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(StoreConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
