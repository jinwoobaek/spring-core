package hello.springcore.discount;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { // ENUM 타입은 == 으로 비교하는게 맞음
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
