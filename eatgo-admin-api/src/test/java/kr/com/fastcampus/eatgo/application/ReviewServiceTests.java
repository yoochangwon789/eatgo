package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Review;
import kr.com.fastcampus.eatgo.domain.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

class ReviewServiceTests {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    public void setReviewServiceUp() {
        MockitoAnnotations.initMocks(this);

        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    public void getReviews() {
        setReviewServiceUp();

        List<Review> mockReviews = new ArrayList<>();
        mockReviews.add(Review.builder().description("Cool!").build());

        given(reviewRepository.findAll()).willReturn(mockReviews);

        List<Review> reviews = mockReviews;

        Review review = reviews.get(0);

        assertThat(review.getDescription(), is("Cool!"));
    }
}