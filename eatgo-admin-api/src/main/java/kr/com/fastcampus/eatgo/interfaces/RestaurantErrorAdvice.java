package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.domain.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// 예외를 처리하기 위한 강력한 어노텐션
@ControllerAdvice
public class RestaurantErrorAdvice {

    // Exception 을 처리하기 위한 Handle
    @ExceptionHandler(RestaurantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleNotFount() {
        return "{}";
    }
}
