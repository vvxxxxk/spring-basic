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
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        // given
        Member vipMember = new Member(1L, "memberA", Grade.VIP);
        Member basicMember = new Member(2L, "memberB", Grade.BASIC);
        memberService.join(vipMember);
        memberService.join(basicMember);

        // when
        Order vipOrder = orderService.createOrder(vipMember.getId(), "itemA", 10000);
        Order basicOrder = orderService.createOrder(basicMember.getId(), "itemA", 10000);

        // then
        Assertions.assertThat(vipOrder.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(basicOrder.getDiscountPrice()).isEqualTo(0);
        System.out.println(vipOrder);
        System.out.println(basicOrder);
    }
}
