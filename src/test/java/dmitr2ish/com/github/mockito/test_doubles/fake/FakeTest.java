package dmitr2ish.com.github.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FakeTest {

    @Test
    void testFake() {
        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);

        bookService.addBook(new Book("1234","Mockito in Action",250, LocalDate.now()));
        bookService.addBook(new Book("1235","JUnit in Action",200, LocalDate.now()));

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
