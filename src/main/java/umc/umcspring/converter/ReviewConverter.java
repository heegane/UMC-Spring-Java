package umc.umcspring.converter;

import umc.umcspring.domain.Store;
import umc.umcspring.domain.User;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.web.dto.ReviewRequestDTO;
import umc.umcspring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.AddResultDto toAddResultDTO(Review review) {
        return ReviewResponseDTO.AddResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(User user, Store store, ReviewRequestDTO.AddDto request) {
        return Review.builder()
                .score(request.getScore())
                .content(request.getContent())
                .user(user)
                .store(store)
                .build();
    }
}
