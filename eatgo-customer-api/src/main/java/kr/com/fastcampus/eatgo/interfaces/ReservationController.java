package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationServcie;

    @PostMapping("/restaurants/{restaurantsId}/reservations")
    public ResponseEntity<?> create(@PathVariable Long restaurantsId) throws URISyntaxException {
        Long userId = 1L;
        String name = "Tester";
        String date = "2019-12-25";
        String time = "20:00";
        Integer partySize = 20;

        reservationServcie.addReservation(restaurantsId, userId, name, date, time, partySize);

        String url = "/restaurants/"+ restaurantsId +"/reservations/1";

        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
