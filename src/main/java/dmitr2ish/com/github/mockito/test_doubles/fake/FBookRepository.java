package dmitr2ish.com.github.mockito.test_doubles.fake;

import java.util.Collection;

public interface FBookRepository {
    void save(FBook FBook);
    Collection<FBook> findAll();
}
