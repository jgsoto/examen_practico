package library.application.usecase;

import library.domain.model.Book;
import library.domain.model.Loan;
import library.domain.repository.BookRepository;
import library.domain.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BorrowBookUseCase {

    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    public BorrowBookUseCase(
            BookRepository bookRepository,
            LoanRepository loanRepository
    ) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    public Loan execute(
            Long bookId,
            Long memberId
    ) {

        Book book =
                bookRepository.findById(bookId)
                        .orElseThrow();

        book.borrow();

        bookRepository.save(book);

        Loan loan =
                new Loan(
                        null,
                        bookId,
                        memberId,
                        false
                );

        return loanRepository.save(loan);
    }
}