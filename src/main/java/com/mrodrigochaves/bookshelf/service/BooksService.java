package com.mrodrigochaves.bookshelf.service;

import java.util.List;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;

public interface BooksService {

    List<BooksDTO> getAll();

    List<BooksDTO> getByTitle(String title);

    List<BooksDTO> getByAuthor(String author);

    List<BooksDTO> getByPublished(String published);

	List<BooksDTO> getByDescription(String description);

}
