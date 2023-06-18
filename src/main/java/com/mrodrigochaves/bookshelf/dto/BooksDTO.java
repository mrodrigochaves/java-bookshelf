package com.mrodrigochaves.bookshelf.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Data
public class BooksDTO {

     public BooksDTO() {
    
    }

    @NotBlank
    @NonNull
    private String title;   

    @NotBlank
    @NonNull
    private String author;

    @NotBlank
    @NonNull
    private String description;

     @NotBlank
     @NonNull
    private String published;

     

   
    
    
    
}
