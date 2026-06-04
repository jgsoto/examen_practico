package library.infrastructure.repository;

import library.domain.model.Book;
import library.domain.valueobject.BookTitle;
import library.domain.repository.BookRepository;
import library.infrastructure.jpa.SpringDataBookRepository;
import library.infrastructure.persistence.JpaBookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl
        implements BookRepository {

    private final SpringDataBookRepository repository;

    public BookRepositoryImpl(
            SpringDataBookRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {

        JpaBookEntity entity =
                new JpaBookEntity(
                        book.getId(),
                        book.getTitle().getValue(),
                        book.isAvailable()
                );

        JpaBookEntity saved =
                repository.save(entity);

        return new Book(
                saved.getId(),
                new BookTitle(saved.getTitle()),
                saved.isAvailable()
        );
    }

    @Override
    public Optional<Book> findById(Long id) {

        return repository.findById(id)
                .map(entity ->
                        new Book(
                                entity.getId(),
                                new BookTitle(
                                        entity.getTitle()
                                ),
                                entity.isAvailable()
                        )
                );
    }

    @Override
    public List<Book> findAll() {

        return repository.findAll()
                .stream()
                .map(entity ->
                        new Book(
                                entity.getId(),
                                new BookTitle(
                                        entity.getTitle()
                                ),
                                entity.isAvailable()
                        )
                )
                .toList();
    }

    @Override
    public List<Book> findAvailableBooks() {

        return repository.findByAvailableTrue()
                .stream()
                .map(entity ->
                        new Book(
                                entity.getId(),
                                new BookTitle(
                                        entity.getTitle()
                                ),
                                entity.isAvailable()
                        )
                )
                .toList();
    }
}