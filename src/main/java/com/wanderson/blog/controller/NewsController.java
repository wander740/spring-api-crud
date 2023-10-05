package com.wanderson.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wanderson.blog.dto.NewsDTO;
import com.wanderson.blog.service.NewsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<NewsDTO> list() {
        return newsService.list();
    }

    @GetMapping("/{id}")
    public NewsDTO findById(@PathVariable @NotNull @Positive Long id) {
        return newsService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public NewsDTO create(@RequestBody @Valid NewsDTO newsDTO) {
        return newsService.create(newsDTO);
    }
    
    @PutMapping("/{id}")
    public NewsDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid NewsDTO newsDTO) {
        return newsService.update(id, newsDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        newsService.delete(id);
    }

    @GetMapping("/searchByName")
    public List<NewsDTO> findByTitleContaining(@RequestParam @NotNull String title){
        return newsService.findByTitleContaining(title);
    }
}
