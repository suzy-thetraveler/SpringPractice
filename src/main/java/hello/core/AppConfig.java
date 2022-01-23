package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import hello.core.order.OrderSevice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//application 전체를 설정하고 구성한다는  뜻, application 환경구성에 관한 건 여기서 다 한다.
@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixedDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderSevice orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
