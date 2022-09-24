package SpringPractice.core.repository;

import SpringPractice.core.member.Member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public Optional<Member> findMember(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void addMember(Member member) {
        store.put(member.getId(), member);
    }
}
