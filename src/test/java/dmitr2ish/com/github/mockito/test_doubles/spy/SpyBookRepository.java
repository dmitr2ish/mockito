package dmitr2ish.com.github.mockito.test_doubles.spy;

public class SpyBookRepository implements SpBookRepository {

    int saveCalled = 0;
    SpBook lastAddedBook = null;

    @Override
    public void save(SpBook book) {
        saveCalled++;
        lastAddedBook = book;
    }

    public int timesCalled() {
        return saveCalled;
    }

    public boolean calledWith(SpBook book) {
        return lastAddedBook.equals(book);
    }
}
