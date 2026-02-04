package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Category;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    // let JPA generate IDs

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public String createCategory(Category category) {
        // ensure we don't accidentally try to save an entity with a client-supplied id
        category.setCategoryId(null);
        Category saved = categoryRepository.save(category);
        return "Category created successfully (id=" + saved.getCategoryId() + ")";
    }
    
    @Override
    public String deleteCategory(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }
        categoryRepository.deleteById(categoryId);
        return "Deleted category with categoryId: " + categoryId +  " successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return categoryRepository.save(existingCategory);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }
    }

}
