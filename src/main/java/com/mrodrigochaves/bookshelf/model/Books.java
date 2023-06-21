package com.mrodrigochaves.bookshelf.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    
    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "author", nullable = false)
    private String author;

    
    @Column(name = "description", nullable = false)
    private String description;


    @Column(name = "published", nullable = false)
    private String published;

}
