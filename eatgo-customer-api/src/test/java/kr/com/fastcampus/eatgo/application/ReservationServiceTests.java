package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Reservation;
import kr.com.fastcampus.eatgo.domain.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;

class ReservationServiceTests {

    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    public void setReservationServiceUp() {
        MockitoAnnotations.initMocks(this);

        reservationService = new ReservationService();
    }

    @Test
    public void addReservation() {
        setReservationServiceUp();

        Long restaurantsId = 369L;
        Long userId = 1004L;
        String name = "John";
        String date = "2019-12-25";
        String time = "20:00";
        Integer partySize = 20;

        Reservation reservation = reservationService.addReservation(restaurantsId, userId, name, date, time, partySize);

        assertThat(reservation.getName(), is(name));

        verify(reservationRepository).save(any(Reservation.class));
    }
}