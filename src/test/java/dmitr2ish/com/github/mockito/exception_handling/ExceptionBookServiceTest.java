package dmitr2ish.com.github.mockito.exception_handling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExceptionBookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void testTotalPriceOfBooks() throws SQLException {
        //init throw exception
        when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    @Test
    void testTotalPriceOfBooks_3() throws SQLException {
        //init throw exception
        //when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        given(bookRepository.findAllBooks()).willThrow(SQLException.class);
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    @Test
    void testTotalPriceOfBooks_1() throws SQLException {
        //init throw exception
        when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database is not available"));
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    @Test
    void testAddBook() throws SQLException {
        Book book = new Book(null, "Mockito in Action", 600, LocalDate.now());
        //init throw exception
        doThrow(SQLException.class).when(bookRepository).save(book);
        assertThrows(DatabaseWriteException.class, () -> bookService.addBook(book));
    }


}
