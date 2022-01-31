package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService= appConfig.memberService();

    @Test
    void join(){
        //given
        Member member = new Member(1L,"suzy",Grade.BASIC);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);

    }
}
