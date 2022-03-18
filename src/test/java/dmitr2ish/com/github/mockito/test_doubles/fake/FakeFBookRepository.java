package dmitr2ish.com.github.mockito.test_doubles.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeFBookRepository implements FBookRepository {

    //in memory database, hashmap or list
    Map<String, FBook> bookStore = new HashMap<>();

    @Override
    public void save(FBook FBook) {
        bookStore.put(FBook.getBookId(), FBook);
    }

    @Override
    public Collection<FBook> findAll() {
        return bookStore.values();
    }
}
