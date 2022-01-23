package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderServiceImpl;
import hello.core.order.OrderSevice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = appConfig.memberService();
//        OrderSevice orderSevice = appConfig.orderSevice();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderSevice orderService = applicationContext.getBean("orderService", OrderSevice.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "suzy", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Oblong", 119000);

        System.out.println("order = " + order);
        System.out.println("order.calculatedPrice() = " + order.calculatedPrice());

    }
}
