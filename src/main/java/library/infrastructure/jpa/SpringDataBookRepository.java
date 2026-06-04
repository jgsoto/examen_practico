package library.infrastructure.jpa;

import library.infrastructure.persistence.JpaBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataBookRepository
        extends JpaRepository<JpaBookEntity, Long> {
    List<JpaBookEntity> findByAvailableTrue();
}