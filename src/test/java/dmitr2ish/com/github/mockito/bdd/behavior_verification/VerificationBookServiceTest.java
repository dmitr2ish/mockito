package dmitr2ish.com.github.mockito.bdd.behavior_verification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VerificationBookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

//    @Spy
//    private BookRepository bookRepository;

    @Test
    void testUpdatePrice_1() {
        Book book = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234", 500);
        //check that book really call
        verify(bookRepository).findBookById("1234");
        verify(bookRepository).save(book);
        //mean that after last check interactions was not
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    @DisplayName("Given a book, " +
            "when update price is called with new price, " +
            "then book price is updated")
    void test_Given_ABook_When_UpdatePriceIsCalledWithNewPrice_Then_BookPriceIsUpdated() {
        //Given - Arrange
        Book book = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        given(bookRepository.findBookById("1234")).willReturn(book);
        //When - Act
        bookService.updatePrice("1234", 500);
        //Then - Assert/Verify
        then(bookRepository).should().findBookById("1234");
        then(bookRepository).should().save(book);
    }
}
