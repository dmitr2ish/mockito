package dmitr2ish.com.github.mockito.behavior.verification;

import dmitr2ish.com.github.mockito.stubbing.BookRequest;

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

    public void addBook(BookRequest bookRequest) {
        if (bookRequest.getPrice() <= 500) {
            return;
        }
        Book book = new Book(null
                , bookRequest.getTitle(),
                bookRequest.getPrice(),
                bookRequest.getPublishedDate());
        bookRepository.save(book);
    }

    public void updatePrice(String bookId, int updatePrice) {
        if (bookId == null) {
            return;
        }
        Book book = bookRepository.findBookById(bookId);
        if (book.getPrice() == updatePrice) {
            return;
        }
        book.setPrice(updatePrice);
        bookRepository.save(book);
    }
}
