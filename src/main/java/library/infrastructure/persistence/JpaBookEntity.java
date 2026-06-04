package library.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class JpaBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean available;

    protected JpaBookEntity() {
    }

    public JpaBookEntity(
            Long id,
            String title,
            boolean available
    ) {
        this.id = id;
        this.title = title;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }
}