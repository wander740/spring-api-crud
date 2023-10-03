package com.wanderson.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanderson.blog.model.News;
import com.wanderson.blog.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    
    private final NewsService newsService;

    public NewsController(NewsService newsService){
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> list(){
        return newsService.list();
    }

    @GetMapping("/{id}")
    public News findById(@PathVariable Long id){
        return newsService.findById(id);
    }

}
