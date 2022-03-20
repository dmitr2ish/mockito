package dmitr2ish.com.github.mockito.test_doubles.stub;

import dmitr2ish.com.github.mockito.test_doubles.fake.FBook;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StubTest {

    @Test
    void demoStub() {
        SBookRepository bookRepository = new StubBookRepository();
        SBookService bookService = new SBookService(bookRepository);

        List<SBook> newBooksWithAppliedDiscount =
                bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    void demoStubWithMockito() {
        SBookRepository bookRepository = mock(SBookRepository.class);
        SBookService bookService = new SBookService(bookRepository);

        SBook book1 = new SBook("1234", "Mockito in Action", 500, LocalDate.now());
        SBook book2 = new SBook("1235", "JUnit in Action", 400, LocalDate.now());

        List<SBook> newBooks = new ArrayList<>();

        newBooks.add(book1);
        newBooks.add(book2);

        when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<SBook> newBooksWithAppliedDiscount =
                bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}
