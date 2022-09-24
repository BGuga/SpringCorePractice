package SpringPractice.core.memberservice;

import SpringPractice.core.member.Member;
import SpringPractice.core.repository.MemberRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member login(Member member) {
        Optional<Member> member1 = memberRepository.findMember(member.getId());
        return member1.orElse(null);
    }

    @Override
    public Member join(Member member) {
        Optional<Member> member1 = memberRepository.findMember(member.getId());
        if(!member1.isPresent()){
            memberRepository.addMember(member);
            return member;
        } else {
            return null;
        }
    }

}
