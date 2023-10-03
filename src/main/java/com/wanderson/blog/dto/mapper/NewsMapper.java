package com.wanderson.blog.dto.mapper;

import org.springframework.stereotype.Component;

import com.wanderson.blog.dto.NewsDTO;
import com.wanderson.blog.model.News;

@Component
public class NewsMapper {
    public NewsDTO toDTO(News news){
        if(news == null) return null;
        return new NewsDTO(news.getId(), news.getTitle(), news.getText(), news.getCategory().getId());
    }

    public News toEntity(NewsDTO newsDTO){
        if(newsDTO == null) return null;
        News news = new News();
        if(newsDTO.id() != null) news.setId(newsDTO.id());
        news.setTitle(newsDTO.title());
        news.setText(newsDTO.text());
        return news;
    }
}
