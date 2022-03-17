package hello.springcore.discount;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인")
    void discount_O() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 8000);

        //then
        assertThat(discount).isEqualTo(800);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용 X")
    void discount_X() {
        //given
        Member member = new Member(2L, "memberB", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 8000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}