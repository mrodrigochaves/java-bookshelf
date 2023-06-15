package com.mrodrigochaves.bookshelf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;
import com.mrodrigochaves.bookshelf.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService service;

    @Autowired
    public BooksController(BooksService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BooksDTO>> getAll() {
        List<BooksDTO> books = service.getAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BooksDTO>> getByTitle(@PathVariable("title") String title){
        List<BooksDTO> books = service.getByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BooksDTO>> getByAuthor(@PathVariable("author") String author){
        List<BooksDTO> books = service.getByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/published/{published}")
    public ResponseEntity<List<BooksDTO>> getByPublished(@PathVariable("published") String published){
        List<BooksDTO> books = service.getByPublished(published);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<BooksDTO>> getByDescription(@PathVariable("description") String description){
        List<BooksDTO> books = service.getByDescription(description);
        return ResponseEntity.ok(books);
    }

}
