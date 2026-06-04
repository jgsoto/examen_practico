package library.infrastructure.jpa;

import library.infrastructure.persistence.JpaMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberRepository
        extends JpaRepository<JpaMemberEntity, Long> {
}