package dmitr2ish.com.github.mockito.spies;

public class BookManager {
    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }
}
