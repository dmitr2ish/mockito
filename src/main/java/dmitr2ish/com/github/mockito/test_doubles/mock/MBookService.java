package dmitr2ish.com.github.mockito.test_doubles.mock;

public class MBookService {

    private MBookRepository mBookRepository;

    public MBookService(MBookRepository mBookRepository) {
        this.mBookRepository = mBookRepository;
    }

    public void addBook(MBook book) {
        if(book.getPrice() > 400) {
            return;
        }
        mBookRepository.save(book);
    }
}
