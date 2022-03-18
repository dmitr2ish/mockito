package dmitr2ish.com.github.mockito.test_doubles.dummy;

public class DBookService {

    private DBookRepository DBookRepository;
    private EmailService emailService;

    public DBookService(DBookRepository DBookRepository, EmailService emailService) {
        this.DBookRepository = DBookRepository;
        this.emailService = emailService;
    }

    public void addBook(DBook DBook) {
        DBookRepository.save(DBook);
    }

    public int findNumberOfBooks() {
        return DBookRepository.findAll().size();
    }

    // other methos with uses EmailService
}
