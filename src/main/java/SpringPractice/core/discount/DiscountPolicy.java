package SpringPractice.core.discount;

import SpringPractice.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
