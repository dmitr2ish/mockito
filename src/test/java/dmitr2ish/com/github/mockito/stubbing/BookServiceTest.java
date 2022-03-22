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
import static org.mockito.Mockito.*;

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
        bookIds.add("1234");

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit in Action", 400, LocalDate.now());

//        when(bookRepository.findBookById("1234")).thenReturn(book1);
//        when(bookRepository.findBookById("1235")).thenReturn(book2);

//        doReturn(book1).when(bookRepository).findBookById("1234");
//        doReturn(book2).when(bookRepository).findBookById("1235");

        //more readable variant
        when(bookRepository.findBookById("1234"))
                .thenReturn(book1)
                .thenReturn(book1);

        int actualCost = bookService.calculateTotalCost(bookIds);
        assertEquals(1000, actualCost);
    }


    @Test
    void testSaveBook() {
        Book book = new Book(null, "Mockito in Action", 500, LocalDate.now());
        doNothing().when(bookRepository).save(book);
        bookService.addBook(book);
        verify(bookRepository).save(book);
    }

    @Test
    void testSaveBookWithBookRequest() {
        BookRequest bookRequest = new BookRequest( "Mockito in Action", 500, LocalDate.now());
        Book book = new Book(null, "Mockito in Action", 500, LocalDate.now());
        //doNothing().when(bookRepository).save(book);

        bookService.addBook(bookRequest);
        verify(bookRepository, times(1)).save(book);
    }
}
