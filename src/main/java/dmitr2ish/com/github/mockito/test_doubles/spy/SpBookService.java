package dmitr2ish.com.github.mockito.test_doubles.spy;

public class SpBookService {

    private SpBookRepository spBookRepository;

    public SpBookService(SpBookRepository spBookRepository) {
        this.spBookRepository = spBookRepository;
    }

    public void addBook(SpBook book) {
        if(book.getPrice() > 400) {
            return;
        }
        spBookRepository.save(book);
    }
}
