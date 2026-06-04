package library.domain.exception;

public class BookAlreadyAvailableException
        extends RuntimeException {

    public BookAlreadyAvailableException() {
        super("Book is already available");
    }
}