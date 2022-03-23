package dmitr2ish.com.github.mockito.exception_handling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    List<Book> findAllBooks() throws SQLException;
}
