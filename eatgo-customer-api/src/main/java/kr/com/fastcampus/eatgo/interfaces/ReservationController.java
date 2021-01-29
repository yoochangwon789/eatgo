package kr.com.fastcampus.eatgo.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReservationController {

    @PostMapping("/restaurants/{restaurantsId}/reservations")
    public ResponseEntity<?> create(@PathVariable Long restaurantsId) throws URISyntaxException {
        String url = "/restaurants/"+ restaurantsId +"/reservations/1";

        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
