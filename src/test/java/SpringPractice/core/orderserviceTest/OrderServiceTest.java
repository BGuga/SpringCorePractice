package SpringPractice.core.orderserviceTest;
import SpringPractice.core.discount.DiscountPolicy;
import SpringPractice.core.discount.RateDiscountPolicy;
import SpringPractice.core.member.Grade;
import SpringPractice.core.member.Member;
import SpringPractice.core.order.Order;
import SpringPractice.core.orderservice.OrderService;
import SpringPractice.core.orderservice.OrderServiceImpl;
import SpringPractice.core.repository.MemberRepository;
import SpringPractice.core.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OrderServiceTest {
    MemberRepository memberRepository = new MemoryMemberRepository();
    DiscountPolicy discountPolicy = new RateDiscountPolicy();
    OrderService orderService = new OrderServiceImpl(discountPolicy,memberRepository);

    @Test
    void OrderTest(){
        Member member = new Member(1L, "userA", Grade.VIP);
//        memberRepository.addMember(member);
        Optional<Order> itemA = orderService.CreateOrder(member.getId(), "itemA", 10000);
        if(itemA.isPresent()){
            System.out.println(itemA.get());
        }
        else{
            System.out.println("null is expected");
        }


    }
}
