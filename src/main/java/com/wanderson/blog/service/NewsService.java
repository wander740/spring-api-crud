package com.wanderson.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wanderson.blog.dto.NewsDTO;
import com.wanderson.blog.dto.mapper.NewsMapper;
import com.wanderson.blog.exception.RecordNotFoundException;
import com.wanderson.blog.model.Category;
import com.wanderson.blog.model.News;
import com.wanderson.blog.repository.NewsRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Valid
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

    public List<NewsDTO> list() {
        return newsRepository.findAll()
            .stream()
            .map(newsMapper::toDTO)
            .toList();
    }

    public NewsDTO findById(@NotNull @Positive Long id) {
        return newsRepository.findById(id)
            .map(newsMapper::toDTO)
            .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public NewsDTO create(@Valid NewsDTO newsDTO) {
        Category category = categoryService.findById(newsDTO.category_id());
        News news = newsMapper.toEntity(newsDTO);
        news.setCategory(category);
        return newsMapper.toDTO(newsRepository.save(news));
    }

    public NewsDTO update(@NotNull @Positive Long id, @Valid NewsDTO newsDTO) {
        return newsRepository.findById(id)
            .map(recordFound -> {
                Category category = categoryService.findById(newsDTO.category_id());
                News news = newsMapper.toEntity(newsDTO);
                recordFound.setTitle(news.getTitle());
                recordFound.setText(news.getText());
                recordFound.setCategory(category);

                return newsMapper.toDTO(newsRepository.save(recordFound));
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id) {
        newsRepository.delete(newsRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
