package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.MenuItem;
import kr.com.fastcampus.eatgo.domain.MenuItemRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MenuItemServiceTests {

    private MenuItemService menuItemService;

    @Mock
    private MenuItemRepository menuItemRepository;

    private void setMenuItemRepositoryUp() {
        MockitoAnnotations.initMocks(this);

        menuItemService = new MenuItemService(menuItemRepository);
    }

    @Test
    public void bulkUpdate() {
        setMenuItemRepositoryUp();

        List<MenuItem> menuItems = new ArrayList<>();

        //create
        menuItems.add(MenuItem.builder()
                .name("Kimchi")
                .build());
        // update
        menuItems.add(MenuItem.builder()
                .id(12L)
                .name("Gukbob")
                .build());
        // delete
        menuItems.add(MenuItem.builder()
                .id(1004L)
                .destroy(true)
                .name("Gukbob")
                .build());

        menuItemService.bulkUpdate(1L, menuItems);

        verify(menuItemRepository, times(2)).save(any());
        verify(menuItemRepository, times(1)).deleteById(eq(1004L));
    }
}