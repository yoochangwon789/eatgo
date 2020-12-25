package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Restaurant;
import kr.com.fastcampus.eatgo.domain.RestaurantRepository;
import kr.com.fastcampus.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {

    private RestaurantService restaurantService;

    // 오토와이어드를 사용하게 되면 Spring 이 객체를 넣어주는데 Test 코드 에서는 의존관계를 주입이 불가능 하다
    // 그래서 우리가 직접 레포지토리를 연결을 할 수 있도록 명시적으로 주입을 시켜줘야 함 @Before 사용
    @Before
    public void setUp() {
        RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository);
    }


    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId(), is(1004L));
    }
}