package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
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
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();
        restaurants.add(restaurant);

        given(restaurantRepository.findAll()).willReturn(restaurants);
    }

    private void mockMenuItemRepository() {
        MockitoAnnotations.initMocks(this);

        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);

        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();
        //restaurant.setMenuItem(Arrays.asList(new MenuItem("Kimchi")));

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(MenuItem.builder()
                .name("Kimchi")
                .build());

        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));
        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
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
    public void getRestaurantWithExisted() {
        //restaurantRepository = new RestaurantRepositoryImpl();
        //menuItemRepository = new MenuItemRepositoryImpl();
        //restaurantService = new RestaurantService(restaurantRepository,menuItemRepository);

        mockMenuItemRepository();

        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("Bob zip"));

        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(menuItem.getName(), is("Kimchi"));
    }

    @Test
    public void getRestaurantWithNotExisted() {
       restaurantService.getRestaurant(404L);
    }

    @Test
    public void addRestaurant() {
        MockitoAnnotations.initMocks(this);
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);

        given(restaurantRepository.save(any())).will(invocation -> {
            Restaurant restaurant = invocation.getArgument(0);
            restaurant.setId(1234L);
            return restaurant;
        });

        Restaurant restaurant = Restaurant.builder()
                .name("BeRyong")
                .address("Busan")
                .build();

        Restaurant created = restaurantService.addRestaurant(restaurant);

        assertThat(created.getId(), is(1234L));
    }

    @Test
    public void updateRestaurant() {
        MockitoAnnotations.initMocks(this);
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);

        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();
        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));

        restaurantService.updateRestaurant(1004L, "Sool zip", "Busan");

        assertThat(restaurant.getName(), is("Sool zip"));
        assertThat(restaurant.getAddress(), is("Busan"));
    }
}