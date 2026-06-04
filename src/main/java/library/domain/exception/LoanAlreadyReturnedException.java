package library.domain.exception;

public class LoanAlreadyReturnedException
        extends RuntimeException {

    public LoanAlreadyReturnedException() {
        super("Loan already returned");
    }
}