package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.CategoryService;
import kr.com.fastcampus.eatgo.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> list() {
        List<Category> category = categoryService.getCategories();

        return category;
    }
}
