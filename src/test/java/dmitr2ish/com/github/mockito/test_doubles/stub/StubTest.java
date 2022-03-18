package dmitr2ish.com.github.mockito.test_doubles.stub;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubTest {

    @Test
    public void demoStub() {
        SBookRepository bookRepository = new StubBookRepository();
        SBookService bookService = new SBookService(bookRepository);

        List<SBook> newBooksWithAppliedDiscount =
                bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}
