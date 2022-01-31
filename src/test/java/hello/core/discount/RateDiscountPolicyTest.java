package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService= appConfig.memberService();
    OrderService orderService= appConfig.orderService();

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void vip_o(){
        //given
        Member member = new Member(1L,"suzy", Grade.VIP);

        //when
        int discountPrice = discountPolicy.discount(member,20000);

        //then
        assertThat(discountPrice).isEqualTo(2000);
    }

    @Test
    void vip_x(){
        //given
        Member member = new Member(1L,"suzy",Grade.BASIC);

        //when
        int discountPrice = discountPolicy.discount(member,20000);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }
}
