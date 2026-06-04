package library.application.usecase;

import library.domain.model.Member;
import library.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterMemberUseCase {

    private final MemberRepository repository;

    public RegisterMemberUseCase(
            MemberRepository repository
    ) {
        this.repository = repository;
    }

    public Member execute(String name) {

        return repository.save(
                new Member(
                        null,
                        name
                )
        );
    }
}