package library.service;

import library.model.Member;
import library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member create(Member member) {
        return repository.save(member);
    }

    public Member findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Member not found"));
    }

    public List<Member> findAll() {
        return repository.findAll();
    }
}