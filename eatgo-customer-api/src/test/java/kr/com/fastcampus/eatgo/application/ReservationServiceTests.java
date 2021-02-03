package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Reservation;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTests {

    @Test
    public void addReservation() {
        reservationService.addReservation(restaurantsId, userId, name, date, time, partySize);
    }
}