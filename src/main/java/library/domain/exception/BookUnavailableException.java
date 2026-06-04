package library.domain.exception;

public class BookUnavailableException
        extends RuntimeException {

    public BookUnavailableException() {
        super("Book is unavailable");
    }
}