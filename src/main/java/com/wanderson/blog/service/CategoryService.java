package com.wanderson.blog.service;

import org.springframework.stereotype.Service;

import com.wanderson.blog.model.Category;
import com.wanderson.blog.repository.CategoryRepository;

@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }
}
