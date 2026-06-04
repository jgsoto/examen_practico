package library.infrastructure.repository;

import library.domain.model.Loan;
import library.domain.repository.LoanRepository;
import library.infrastructure.jpa.SpringDataLoanRepository;
import library.infrastructure.persistence.JpaLoanEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoanRepositoryImpl
        implements LoanRepository {

    private final SpringDataLoanRepository repository;

    public LoanRepositoryImpl(
            SpringDataLoanRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public Loan save(Loan loan) {

        JpaLoanEntity entity =
                new JpaLoanEntity(
                        loan.getId(),
                        loan.getBookId(),
                        loan.getMemberId(),
                        loan.isReturned()
                );

        JpaLoanEntity saved =
                repository.save(entity);

        return new Loan(
                saved.getId(),
                saved.getBookId(),
                saved.getMemberId(),
                saved.isReturned()
        );
    }

    @Override
    public Optional<Loan> findById(Long id) {

        return repository.findById(id)
                .map(entity ->
                        new Loan(
                                entity.getId(),
                                entity.getBookId(),
                                entity.getMemberId(),
                                entity.isReturned()
                        )
                );
    }

    @Override
    public List<Loan> findAll() {

        return repository.findAll()
                .stream()
                .map(entity ->
                        new Loan(
                                entity.getId(),
                                entity.getBookId(),
                                entity.getMemberId(),
                                entity.isReturned()
                        )
                )
                .toList();
    }
}