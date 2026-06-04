package library.application;

import library.domain.model.Book;
import library.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAvailableBooksUseCase {

    private final BookRepository repository;

    public GetAvailableBooksUseCase(
            BookRepository repository
    ) {
        this.repository = repository;
    }

    public List<Book> execute() {
        return repository.findAvailableBooks();
    }
}