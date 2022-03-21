package dmitr2ish.com.github.mockito.stubbing;

import dmitr2ish.com.github.mockito.annotations.support.SBook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void testCalculateTotalCostOfBooks() {
        List<String> bookIds = new ArrayList<>();
        bookIds.add("1234");
        bookIds.add("1235");

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit in Action", 400, LocalDate.now());

        when(bookRepository.findBookById("1234")).thenReturn(book1);
        when(bookRepository.findBookById("1235")).thenReturn(book2);

        int actualCost = bookService.calculateTotalCost(bookIds);
        assertEquals(900, actualCost);
    }
}
