package dmitr2ish.com.github.mockito.test_doubles.stub;

import java.util.List;

public class SBookService {

    private final SBookRepository bookRepository;

    public SBookService(SBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<SBook> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<SBook> newBooks = bookRepository.findNewBooks(days);
        //500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450
        for (SBook book : newBooks) {
            int price = book.getPrice();
            int newPrice = price - (discountRate * price / 100);
            book.setPrice(newPrice);

        }
        return newBooks;
    }
}
