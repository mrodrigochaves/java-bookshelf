package com.mrodrigochaves.bookshelf.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BooksDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String subtitle;

    @NotBlank
    private String image;

    @NotBlank
    private String author;

    @NotBlank
    private String description;

    @NotNull
    private String published;

    public BooksDTO(String title, String author, String published, String description) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.description = description;
    }

    public BooksDTO() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}