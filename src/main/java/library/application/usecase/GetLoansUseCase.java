package library.application.usecase;

import library.domain.model.Loan;
import library.domain.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetLoansUseCase {

    private final LoanRepository repository;

    public GetLoansUseCase(
            LoanRepository repository
    ) {
        this.repository = repository;
    }

    public List<Loan> execute() {
        return repository.findAll();
    }
}