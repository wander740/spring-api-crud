package com.wanderson.blog.dto;

public record NewsDTO(
    Long id,
    String title,
    String text,
    Long category_id
) {
    
}
