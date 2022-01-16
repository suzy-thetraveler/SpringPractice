package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderServiceImpl;
import hello.core.order.OrderSevice;

public class OrderApp {
    public static void main(String[] args) {
        OrderSevice orderSevice = new OrderServiceImpl(memberRepository, discountPolicy);
        MemberService memberService = new MemberServiceImpl(memberRepository);

        Long memberId = 1L;
        Member member = new Member(memberId, "suzy", Grade.VIP);
        memberService.join(member);

        Order order = orderSevice.createOrder(memberId, "Oblong", 119000);

        System.out.println("order = " + order);
        System.out.println("order.calculatedPrice() = " + order.calculatedPrice());

    }
}
