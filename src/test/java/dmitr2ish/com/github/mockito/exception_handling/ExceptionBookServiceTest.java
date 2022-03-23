package dmitr2ish.com.github.mockito.exception_handling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
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


}
