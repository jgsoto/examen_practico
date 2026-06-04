package library.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class JpaMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    protected JpaMemberEntity() {
    }

    public JpaMemberEntity(
            Long id,
            String name
    ) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}