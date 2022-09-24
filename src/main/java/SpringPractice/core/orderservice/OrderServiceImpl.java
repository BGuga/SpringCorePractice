package SpringPractice.core.orderservice;

import SpringPractice.core.discount.DiscountPolicy;
import SpringPractice.core.member.Member;
import SpringPractice.core.order.Order;
import SpringPractice.core.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderServiceImpl implements OrderService{
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Optional<Order> CreateOrder(Long memberId, String itemName, int itemPrice) {
        Optional<Member> member = memberRepository.findMember(memberId);
        if(member.isPresent()){
            int discount = discountPolicy.discount(member.get(), itemPrice);
            Order order = new Order(memberId, itemName, itemPrice, discount);
            return Optional.of(order);
        } else return Optional.ofNullable(null);
    }
}
