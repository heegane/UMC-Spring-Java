package umc.umcspring.converter;

import umc.umcspring.domain.ReviewImage;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.web.dto.ReviewRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewImageConverter {

    public static List<ReviewImage> toReviewImageList(Review review, ReviewRequestDTO.AddDto request) {

        return request.getImgUrl().stream()
                .map(url -> {
                    return ReviewImage.builder()
                            .src(url)
                            .review(review)
                            .build();
                }).collect(Collectors.toList());
    }
}
