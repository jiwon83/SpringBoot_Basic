package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인된 금액을 적용")
    public void vip_O() {
        //given
        Member member = new Member(1L, "nameA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 1000);
        //then
        assertThat(discount).isEqualTo(100);
    }

    @Test
    @DisplayName("VIP가 아닌 경우 ")
    public void vip_X() {
        //given
        Member member = new Member(1L, "nameA", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 1000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}