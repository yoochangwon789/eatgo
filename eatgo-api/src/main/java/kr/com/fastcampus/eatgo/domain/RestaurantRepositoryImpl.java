package kr.com.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepositoryImpl {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepositoryImpl() {
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .get();
    }
}
