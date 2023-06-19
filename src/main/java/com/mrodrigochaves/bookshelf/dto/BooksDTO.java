package com.mrodrigochaves.bookshelf.dto;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

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
    private Date published;

    public void setPublished(String publishedDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.published = dateFormat.parse(publishedDate);
        } catch (ParseException e) {
            // Lidar com a exceção caso a data não possa ser formatada corretamente
            e.printStackTrace();
        }
    }
}