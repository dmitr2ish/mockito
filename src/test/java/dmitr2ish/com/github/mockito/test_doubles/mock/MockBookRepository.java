package dmitr2ish.com.github.mockito.test_doubles.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockBookRepository implements MBookRepository {

    int saveCalled = 0;
    MBook lastAddedBook = null;

    @Override
    public void save(MBook book) {
        saveCalled++;
        lastAddedBook = book;
    }

    public void verify(MBook book, int times) {
        assertEquals(times, saveCalled);
        assertEquals(book, lastAddedBook);
    }
}
