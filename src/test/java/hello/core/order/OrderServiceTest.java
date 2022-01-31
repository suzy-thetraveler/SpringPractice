package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    AppConfig appConfig =new AppConfig();
    OrderService orderService = appConfig.orderService();
    MemberService memberService = appConfig.memberService();

    @Test
    void createOrder(){
        //given
        Member member = new Member(1L,"suzy", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(1L,"oblong",10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
