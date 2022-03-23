package dmitr2ish.com.github.mockito.spies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookManagerTest {

    @InjectMocks
    private BookManager bookManager;

    @Spy
    private BookService bookService;

    @Test
    void testMockitoSpy() {
        BookService bookService = Mockito.spy(BookService.class);
        BookManager bookManager = new BookManager(bookService);
    }
}
