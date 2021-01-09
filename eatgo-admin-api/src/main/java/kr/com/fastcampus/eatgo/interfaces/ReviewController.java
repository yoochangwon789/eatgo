package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.ReviewService;
import kr.com.fastcampus.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getReviews() {
        List<Review> reviews = reviewService.getReviews();

        return reviews;
    }
}
