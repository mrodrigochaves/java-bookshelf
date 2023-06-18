package com.mrodrigochaves.bookshelf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;
import com.mrodrigochaves.bookshelf.service.BooksService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private final BooksService service;

    public BooksController(BooksService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BooksDTO>> getAll() {
        List<BooksDTO> books = service.getAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BooksDTO>> getByAuthor(@PathVariable("author") String author) {
        List<BooksDTO> books = service.getByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/published/{published}")
    public ResponseEntity<List<BooksDTO>> getByPublished(@PathVariable("published") String published) {
        List<BooksDTO> books = service.getByPublished(published);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<BooksDTO>> getByDescription(@PathVariable("description") String description) {
        List<BooksDTO> books = service.getByDescription(description);
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<BooksDTO> create(@RequestBody @Valid BooksDTO request) {
        Optional<BooksDTO> response = service.create(request);
        return response.map(dto -> new ResponseEntity<>(dto, HttpStatus.CREATED))
                .orElse(ResponseEntity.badRequest().build());

    }

    @GetMapping("/{id}")
    public ResponseEntity<BooksDTO> getById(@PathVariable("id") Long id) {
        Optional<BooksDTO> response = service.getById(id);
        return response.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BooksDTO> update(@PathVariable("id") Long id, @RequestBody @Valid BooksDTO request) {
        Optional<BooksDTO> response = service.update(id, request);
        return response.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooks(@PathVariable Long id) {
        Optional<BooksDTO> books = service.deleteById(id);
        if (books.isPresent()) {
            return ResponseEntity.ok("Books deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

}
