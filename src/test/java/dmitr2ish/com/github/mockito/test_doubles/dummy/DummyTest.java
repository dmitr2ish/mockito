package dmitr2ish.com.github.mockito.test_doubles.dummy;

import dmitr2ish.com.github.mockito.test_doubles.fake.FBook;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DummyTest {

    @Test
    void demoDummy() {
        DBookRepository DBookRepository = new FakeDBookRepository();
        EmailService emailService = new DummyEmailService();
        DBookService dBookService = new DBookService(DBookRepository, emailService);

        dBookService.addBook(new DBook("1234", "Mockito in Action", 250, LocalDate.now()));
        dBookService.addBook(new DBook("1235", "JUnit in Action", 200, LocalDate.now()));

        assertEquals(2, dBookService.findNumberOfBooks());
    }

    @Test
    void demoDummyWithMockito() {
        DBookRepository dBookRepository = mock(DBookRepository.class);
        EmailService emailService = mock(EmailService.class);
        DBookService dBookService = new DBookService(dBookRepository, emailService);

        DBook book1 = new DBook("1234", "Mockito in Action", 250, LocalDate.now());
        DBook book2 = new DBook("1235", "JUnit in Action", 200, LocalDate.now());

        Collection<DBook> collectionBooks = new ArrayList<>();

        collectionBooks.add(book1);
        collectionBooks.add(book2);

        when(dBookRepository.findAll()).thenReturn(collectionBooks);

        assertEquals(2, dBookService.findNumberOfBooks());
    }
}
