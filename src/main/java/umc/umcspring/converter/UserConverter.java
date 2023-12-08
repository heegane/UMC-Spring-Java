package umc.umcspring.converter;

import org.springframework.data.domain.Page;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.enums.MissionStatus;
import umc.umcspring.domain.mapping.MissionProgress;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.web.dto.UserResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return UserResponseDTO.ReviewPreViewDTO.builder()
                .nickName(review.getUser().getNickname())
                .score(review.getScore())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }
    public static UserResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<UserResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(UserConverter::reviewPreViewDTO).collect(Collectors.toList());

        return UserResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static UserResponseDTO.MissionPreViewDTO missionPreViewDTO(MissionProgress missionProgress){
        return UserResponseDTO.MissionPreViewDTO.builder()
                .point(missionProgress.getMission().getPoint())
                .content(missionProgress.getMission().getContent())
                .storeName(missionProgress.getMission().getStore().getName())
                .missionStatus(missionProgress.getStatus().name())
                .build();
    }

    public static UserResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<MissionProgress> missionList){

        List<UserResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(UserConverter::missionPreViewDTO).collect(Collectors.toList());

        return UserResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
