package dmitr2ish.com.github.mockito.test_doubles.dummy;

import java.util.Collection;

public interface DBookRepository {
    void save(DBook book);
    Collection<DBook> findAll();
}
