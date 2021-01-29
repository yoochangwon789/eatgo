package kr.com.fastcampus.eatgo.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReservationController {

    @PostMapping("/restaurants/{restaurantsId}/reservations")
    public ResponseEntity<?> create() throws URISyntaxException {
        String url = "/restaurants/1004/reservations/1";

        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
