package com.wanderson.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wanderson.blog.model.News;
import com.wanderson.blog.repository.NewsRepository;

@Service
public class NewsService {
    
    
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }

    public List<News> list(){
        return newsRepository.findAll();
    }

    public News findById(Long id){
        return newsRepository.findById(id).orElseThrow();
    }
}
