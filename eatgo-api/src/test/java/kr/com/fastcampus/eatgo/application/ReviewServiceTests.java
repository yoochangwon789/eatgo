package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Review;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTests {

    private ReviewService reviewService;

    public void setReviewServiceUp() {
        reviewService = new ReviewService();
    }

    @Test
    public void addReview() {
        Review review = Review.builder()
                .name("JOKER")
                .score(3)
                .description("Mat-it-da")
                .build();

        reviewService.addReview(review);
    }
}