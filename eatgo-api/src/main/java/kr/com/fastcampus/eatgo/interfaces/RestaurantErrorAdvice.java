package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.domain.RestaurantNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외를 처리하기 위한 강력한 어노텐션
@ControllerAdvice
public class RestaurantErrorAdvice {

    @ExceptionHandler(RestaurantNotFoundException.class)
    public void handleNotFount() {

    }
}
