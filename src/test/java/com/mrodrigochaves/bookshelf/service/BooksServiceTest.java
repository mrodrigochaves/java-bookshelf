package com.mrodrigochaves.bookshelf.service;

import com.mrodrigochaves.bookshelf.dto.BooksDTO;
import com.mrodrigochaves.bookshelf.model.Books;
import com.mrodrigochaves.bookshelf.repository.BooksRepository;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BooksServiceTest {

    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BooksService booksService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        factory.getValidator();
    }

    @Test
    public void testCreateValidRequest() {

        BooksDTO request = new BooksDTO();
        request.setTitle("Book Title");
        request.setAuthor("Author");
        request.setPublished("Published");
        request.setDescription("Description");
        request.setImage("Image");
        request.setSubtitle("Subtitle");
        when(booksRepository.save(any(Books.class)))
                .thenReturn(new Books(1L, "Book Title", "Author", "Published", "Description", "Image", "Subtitle"));

        Optional<BooksDTO> result = booksService.create(request);

        assertTrue(result.isPresent());
        assertEquals("Book Title", result.get().getTitle());
        assertEquals("Author", result.get().getAuthor());
        assertEquals("Published", result.get().getPublished());
        assertEquals("Description", result.get().getDescription());
        assertEquals("Image", result.get().getImage());
        assertEquals("Subtitle", result.get().getSubtitle());

        verify(booksRepository, times(1)).save(any(Books.class));
    }

    @Test
    public void testCreateInvalidRequest() {

        BooksDTO request = new BooksDTO();
        request.setTitle("");
        request.setAuthor("Author");
        request.setPublished("Published");
        request.setDescription("Description");
        request.setImage("Image");
        request.setSubtitle("Subtitle");

        Optional<BooksDTO> result = booksService.create(request);

        assertFalse(result.isPresent());

        verify(booksRepository, never()).save(any(Books.class));
    }
}
