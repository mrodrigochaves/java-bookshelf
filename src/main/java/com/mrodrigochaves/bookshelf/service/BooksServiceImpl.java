package com.mrodrigochaves.bookshelf.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;
import com.mrodrigochaves.bookshelf.model.Books;
import com.mrodrigochaves.bookshelf.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository repository;
    private ModelMapper mapper;

    @Autowired
    public BooksServiceImpl(BooksRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    
    @Override
    public List<BooksDTO> getAll() {
        List<Books> books = repository.findAll();
        return mapBooksListToDTO(books);    
    }

    private List<BooksDTO> mapBooksListToDTO(List<Books> books) {
        return books.stream()
                .map(book -> mapper.map(books, BooksDTO.class))
                .collect(Collectors.toList());
    }
    
}
