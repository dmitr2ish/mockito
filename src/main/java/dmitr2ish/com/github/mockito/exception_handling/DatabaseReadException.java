package dmitr2ish.com.github.mockito.exception_handling;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(String message) {
        super(message);
    }
}
