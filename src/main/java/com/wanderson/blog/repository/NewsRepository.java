package com.wanderson.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wanderson.blog.model.News;

public interface NewsRepository extends JpaRepository<News, Long>{

    @Query("SELECT ne.id, ne.title, ne.text FROM Category AS ca, News AS ne WHERE ca.id = ne.category.id AND (ca.title LIKE %:title% OR ne.title LIKE %:title%)")
    List<News> findByTitleContaining(@Param("title") String title);
}
