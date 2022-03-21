package dmitr2ish.com.github.mockito.annotations.support;

import java.util.List;

public interface SBookRepository {

    List<SBook> findNewBooks(int days);
}
