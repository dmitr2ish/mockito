package dmitr2ish.com.github.mockito.test_doubles.spy;

public class SpBookService {

    private SpBookRepository SpBookRepository;

    public SpBookService(SpBookRepository SpBookRepository) {
        this.SpBookRepository = SpBookRepository;
    }

    public void addBook(SpBook SpBook) {
        SpBookRepository.save(SpBook);
    }

    public int findNumberOfBooks() {
        return SpBookRepository.findAll().size();
    }
}
