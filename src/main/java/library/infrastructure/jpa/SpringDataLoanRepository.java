package library.infrastructure.jpa;

import library.infrastructure.persistence.JpaLoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataLoanRepository
        extends JpaRepository<JpaLoanEntity, Long> {
}