package com.mrodrigochaves.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrodrigochaves.bookshelf.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{
    
}
