package kr.com.fastcampus.eatgo.interfaces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void bulkUpdate() {
        mockMvc.preform();
    }
}