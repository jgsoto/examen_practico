package library.application;

import library.domain.model.Member;
import library.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMembersUseCase {

    private final MemberRepository repository;

    public GetMembersUseCase(
            MemberRepository repository
    ) {
        this.repository = repository;
    }

    public List<Member> execute() {
        return repository.findAll();
    }
}