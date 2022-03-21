package dmitr2ish.com.github.mockito.stubbing;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);

    Book findBookById(String bookId);
}
