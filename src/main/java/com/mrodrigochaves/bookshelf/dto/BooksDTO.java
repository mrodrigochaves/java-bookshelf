package com.mrodrigochaves.bookshelf.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BooksDTO {

    @NotBlank
    private String title;   

    @NotBlank
    private String author;

    @NotBlank
    private String description;

     @NotBlank
    private String published;

     

   
    
    
    
}
