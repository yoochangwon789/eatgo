package kr.com.fastcampus.eatgo.interfaces;

import io.jsonwebtoken.Claims;
import kr.com.fastcampus.eatgo.application.ReservationService;
import kr.com.fastcampus.eatgo.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public String list() {
        return null;
    }
}
