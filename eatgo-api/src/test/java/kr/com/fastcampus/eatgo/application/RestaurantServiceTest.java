package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private MenuItemRepository menuItemRepository;

    //@Before
    //public void setUp() {
        //restaurantRepository = new RestaurantRepositoryImpl();
        //restaurantService = new RestaurantService(restaurantRepository);
    //}

    private void mockRestaurantRepository() {
        // Mock 가짜 객체를 사용하기 위해 값을 넣어주고 잡아주는 기능을 하는 명시
        MockitoAnnotations.initMocks(this);

        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);

        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        restaurants.add(restaurant);
        given(restaurantRepository.findAll()).willReturn(restaurants);
    }

    private void mockMenuItemRepository() {
        MockitoAnnotations.initMocks(this);

        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);

        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        restaurant.addMenuItem(new MenuItem("Kimchi"));
        given(restaurantRepository.findById(1004L)).willReturn(restaurant);
    }

    @Test
    public void getRestaurants() {
        //restaurantRepository = new RestaurantRepositoryImpl();
        //restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);

        mockRestaurantRepository();

        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId(), is(1004L));
    }

    @Test
    public void getRestaurant() {
        //restaurantRepository = new RestaurantRepositoryImpl();
        //menuItemRepository = new MenuItemRepositoryImpl();
        //restaurantService = new RestaurantService(restaurantRepository,menuItemRepository);

        mockMenuItemRepository();

        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertThat(restaurant.getId(), is(1004L));

        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(menuItem.getName(), is("Kimchi"));
    }
}