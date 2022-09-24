package SpringPractice.core.discount;

import SpringPractice.core.member.Grade;
import SpringPractice.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade()== Grade.VIP){
            return price/10;
        }
        else return 0;
    }
}
