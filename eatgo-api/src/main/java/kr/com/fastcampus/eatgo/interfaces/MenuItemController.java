package kr.com.fastcampus.eatgo.interfaces;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuItemController {

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate() {
        return "";
    }
}
