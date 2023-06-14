package com.mrodrigochaves.bookshelf.service;

import java.util.List;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;

public interface BooksService {

    List<BooksDTO> getAll();
    
}
