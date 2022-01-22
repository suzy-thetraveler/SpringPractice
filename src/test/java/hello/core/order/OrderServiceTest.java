package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderSevice orderSevice;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderSevice = appConfig.orderSevice();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "suzy", Grade.VIP);
        memberService.join(member);

        Order order = orderSevice.createOrder(memberId, "OblongBag", 119000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
