package dmitr2ish.com.github.mockito.test_doubles.fake;

public class FBookService {

    private FBookRepository FBookRepository;

    public FBookService(FBookRepository FBookRepository) {
        this.FBookRepository = FBookRepository;
    }

    public void addBook(FBook FBook) {
        FBookRepository.save(FBook);
    }

    public int findNumberOfBooks() {
        return FBookRepository.findAll().size();
    }
}
