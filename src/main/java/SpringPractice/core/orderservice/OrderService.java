package SpringPractice.core.orderservice;

import SpringPractice.core.order.Order;

import java.util.Optional;

public interface OrderService {
    Optional<Order> CreateOrder(Long memberId, String itemName, int itemPrice);
}
