package com.mrodrigochaves.bookshelf.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrodrigochaves.bookshelf.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {


    List<Books> findByAuthor(String author);

    List<Books> findByDescription(String description);

    List<Books> findByPublished(Date published);

    List<Books> findByTitle(String title);

}
