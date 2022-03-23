package dmitr2ish.com.github.mockito.bdd.behavior_verification;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if (book.getPrice() <= 500) {
            return;
        }
        bookRepository.save(book);
    }

    public void updatePrice(String bookId, int updatePrice) {
        Book book = bookRepository.findBookById(bookId);
        book.setPrice(updatePrice);
        bookRepository.save(book);
    }
}
