package com.wanderson.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wanderson.blog.model.Category;
import com.wanderson.blog.service.CategoryService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Valid
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> list() {
        return categoryService.list();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable @NotNull @Positive Long id){
        return categoryService.findById(id);
    } 

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category create(@RequestBody @Valid Category category){
        return categoryService.create(category);
    }
}
