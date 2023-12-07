package umc.umcspring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.BaseHandler;
import umc.umcspring.converter.ReviewConverter;
import umc.umcspring.converter.ReviewImageConverter;
import umc.umcspring.domain.ReviewImage;
import umc.umcspring.domain.Store;
import umc.umcspring.domain.User;
import umc.umcspring.domain.mapping.Review;
import umc.umcspring.repository.ReviewImageRepository;
import umc.umcspring.repository.ReviewRepository;
import umc.umcspring.repository.StoreRepository;
import umc.umcspring.repository.UserRepository;
import umc.umcspring.web.dto.ReviewRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ReviewImageRepository reviewImageRepository;

    @Override
    @Transactional
    public Review addReview(Integer userId, Integer storeId, ReviewRequestDTO.AddDto request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BaseHandler(ErrorStatus.USER_NOT_FOUND));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new BaseHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toReview(user,store,request);

        reviewRepository.save(review);

        List<ReviewImage> reviewImages =ReviewImageConverter.toReviewImageList(review, request);

        reviewImageRepository.saveAll(reviewImages);

        return review;
    }

    @Override
    public Page<Review> getReviewListByStore(Integer storeId, Integer page) {

        Store store = storeRepository.findById(storeId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Review> getReviewListByUser(Integer userId, Integer page) {

        User user = userRepository.findById(userId).get();

        Page<Review> userPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return  userPage;
    }
}
