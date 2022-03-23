package dmitr2ish.com.github.mockito.exception_handling;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks() {
        List<Book> books = null;
        try {
            books = bookRepository.findAllBooks();
        } catch (SQLException e) {
            //log exception
            throw new DatabaseReadException("Unable to read from database duo to - " + e.getMessage());
        }
        int totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }
}
