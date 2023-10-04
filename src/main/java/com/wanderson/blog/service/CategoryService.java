package com.wanderson.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wanderson.blog.exception.RecordNotFoundException;
import com.wanderson.blog.model.Category;
import com.wanderson.blog.repository.CategoryRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Valid
@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> list() {
        return categoryRepository.findAll();
    }

    public Category findById(@NotNull @Positive Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Category create(@Valid Category category){
        return categoryRepository.save(category);
    }
}
