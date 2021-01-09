package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.application.ReviewService;
import kr.com.fastcampus.eatgo.domain.Review;
import kr.com.fastcampus.eatgo.domain.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ReviewServiceTests {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    public void setReviewServiceUp() {
        MockitoAnnotations.initMocks(this);

        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    public void addReview() {
        setReviewServiceUp();

        Review review = Review.builder()
                .name("JOKER")
                .score(3)
                .description("Mat-it-da")
                .build();

        reviewService.addReview(1004L, review);

        verify(reviewRepository).save(any());
    }
}