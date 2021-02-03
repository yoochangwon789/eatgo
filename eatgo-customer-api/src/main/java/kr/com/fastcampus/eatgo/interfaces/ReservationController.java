package kr.com.fastcampus.eatgo.interfaces;

import io.jsonwebtoken.Claims;
import kr.com.fastcampus.eatgo.application.ReservationService;
import kr.com.fastcampus.eatgo.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/restaurants/{restaurantsId}/reservations")
    public ResponseEntity<?> create(Authentication authentication,
                                    @PathVariable Long restaurantsId,
                                    @RequestBody Reservation resource) throws URISyntaxException {

        Claims claims = (Claims) authentication.getPrincipal();

        Long userId = claims.get("userId", Long.class);
        String name = claims.get("name", String.class);
        String date = resource.getDate();
        String time = resource.getTime();
        Integer partySize = resource.getPartySize();

        Reservation reservation = reservationService.addReservation(restaurantsId, userId, name, date, time, partySize);

        String url = "/restaurants/" + restaurantsId + "/reservations/" + reservation.getId();

        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
