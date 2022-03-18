package dmitr2ish.com.github.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FakeTest {

    @Test
    void testFake() {
        FBookRepository FBookRepository = new FakeFBookRepository();
        FBookService FBookService = new FBookService(FBookRepository);

        FBookService.addBook(new FBook("1234","Mockito in Action",250, LocalDate.now()));
        FBookService.addBook(new FBook("1235","JUnit in Action",200, LocalDate.now()));

        assertEquals(2, FBookService.findNumberOfBooks());
    }
}
