package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
class ReservationControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    public void create() throws Exception {
        mvc.perform(post("/restaurants/1004/reservations"))
                .andExpect(status().isCreated());

        Long userId = 1L;
        String name = "Tester";
        String date = "2019-12-25";
        String time = "20:00";
        Integer partySize = 20;

        verify(reservationService).addReservation(userId, name, date, time, partySize);
    }
}