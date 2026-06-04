package library.application.usecase;

import library.domain.model.Book;
import library.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBooksUseCase {

    private final BookRepository repository;

    public GetBooksUseCase(
            BookRepository repository
    ) {
        this.repository = repository;
    }

    public List<Book> execute() {
        return repository.findAll();
    }
}