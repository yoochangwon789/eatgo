package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.RestaurantService;
import kr.com.fastcampus.eatgo.domain.MenuItem;
import kr.com.fastcampus.eatgo.domain.Restaurant;
import kr.com.fastcampus.eatgo.domain.RestaurantNotFoundException;
import kr.com.fastcampus.eatgo.domain.Review;
import kr.com.fastcampus.eatgo.interfaces.RestaurantController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class) // 요청을 위해서 springRunner 에게 요청
@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    // 까자 객체 투입
    @MockBean
    private RestaurantService restaurantService;

    // SpyBean 이라는 어노탠션을 test 코드에 의존성을 주입시켜준다.
    //@SpyBean(RestaurantService.class)
    //private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        // 우리가 given 을 통해 Service 를 실행한 후에 restaurants 의 값을 리턴 받을 것이다. 가짜 처리를 통해 test 코드를 적용시킨다
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(Restaurant.builder()
                .id(1004L)
                .name("JOKER House")
                .address("Seoul")
                .build());
        given(restaurantService.getRestaurants("Seoul")).willReturn(restaurants);

        mvc.perform(get("/restaurants?regions=Seoul"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"JOKER House\"")));
    }

    @Test
    public void detailWithExisted() throws Exception {
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("JOKER House")
                .address("Seoul")
                .build();
        restaurant.setMenuItem(Arrays.asList(MenuItem.builder()
                .name("Kimchi")
                .build()));
        Review review = Review.builder()
                .name("JOKER")
                .score(5)
                .description("Great!")
                .build();
        restaurant.setReviews(Arrays.asList(review));
        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant);

        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"JOKER House\"")))
                .andExpect(content().string(containsString("Kimchi")))
                .andExpect(content().string(containsString("Great!")));

    }

    @Test
    public void detailWithNotExisted() throws Exception {
        given(restaurantService.getRestaurant(404L)).willThrow(new RestaurantNotFoundException(404L));

        mvc.perform(get("/restaurants/404"))
                .andExpect(status(). isNotFound())
                .andExpect(content().string("{}"));
    }
}