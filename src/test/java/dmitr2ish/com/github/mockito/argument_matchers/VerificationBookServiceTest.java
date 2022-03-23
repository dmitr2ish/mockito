package dmitr2ish.com.github.mockito.argument_matchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VerificationBookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

//    @Spy
//    private BookRepository bookRepository;

    @Test
    void testUpdatePrice() {
        Book book1 = new Book("1234", "Mockito in Action", 600, LocalDate.now());
        Book book2 = new Book("1234", "Mockito in Action", 500, LocalDate.now());

        when(bookRepository.findBookById(any(String.class))).thenReturn(book1);
        bookService.updatePrice("1234", 500);
        verify(bookRepository).save(book2);
    }

    // Argument Matchers should be provided for all arguments
    // Argument matchers cant be used outside stubbing/verification
    @Test
    void testInvalidUseOfArgumentMatchers() {
        Book book = new Book("1234", "Mockito in Action", 600, LocalDate.now());
        //eq() -  argument matcher
        when(bookRepository.findBookByTitleAndPublishedDate(eq("Mockito in Action"), any())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPublishedDate("Mockito in Action", LocalDate.now());
        assertEquals("Mockito in Action", actualBook.getTitle());

    }

    @Test
    void testSpecificTypeOfArgumentMatchers() {
        Book book = new Book("1234", "Mockito in Action", 600, LocalDate.now());
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(anyString(), anyInt(), anyBoolean())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("Mockito in Action", 600, true);
        assertEquals("Mockito in Action", actualBook.getTitle());
    }

    @Test
    void testCollectionTypeArgumentMatchers() {
        List<Book> books = new ArrayList<>();
        Book book = new Book("1234", "Mockito in Action", 600, LocalDate.now());
        books.add(book);
        bookService.addBook(books);
        verify(bookRepository).saveAll(anyList());
    }

}
