package SpringPractice.core.discount;

import SpringPractice.core.member.Grade;
import SpringPractice.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade()== Grade.VIP){
            return price/10;
        }
        else return 0;
    }
}
