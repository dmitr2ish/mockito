package dmitr2ish.com.github.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FakeTest {

    @Test
    void testFake() {
        FBookRepository FBookRepository = new FakeFBookRepository();
        FBookService FBookService = new FBookService(FBookRepository);

        FBookService.addBook(new FBook("1234", "Mockito in Action", 250, LocalDate.now()));
        FBookService.addBook(new FBook("1235", "JUnit in Action", 200, LocalDate.now()));

        assertEquals(2, FBookService.findNumberOfBooks());
    }

    @Test
    void testFakeWithMockito() {
        FBookRepository bookRepository = mock(FBookRepository.class);
        FBookService bookService = new FBookService(bookRepository);

        FBook book1 = new FBook("1234", "Mockito in Action", 250, LocalDate.now());
        FBook book2 = new FBook("1235", "JUnit in Action", 200, LocalDate.now());

        Collection<FBook> collectionBooks = new ArrayList<>();

        collectionBooks.add(book1);
        collectionBooks.add(book2);

        when(bookRepository.findAll()).thenReturn(collectionBooks);

        assertEquals(2, bookService.findNumberOfBooks());
    }
}

