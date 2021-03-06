package dmitr2ish.com.github.mockito.annotations.support;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)//extension for mock's annotation use
class AnnotationTest {


    @InjectMocks//here we point where we want to inject our mock's dependency
    private SBookService bookService;

    @Mock//dependency of test class
    private SBookRepository bookRepository;

    @Test
    void demoCreateMocksUsingAnnotations() {
        SBook book1 = new SBook("1234", "Mockito in Action", 500, LocalDate.now());
        SBook book2 = new SBook("1235", "JUnit in Action", 400, LocalDate.now());

        List<SBook> newBooks = new ArrayList<>();

        newBooks.add(book1);
        newBooks.add(book2);

        when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<SBook> newBooksWithAppliedDiscount =
                bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}
