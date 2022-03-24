package dmitr2ish.com.github.mockito.test_doubles.dummy;

public class DBookService {

    private final DBookRepository bookRepository;
    private final EmailService emailService;

    public DBookService(DBookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
    }

    public void addBook(DBook book) {
        bookRepository.save(book);
    }

    public int findNumberOfBooks() {
        return bookRepository.findAll().size();
    }

    // other methos with uses EmailService
}
