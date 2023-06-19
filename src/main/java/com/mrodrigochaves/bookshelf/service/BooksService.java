package com.mrodrigochaves.bookshelf.service;

import java.util.List;
import java.util.Date;
import java.util.Optional;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;

import jakarta.validation.Valid;

public interface BooksService {

    List<BooksDTO> getAll();

    List<BooksDTO> getByAuthor(String name);

    List<BooksDTO> getByPublished(Date name);

    List<BooksDTO> getByDescription(String name);

    Optional<BooksDTO> create(@Valid BooksDTO request);

    Optional<BooksDTO> getById(Long id);

    Optional<BooksDTO> update(Long id, @Valid BooksDTO request);

    Optional<BooksDTO> deleteById(Long id);

}
