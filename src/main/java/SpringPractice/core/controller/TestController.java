package SpringPractice.core.controller;

import SpringPractice.core.logger.LogService;
import SpringPractice.core.logger.Mylogger;
import SpringPractice.core.member.Grade;
import SpringPractice.core.member.Member;
import SpringPractice.core.memberservice.MemberService;
import SpringPractice.core.order.Order;
import SpringPractice.core.orderservice.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final LogService logService;
    private final Mylogger mylogger;
    private final OrderService orderService;
    private final MemberService memberService;

    @RequestMapping("test")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + mylogger.getClass());
        mylogger.setRequestURL(requestURL);
        Member member = new Member(1L, "userA", Grade.VIP);
        Member join = memberService.join(member);
        if(join==null){
            return "Login failed";
        }
        Member login = memberService.login(join);
        Optional<Order> itemA = orderService.CreateOrder(login.getId(), "itemA", 10000);

        if(!itemA.isPresent()){
            return "Order failed";
        }
        mylogger.log("controller test");
        logService.logic("test");
        return itemA.get().toString();

    }
}
