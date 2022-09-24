package SpringPractice.core.discount;

import SpringPractice.core.member.Grade;
import SpringPractice.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountTest {

    @Test
    @DisplayName("FixDiscount")
    void Fixdiscount(){
        Member member1 = new Member(1L, "userA", Grade.VIP);
        Member member2 = new Member(2L, "userB", Grade.BASIC);
        DiscountPolicy discountPolicy = new FixDiscountPolicy();
        int discount1 = discountPolicy.discount(member1, 10000);
        int discount2 = discountPolicy.discount(member2, 10000);

        assertThat(discount1).isEqualTo(1000);
        assertThat(discount2).isEqualTo(0);

    }

    @Test
    @DisplayName("RateDiscount")
    void Ratediscount(){
        Member member1 = new Member(1L, "userA", Grade.VIP);
        Member member2 = new Member(2L, "userB", Grade.BASIC);
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        int discount1 = discountPolicy.discount(member1, 20000);
        int discount2 = discountPolicy.discount(member2, 10000);

        assertThat(discount1).isEqualTo(2000);
        assertThat(discount2).isEqualTo(0);

    }
}
