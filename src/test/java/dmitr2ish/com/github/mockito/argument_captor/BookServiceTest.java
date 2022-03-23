package dmitr2ish.com.github.mockito.argument_captor;

import dmitr2ish.com.github.mockito.argument_captor.Book;
import dmitr2ish.com.github.mockito.argument_captor.BookRepository;
import dmitr2ish.com.github.mockito.argument_captor.BookService;
import dmitr2ish.com.github.mockito.stubbing.BookRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;


    @Test
    void testSaveBook() {
        BookRequest bookRequest = new BookRequest("Mockito in Action", 500, LocalDate.now());

        //provide captor of the argument for our book
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);

        bookService.addBook(bookRequest);
        //times() show how much times call this method, for example if price 500 save was called 0 times
        verify(bookRepository).save(bookArgumentCaptor.capture());
        Book book = bookArgumentCaptor.getValue();
        assertEquals("Mockito in Action", book.getTitle());
        assertEquals(500, book.getPrice());
        assertEquals(LocalDate.now(), book.getPublishedDate());
    }
}
