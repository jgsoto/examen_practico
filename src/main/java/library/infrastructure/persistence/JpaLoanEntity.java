package library.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "loans")
public class JpaLoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;

    private Long memberId;

    private boolean returned;

    protected JpaLoanEntity() {
    }

    public JpaLoanEntity(
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

    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public boolean isReturned() {
        return returned;
    }
}