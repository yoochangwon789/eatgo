package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Reservation;
import kr.com.fastcampus.eatgo.domain.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Long restaurantsId, Long userId, String name,
                                      String date, String time, Integer partySize) {

        Reservation reservation = Reservation.builder()
                .restaurantId(restaurantsId)
                .userId(userId)
                .name(name)
                .date(date)
                .time(time)
                .partySize(partySize)
                .build();

        return reservationRepository.save(reservation);
    }
}
