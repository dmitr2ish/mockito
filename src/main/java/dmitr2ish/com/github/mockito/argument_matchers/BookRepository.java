package dmitr2ish.com.github.mockito.argument_matchers;

import java.time.LocalDate;

public interface BookRepository {
    void save(Book book);

    Book findBookById(String bookId);

    Book findBookByTitleAndPublishedDate(String title, LocalDate localDate);
}
