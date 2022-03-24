package dmitr2ish.com.github.mockito.spies;

public class BookManager {
    private final BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int applyDiscountOnBook(String bookId, int discountRate) {
        Book book = bookService.findBook(bookId); //we need to Mock
        return bookService.getAppliedDiscount(book, discountRate);
    }
}
