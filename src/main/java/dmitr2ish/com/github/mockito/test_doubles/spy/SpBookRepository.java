package dmitr2ish.com.github.mockito.test_doubles.spy;

import java.util.Collection;

public interface SpBookRepository {
    void save(SpBook SpBook);
    Collection<SpBook> findAll();
}
