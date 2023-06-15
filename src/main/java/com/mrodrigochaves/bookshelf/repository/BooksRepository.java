package com.mrodrigochaves.bookshelf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrodrigochaves.bookshelf.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{

    List<Books> findByTitle(List<Books> books);

    List<Books> findByTitle(String title);

    List<Books> findByAuthor(String author);

    List<Books> findByPublished(String published);

    List<Books> findByDescription(String description);
    
}
