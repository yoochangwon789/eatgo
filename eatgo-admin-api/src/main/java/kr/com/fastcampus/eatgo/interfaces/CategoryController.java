package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.CategoryService;
import kr.com.fastcampus.eatgo.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping("/categories")
    public ResponseEntity<?> create(@RequestBody Category resource) throws URISyntaxException {
        String name = resource.getName();

        Category category = categoryService.addCategory(name);

        String url = "/categories/" + category.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
