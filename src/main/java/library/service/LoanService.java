package library.service;

import library.model.Book;
import library.model.Loan;
import library.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookService bookService;
    private final MemberService memberService;

    public LoanService(LoanRepository loanRepository, BookService bookService, MemberService memberService) {
        this.loanRepository = loanRepository;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public Loan borrowBook(Long bookId, Long memberId) {

        Book book = bookService.findById(bookId);

        memberService.findById(memberId);

        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is not available");
        }

        book.setAvailable(false);
        bookService.save(book);

        Loan loan = new Loan(bookId, memberId);

        return loanRepository.save(loan);
    }

    public Loan returnBook(Long loanId) {

        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Loan not found"));

        if (loan.isReturned()) {
            throw new IllegalStateException("Loan already returned");
        }

        Book book = bookService.findById(loan.getBookId());

        loan.setReturned(true);
        book.setAvailable(true);

        bookService.save(book);

        return loanRepository.save(loan);
    }

    public List<Loan> findAll() {
        return loanRepository.findAll();
    }
}