package dmitr2ish.com.github.mockito.test_doubles.fake;

public class FBookService {

    private final FBookRepository bookRepository;

    public FBookService(FBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(FBook fBook) {
        if (fBook.getPrice() > 400) {
            return;
        }
        bookRepository.save(fBook);
    }

    public int findNumberOfBooks() {
        return bookRepository.findAll().size();
    }
}
