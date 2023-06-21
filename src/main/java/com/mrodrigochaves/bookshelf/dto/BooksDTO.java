package com.mrodrigochaves.bookshelf.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BooksDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String description;

    @NotNull
    private String published;
}