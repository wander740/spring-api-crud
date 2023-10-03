package com.wanderson.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wanderson.blog.dto.NewsDTO;
import com.wanderson.blog.dto.mapper.NewsMapper;
import com.wanderson.blog.model.Category;
import com.wanderson.blog.model.News;
import com.wanderson.blog.repository.NewsRepository;

@Service
public class NewsService {
    
    
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;
    private final CategoryService categoryService;

    public NewsService(NewsRepository newsRepository, NewsMapper newsMapper, CategoryService categoryService){
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
        this.categoryService = categoryService;
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

    public NewsDTO create(NewsDTO newsDTO){
        Category category = categoryService.findById(newsDTO.category_id());
        News news = newsMapper.toEntity(newsDTO);
        news.setCategory(category);
        return newsMapper.toDTO(newsRepository.save(news));
    }

    public NewsDTO update(Long id, NewsDTO newsDTO){
        return newsRepository.findById(id)
            .map(recordFound -> {
                Category category = categoryService.findById(newsDTO.category_id());
                News news = newsMapper.toEntity(newsDTO);
                recordFound.setTitle(news.getTitle());
                recordFound.setText(news.getText());
                recordFound.setCategory(category);

                return newsMapper.toDTO(newsRepository.save(recordFound));
            }).orElseThrow();
    }

    public void delete(Long id){
        newsRepository.delete(newsRepository.findById(id)
            .orElseThrow());
    }
}
