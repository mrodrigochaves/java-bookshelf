package com.mrodrigochaves.bookshelf.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;
import com.mrodrigochaves.bookshelf.model.Books;
import com.mrodrigochaves.bookshelf.repository.BooksRepository;

import jakarta.validation.Valid;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository repository;
    private ModelMapper mapper;

    @Autowired
    public BooksServiceImpl(BooksRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<BooksDTO> create(@Valid BooksDTO request) {
        Books books = mapper.map(request, Books.class);
        Books salvedBooks = repository.saveAndFlush(books);
        return Optional.of(mapper.map(salvedBooks, BooksDTO.class));
    }

    @Override
    public List<BooksDTO> getAll() {
        List<Books> books = repository.findAll();
        return mapBooksListToDTO(books);
    }

    @Override
    public Optional<BooksDTO> getById(Long id) {
        return repository.findById(id)
                .map(books -> mapper.map(books, BooksDTO.class));
    }

    @Override
    public Optional<BooksDTO> deleteById(Long id) {
        Optional<Books> books = repository.findById(id);
        books.ifPresent(bk -> repository.deleteById(id));
        return books.map(bk -> mapper.map(bk, BooksDTO.class));
    }

    @Override
    public List<BooksDTO> getByAuthor(String author) {
        List<Books> books = repository.findByAuthor(author);
        return mapBooksListToDTO(books);
    }

    @Override
    public List<BooksDTO> getByPublished(String published) {
        List<Books> books = repository.findByPublished(published);
        return mapBooksListToDTO(books);
    }

    @Override
    public List<BooksDTO> getByDescription(String description) {
        List<Books> books = repository.findByDescription(description);
        return mapBooksListToDTO(books);
    }

    @Override
    public Optional<BooksDTO> update(Long id, @Valid BooksDTO request) {
        Optional<Books> booksOptional = repository.findById(id);
        if (booksOptional.isPresent()) {
            Books books = booksOptional.get();
            books.setTitle(request.getTitle());
            books.setAuthor(request.getAuthor());
            books.setDescription(request.getDescription());
            books.setPublished(request.getPublished());
            
            repository.save(books);
            return Optional.of(mapper.map(books, BooksDTO.class));
        }
        return Optional.empty();
    }

    private List<BooksDTO> mapBooksListToDTO(List<Books> books) {
        return books.stream()
                .map(book -> mapper.map(book, BooksDTO.class))
                .collect(Collectors.toList());
    }

}