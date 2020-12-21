package kr.com.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTests {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant();
        assertThat(restaurant.getName(), is("Bob zip"));
    }
}