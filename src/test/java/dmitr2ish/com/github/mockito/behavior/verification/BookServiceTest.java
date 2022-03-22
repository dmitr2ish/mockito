package dmitr2ish.com.github.mockito.behavior.verification;

import dmitr2ish.com.github.mockito.behavior.verification.Book;
import dmitr2ish.com.github.mockito.behavior.verification.BookRepository;
import dmitr2ish.com.github.mockito.behavior.verification.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        Book book = new Book(null, "Mockito in Action", 500, LocalDate.now());
        bookService.addBook(book);
        verify(bookRepository).save(book);
    }

}
