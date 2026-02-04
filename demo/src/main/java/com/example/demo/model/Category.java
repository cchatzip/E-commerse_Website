package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;

    protected Category() {
    }

    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Long getCategoryId() {
        return categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    
}
