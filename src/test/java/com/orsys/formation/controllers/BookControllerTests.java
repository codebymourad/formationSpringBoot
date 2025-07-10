package com.orsys.formation.controllers;

import com.orsys.formation.dto.response.BookResponseDTO;
import com.orsys.formation.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BookControllerTests {

    @InjectMocks
    private BookController bookController;

    @Mock
    BookService bookService;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.openMocks(bookController);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBookSuccess() {
        // GIVEN
        Stream<BookResponseDTO> bookStream = Stream.of(new BookResponseDTO(), new BookResponseDTO());

        // WHEN
        when(bookService.getBooks()).thenReturn(bookStream);
        ResponseEntity<?> response = bookController.getBooks();

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookStream, response.getBody());
    }

    @Test
    void testGetBookFailure() {
        // GIVEN
        when(bookService.getBooks()).thenThrow(new RuntimeException("Service failed"));

        // WHEN
        ResponseEntity<?> response = bookController.getBooks();

        // THEN
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

}
