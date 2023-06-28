package com.mrodrigochaves.bookshelf.controller;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;
import com.mrodrigochaves.bookshelf.service.BooksService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BooksControllerTest {

    @Mock
    private BooksService booksService;

    @InjectMocks
    private BooksController booksController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {

        List<BooksDTO> expectedBooks = new ArrayList<>();
        expectedBooks.add(new BooksDTO("Book Title", "Author", "Published", "Description"));
        when(booksService.getAll()).thenReturn(expectedBooks);

        List<BooksDTO> actualBooks = booksController.getAll().getBody();

        assertEquals(expectedBooks, actualBooks);

        verify(booksService, times(1)).getAll();
    }

}