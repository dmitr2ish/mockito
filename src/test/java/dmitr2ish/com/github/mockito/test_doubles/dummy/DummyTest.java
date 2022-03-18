package dmitr2ish.com.github.mockito.test_doubles.dummy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void demoDummy() {
        DBookRepository DBookRepository = new FakeDBookRepository();
        EmailService emailService = new DummyEmailService();
        DBookService DBookService = new DBookService(DBookRepository, emailService);

        DBookService.addBook(new DBook("1234","Mockito in Action",250, LocalDate.now()));
        DBookService.addBook(new DBook("1235","JUnit in Action",200, LocalDate.now()));

        assertEquals(2, DBookService.findNumberOfBooks());
    }
}
