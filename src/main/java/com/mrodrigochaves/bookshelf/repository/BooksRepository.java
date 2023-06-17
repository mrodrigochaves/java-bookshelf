package com.mrodrigochaves.bookshelf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;
import com.mrodrigochaves.bookshelf.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    List<Books> findByTitle(String title);

    List<Books> findByAuthor(String author);

    List<Books> findByPublished(String published);

    List<Books> findByDescription(String description);

    Optional<BooksDTO> delete(Long id);

}
