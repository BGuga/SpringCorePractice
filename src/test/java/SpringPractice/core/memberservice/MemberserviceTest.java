package SpringPractice.core.memberservice;

import SpringPractice.core.member.Grade;
import SpringPractice.core.member.Member;
import SpringPractice.core.repository.MemberRepository;
import SpringPractice.core.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberserviceTest {

    MemberRepository memberRepository;
    MemberService memberService;
    @BeforeEach
    void makeRepositoryEmpty(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(memberRepository);
    }

    @Test
    void LoginserviceTest(){
        Member member = new Member(1L, "userA", Grade.VIP);
        memberRepository.addMember(member);
        Member member1 = new Member(2L, "userB", Grade.VIP);
        Member login = memberService.login(member1);
        assertThat(login).isEqualTo(null);
    }

    @Test
    void JoinserviceTest(){
        Member member = new Member(1L, "userA", Grade.VIP);
        Member join = memberService.join(member);
        assertThat(join).isEqualTo(member);
        Member member2 = new Member(1L, "userA", Grade.VIP);
        Member join2 = memberService.join(member2);
        assertThat(join2).isEqualTo(null);
    }
}
