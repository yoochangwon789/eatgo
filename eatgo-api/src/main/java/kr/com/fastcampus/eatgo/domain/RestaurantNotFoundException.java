package kr.com.fastcampus.eatgo.domain;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(Long id) {
        super("Could Not find restaurant" + id);
    }
}
