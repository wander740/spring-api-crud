package com.wanderson.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanderson.blog.dto.NewsDTO;
import com.wanderson.blog.service.NewsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/news")
public class NewsController {
    
    private final NewsService newsService;

    public NewsController(NewsService newsService){
        this.newsService = newsService;
    }

    @GetMapping
    public List<NewsDTO> list(){
        return newsService.list();
    }

    @GetMapping("/{id}")
    public NewsDTO findById(@PathVariable Long id){
        return newsService.findById(id);
    }

    @PostMapping
    public NewsDTO create(@RequestBody NewsDTO newsDTO) {
        return newsService.create(newsDTO);
    }
    
    @PutMapping("/{id}")
    public NewsDTO update(@PathVariable Long id, @RequestBody NewsDTO newsDTO){
        return newsService.update(id, newsDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        newsService.delete(id);
    }
}
