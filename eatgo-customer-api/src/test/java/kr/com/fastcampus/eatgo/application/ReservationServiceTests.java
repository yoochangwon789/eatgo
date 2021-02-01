package kr.com.fastcampus.eatgo.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTests {

    @Test
    public void addReservation() {
        reservationServcice.addReservation(restaurantsId, userId, name, date, time, partySize);
    }
}