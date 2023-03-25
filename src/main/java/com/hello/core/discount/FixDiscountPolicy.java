package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int disCountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return disCountFixAmount;
        }else{
            return 0;
        }

    }
}
