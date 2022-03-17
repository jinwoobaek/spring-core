package hello.springcore;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.discount.FixDiscountPolicy;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import hello.springcore.member.MemoryMemberRepository;
import hello.springcore.order.OrderService;
import hello.springcore.order.OrderServiceImpl;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 구현체 선택
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 구현체 선택
    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
