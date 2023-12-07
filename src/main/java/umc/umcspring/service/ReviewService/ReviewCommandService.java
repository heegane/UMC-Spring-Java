package umc.umcspring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review addReview(Integer userId, Integer storeId, ReviewRequestDTO.AddDto request);

    Page<Review> getReviewList(Integer storeId, Integer page);
}
