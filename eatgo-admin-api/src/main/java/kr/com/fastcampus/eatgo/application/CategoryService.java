package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Category;
import kr.com.fastcampus.eatgo.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(String name) {
        Category category = Category.builder().name(name).build();

        categoryRepository.save(category);

        return category;
    }
}
