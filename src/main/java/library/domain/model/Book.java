package library.domain.model;

import library.domain.exception.BookAlreadyAvailableException;
import library.domain.exception.BookUnavailableException;
import library.domain.valueobject.BookTitle;

public class Book {

    private Long id;
    private BookTitle title;
    private boolean available;

    public Book(
            Long id,
            BookTitle title,
            boolean available
    ) {
        this.id = id;
        this.title = title;
        this.available = available;
    }

    public void borrow() {

        if (!available) {
            throw new BookUnavailableException();
        }

        available = false;
    }

    public void returnBook() {

        if (available) {
            throw new BookAlreadyAvailableException();
        }

        available = true;
    }

    public Long getId() {
        return id;
    }

    public BookTitle getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }
}