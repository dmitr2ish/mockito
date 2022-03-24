package dmitr2ish.com.github.mockito.test_doubles.mock;

public class MBookService {

    private final MBookRepository bookRepository;

    public MBookService(MBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(MBook book) {
        if(book.getPrice() > 400) {
            return;
        }
        bookRepository.save(book);
    }
}
