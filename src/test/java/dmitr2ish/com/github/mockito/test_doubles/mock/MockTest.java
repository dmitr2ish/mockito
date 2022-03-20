package dmitr2ish.com.github.mockito.test_doubles.mock;

import dmitr2ish.com.github.mockito.test_doubles.fake.FBook;
import dmitr2ish.com.github.mockito.test_doubles.fake.FBookRepository;
import dmitr2ish.com.github.mockito.test_doubles.fake.FBookService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

class MockTest {

    @Test
    void demoMock() {
        MockBookRepository bookRepository = new MockBookRepository();
        MBookService bookService = new MBookService(bookRepository);

        MBook mBook1 = new MBook("1234", "Mockito in Action", 500, LocalDate.now());
        MBook mBook2 = new MBook("1235", "JUnit in Action", 400, LocalDate.now());

        bookService.addBook(mBook1); //return
        bookService.addBook(mBook2); //save will be called

        bookRepository.verify(mBook2, 1);
    }

    @Test
    void demoMockWithMockito() {
        FBookRepository bookRepository = mock(FBookRepository.class);
        FBookService bookService = new FBookService(bookRepository);

        FBook mBook1 = new FBook("1234", "Mockito in Action", 500, LocalDate.now());
        FBook mBook2 = new FBook("1235", "JUnit in Action", 400, LocalDate.now());

        bookService.addBook(mBook1); //return
        bookService.addBook(mBook2); //save will be called

        //checking that really saved second book
        verify(bookRepository).save(mBook2);

        //checking how much times was called save
        verify(bookRepository, times(0)).save(mBook1);
        verify(bookRepository, times(1)).save(mBook2);
    }
}
