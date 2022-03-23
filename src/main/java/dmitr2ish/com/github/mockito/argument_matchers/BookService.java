package dmitr2ish.com.github.mockito.argument_matchers;

import dmitr2ish.com.github.mockito.stubbing.BookRequest;

import java.time.LocalDate;
import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(List<Book> books) {
        bookRepository.saveAll(books);
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
        Book book = bookRepository.findBookById(bookId);
        book.setPrice(updatePrice);
        bookRepository.save(book);
    }

    public Book getBookByTitleAndPublishedDate(String title, LocalDate localDate) {
        return bookRepository.findBookByTitleAndPublishedDate(title, localDate);
    }

    public Book getBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital) {
        return bookRepository.findBookByTitleAndPriceAndIsDigital(title, price, isDigital);
    }
}
