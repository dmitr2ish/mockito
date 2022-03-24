package dmitr2ish.com.github.mockito.test_doubles.spy;

import dmitr2ish.com.github.mockito.test_doubles.fake.FBook;
import dmitr2ish.com.github.mockito.test_doubles.fake.FBookRepository;
import dmitr2ish.com.github.mockito.test_doubles.fake.FBookService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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

    @Test
    void demoSpyWithMockito() {
        SpyBookRepository bookRepository = spy(SpyBookRepository.class);
        SpBookService bookService = new SpBookService(bookRepository);

        SpBook spBook1 = new SpBook("1234", "Mockito in Action", 500, LocalDate.now());
        SpBook spBook2 = new SpBook("1235", "JUnit in Action", 400, LocalDate.now());

        bookService.addBook(spBook1); //return
        bookService.addBook(spBook2); //save will be called

        //checking that really saved second book
        verify(bookRepository).save(spBook2);

        //checking how many times was called save
        verify(bookRepository, times(0)).save(spBook1);
        verify(bookRepository, times(1)).save(spBook2);
    }
}
