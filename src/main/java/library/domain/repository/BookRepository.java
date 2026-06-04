package library.domain.repository;

import library.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book save(Book book);

    Optional<Book> findById(Long id);

    List<Book> findAll();

    List<Book> findAvailableBooks();
}