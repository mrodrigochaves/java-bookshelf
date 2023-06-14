package com.mrodrigochaves.bookshelf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;
import com.mrodrigochaves.bookshelf.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private final BooksService service;

    public BooksController(BooksService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BooksDTO>> getAll(){
        List<BooksDTO> books = service.getAll();
        return ResponseEntity.ok(books);
    }
    
    @GetMapping
    public ResponseEntity<List<BooksDTO>> getByName(@RequestParam("name") String name) {
    List<BooksDTO> books = service.getByName(name);
    return ResponseEntity.ok(books);
}

}
