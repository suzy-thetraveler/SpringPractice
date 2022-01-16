package hello.core;

import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import hello.core.order.OrderSevice;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderSevice orderSevice(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixedDiscountPolicy());
    }


}
