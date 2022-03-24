package dmitr2ish.com.github.mockito.test_doubles.stub;

import java.util.List;

public interface SBookRepository {
    List<SBook> findNewBooks(int days);
}
