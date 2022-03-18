package dmitr2ish.com.github.mockito.test_doubles.dummy;

import dmitr2ish.com.github.mockito.test_doubles.fake.FBook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeDBookRepository implements DBookRepository {

    //in memory database, hashmap or list
    Map<String, DBook> bookStore = new HashMap<>();


    @Override
    public void save(DBook DBook) {
        bookStore.put(DBook.getBookId(), DBook);
    }

    @Override
    public Collection<DBook> findAll() {
        return bookStore.values();
    }
}
