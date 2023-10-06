package com.wanderson.blog.dto;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record NewsDTO(
    Long id,
    Date creationDate,
    @NotBlank @NotNull @Length(min = 4, max = 100) String title,
    @NotBlank @NotNull @Length(min = 4, max = 5000) String text,
    @NotNull @Positive Long category_id,
    String category_title
) {
    
}
