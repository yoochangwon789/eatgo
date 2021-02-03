package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

    public void addReservation(Long restaurantsId, Long userId, String name,
                                      String date, String time, Integer partySize) {
        //TODO : 구현 예정
    }
}
