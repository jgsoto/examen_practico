package library.application;

import library.domain.model.Book;
import library.domain.valueobject.BookTitle;
import library.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterBookUseCase {

    private final BookRepository repository;

    public RegisterBookUseCase(
            BookRepository repository
    ) {
        this.repository = repository;
    }

    public Book execute(String title) {

        Book book =
                new Book(
                        null,
                        new BookTitle(title),
                        true
                );

        return repository.save(book);
    }
}