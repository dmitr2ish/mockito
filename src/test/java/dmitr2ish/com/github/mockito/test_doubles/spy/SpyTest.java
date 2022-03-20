package dmitr2ish.com.github.mockito.test_doubles.spy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpyTest {

    @Test
    void demoSpy() {
        SpyBookRepository bookRepository = new SpyBookRepository();
        SpBookService bookService = new SpBookService(bookRepository);

        SpBook spBook1 = new SpBook("1234", "Mockito in Action", 500, LocalDate.now());
        SpBook spBook2 = new SpBook("1235", "JUnit in Action", 400, LocalDate.now());

        bookService.addBook(spBook1);
        assertEquals(0, bookRepository.timesCalled());

        bookService.addBook(spBook2);
        assertEquals(1, bookRepository.timesCalled());

        assertTrue(bookRepository.calledWith(spBook2));
    }
}
