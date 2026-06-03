package library.service;

import library.model.Book;
import library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book create(Book book) {
        return repository.save(book);
    }

    public Book findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public List<Book> findAvailableBooks() {
        return repository.findByAvailableTrue();
    }
}