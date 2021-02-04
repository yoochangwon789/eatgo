package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.ReservationService;
import kr.com.fastcampus.eatgo.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> list() {
        Long restaurantId = 1004L;
        List<Reservation> reservations = reservationService.getReservations(restaurantId);

        return reservations;
    }
}
