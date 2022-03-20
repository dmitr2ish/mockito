package dmitr2ish.com.github.mockito.test_doubles.mock;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
}
