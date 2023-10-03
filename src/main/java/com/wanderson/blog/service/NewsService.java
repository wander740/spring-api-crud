package com.wanderson.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wanderson.blog.dto.NewsDTO;
import com.wanderson.blog.dto.mapper.NewsMapper;
import com.wanderson.blog.repository.NewsRepository;

@Service
public class NewsService {
    
    
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public NewsService(NewsRepository newsRepository, NewsMapper newsMapper){
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    public List<NewsDTO> list(){
        return newsRepository.findAll()
            .stream()
            .map(newsMapper::toDTO)
            .toList();
    }

    public NewsDTO findById(Long id){
        return newsRepository.findById(id)
            .map(newsMapper::toDTO)
            .orElseThrow();
    }
}
