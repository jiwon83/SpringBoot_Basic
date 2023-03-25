package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //member를 찾고
        Member member = memberRepository.findById(memberId);
        //discountPolicy적용
        int discountPrice = discountPolicy.discount(member, itemPrice); //SRP가 잘 된 것.

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
