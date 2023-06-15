package com.mrodrigochaves.bookshelf.service;

import java.util.List;
import java.util.Optional;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;

import jakarta.validation.Valid;

public interface BooksService {

    List<BooksDTO> getAll();

    List<BooksDTO> getByTitle(String title);

    List<BooksDTO> getByAuthor(String author);

    List<BooksDTO> getByPublished(String published);

	List<BooksDTO> getByDescription(String description);

    Optional<BooksDTO> create(@Valid BooksDTO request);

    Optional<BooksDTO> delete(Long id);

}
