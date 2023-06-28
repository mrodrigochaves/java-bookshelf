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

    @Column(name = "subtitle", nullable = false)
    private String subtitle;

    @Column(name = "image", nullable = false)
    private String image;


    @Column(name = "author", nullable = false)
    private String author;

    
    @Column(name = "description", nullable = false)
    private String description;


    @Column(name = "published", nullable = false)
    private String published;

    public Books() {
    }

    public Books(long id, String title, String author, String published, String description, String image, String subtitle) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.published = published;
        this.description = description;
        this.image = image;
        this.subtitle = subtitle;
    }


}
