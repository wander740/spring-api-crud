package com.wanderson.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wanderson.blog.model.News;

public interface NewsRepository extends JpaRepository<News, Long>{
    
}
