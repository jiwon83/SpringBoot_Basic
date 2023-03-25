package com.hello.core;

import com.hello.core.member.*;
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 5000);

        System.out.println("order = " + order);
        System.out.println("order.price = " + order.calculatePrice());
    }
}
