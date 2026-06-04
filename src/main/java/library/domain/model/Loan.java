package library.domain.model;

import library.domain.exception.LoanAlreadyReturnedException;
import lombok.Getter;

@Getter
public class Loan {

    private Long id;
    private Long bookId;
    private Long memberId;
    private boolean returned;

    public Loan(
            Long id,
            Long bookId,
            Long memberId,
            boolean returned
    ) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.returned = returned;
    }

    public void returnLoan() {

        if (returned) {
            throw new LoanAlreadyReturnedException();
        }

        returned = true;
    }

}