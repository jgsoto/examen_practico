package library.application.usecase;

import library.domain.model.Book;
import library.domain.model.Loan;
import library.domain.repository.BookRepository;
import library.domain.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReturnBookUseCase {

    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    public ReturnBookUseCase(
            BookRepository bookRepository,
            LoanRepository loanRepository
    ) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    public Loan execute(Long loanId) {

        Loan loan =
                loanRepository.findById(loanId)
                        .orElseThrow();

        loan.returnLoan();

        Book book =
                bookRepository.findById(
                        loan.getBookId()
                ).orElseThrow();

        book.returnBook();

        bookRepository.save(book);

        return loanRepository.save(loan);
    }
}