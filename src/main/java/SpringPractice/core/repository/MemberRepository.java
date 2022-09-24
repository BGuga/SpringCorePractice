package SpringPractice.core.repository;

import SpringPractice.core.member.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findMember(Long id);

    void addMember(Member member);
}
