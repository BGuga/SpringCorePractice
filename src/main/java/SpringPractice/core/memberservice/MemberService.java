package SpringPractice.core.memberservice;

import SpringPractice.core.member.Member;

public interface MemberService {
    Member login(Member member);

    Member join(Member member);
}
