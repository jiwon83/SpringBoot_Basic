package com.hello.core;

import com.hello.core.member.*;
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig config = new AppConfig();
//        MemberService memberService = config.memberService();
//        OrderService orderService = config.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); //어노테이션 기반 config
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 5000);

        System.out.println("order = " + order);
        System.out.println("order.price = " + order.calculatePrice());
    }
}
