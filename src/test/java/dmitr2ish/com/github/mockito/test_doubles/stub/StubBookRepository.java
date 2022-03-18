package dmitr2ish.com.github.mockito.test_doubles.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StubBookRepository implements SBookRepository {

    @Override
    public List<SBook> findNewBooks(int days) {
        List<SBook> newBooks = new ArrayList<>();
        newBooks.add(new SBook("1234","Mockito in Action",500, LocalDate.now()));
        newBooks.add(new SBook("1235","JUnit in Action",400, LocalDate.now()));
        return newBooks;
    }
}
