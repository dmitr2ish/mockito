package dmitr2ish.com.github.mockito.test_doubles.fake;

public class FBookService {

    private FBookRepository fBookRepository;

    public FBookService(FBookRepository fBookRepository) {
        this.fBookRepository = fBookRepository;
    }

    public void addBook(FBook fBook) {
        if (fBook.getPrice() > 400) {
            return;
        }
        fBookRepository.save(fBook);
    }

    public int findNumberOfBooks() {
        return fBookRepository.findAll().size();
    }
}
