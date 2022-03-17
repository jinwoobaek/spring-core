package hello.springcore.order;

import hello.springcore.AppConfig;
import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        //given
        Member memberVip = new Member(1L, "memberVip", Grade.VIP);
        Member memberBasic = new Member(2L, "memberBasic", Grade.BASIC);
        memberService.join(memberVip);
        memberService.join(memberBasic);

        //when
        Order orderByVip = orderService.createOrder(1L, "MacBook", 8000);
        Order orderByBasic = orderService.createOrder(2L, "MacBook", 8000);

        //then
        Assertions.assertThat(orderByVip.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(orderByBasic.getDiscountPrice()).isEqualTo(0);
        Assertions.assertThat(orderByVip.getItemPrice()).isEqualTo(8000);

    }
}