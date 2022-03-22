package dmitr2ish.com.github.mockito.behavior.verification;

import dmitr2ish.com.github.mockito.stubbing.BookRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VerificationBookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void testSaveBook() {
        Book book = new Book(null, "Mockito in Action", 500, LocalDate.now());
        bookService.addBook(book);
        verify(bookRepository).save(book);
    }

    @Test
    void testSaveBookWithBookRequest_0() {
        BookRequest bookRequest = new BookRequest("Mockito in Action", 500, LocalDate.now());
        Book book = new Book(null, "Mockito in Action", 500, LocalDate.now());
        bookService.addBook(bookRequest);
        //times() show how much times call this method, for example if price 500 save was called 0 times
        verify(bookRepository, times(0)).save(book);
    }

    @Test
    void testSaveBookWithBookRequest_1() {
        BookRequest bookRequest = new BookRequest("Mockito in Action", 600, LocalDate.now());
        Book book = new Book(null, "Mockito in Action", 600, LocalDate.now());
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        //times() show how much times call this method, for example if price 500 save was called 0 times
        verify(bookRepository, times(2)).save(book);
    }

    @Test
    void testSaveBookWithBookRequest_2() {
        BookRequest bookRequest = new BookRequest("Mockito in Action", 500, LocalDate.now());
        Book book = new Book(null, "Mockito in Action", 500, LocalDate.now());
        bookService.addBook(bookRequest);
        //never() the same as times(0)
        verify(bookRepository, never()).save(book);
    }

    @Test
    void testUpdatePrice() {
        bookService.updatePrice(null, 600);
        //no interactions with this mock object
        verifyNoInteractions(bookRepository);
    }

    @Test
    void testUpdatePrice_1() {
        Book book = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234", 500);
        //check that book really call
        verify(bookRepository).findBookById("1234");
        //mean that after last check interactions was not
        verifyNoMoreInteractions(bookRepository);
    }
}
