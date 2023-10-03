package com.wanderson.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wanderson.blog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
