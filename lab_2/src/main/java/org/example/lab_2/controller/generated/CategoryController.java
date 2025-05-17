package org.example.lab_2.controller.generated;

import org.example.lab_2.domain.entity.Category;
import org.example.lab_2.model.rest.controller.api.CategoryInfoApi;
import org.example.lab_2.model.rest.model.CategoryInfo;
import org.springframework.http.ResponseEntity;
import org.example.lab_2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CategoryController implements CategoryInfoApi {

    @Autowired
    private  CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<CategoryInfo> apiV1CategoryIdCategoryInfoGet(Long categoryId) {
       Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        CategoryInfo categoryInfo = new CategoryInfo();
       if (categoryOptional.isPresent()) {
           Category category = categoryOptional.get();
           categoryInfo.setCategoryId(category.getId());
           categoryInfo.setName(category.getName());
       }
       return ResponseEntity.ok(categoryInfo);
    }
}
