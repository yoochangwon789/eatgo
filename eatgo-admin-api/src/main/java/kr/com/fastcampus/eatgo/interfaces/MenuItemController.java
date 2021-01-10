package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.MenuItemService;
import kr.com.fastcampus.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/restaurants/{restaurantId}/menuitems")
    public List<MenuItem> list(@PathVariable Long restaurantId) {
        List<MenuItem> menuItems = menuItemService.getMenuItems(restaurantId);

        return menuItems;
    }

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(@PathVariable Long restaurantId, @RequestBody List<MenuItem> menuItems) {
        menuItemService.bulkUpdate(restaurantId, menuItems);

        return "";
    }
}
