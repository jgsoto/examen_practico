package library.infrastructure.repository;

import library.domain.model.Member;
import library.domain.repository.MemberRepository;
import library.infrastructure.jpa.SpringDataMemberRepository;
import library.infrastructure.persistence.JpaMemberEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl
        implements MemberRepository {

    private final SpringDataMemberRepository repository;

    public MemberRepositoryImpl(
            SpringDataMemberRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public Member save(Member member) {

        JpaMemberEntity entity =
                new JpaMemberEntity(
                        member.getId(),
                        member.getName()
                );

        JpaMemberEntity saved =
                repository.save(entity);

        return new Member(
                saved.getId(),
                saved.getName()
        );
    }

    @Override
    public Optional<Member> findById(Long id) {

        return repository.findById(id)
                .map(entity ->
                        new Member(
                                entity.getId(),
                                entity.getName()
                        )
                );
    }

    @Override
    public List<Member> findAll() {

        return repository.findAll()
                .stream()
                .map(entity ->
                        new Member(
                                entity.getId(),
                                entity.getName()
                        )
                )
                .toList();
    }
}