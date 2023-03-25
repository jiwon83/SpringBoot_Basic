package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private OrderService orderService = new OrderServiceImpl();
    private MemberService memberService = new MemberServiceImpl();
//    private MemoryMemberRepository fakeRepository = new MemoryMemberRepository();
    private void join_in_test(Long memberId, String memberName, Grade grade){
        Member member = new Member(memberId, memberName, grade);
        memberService.join(member);
    }

    @Test
    public void test_create_order_VIP(){
        //given : 회원 가입, order생성 VIP로 회원 가입. distCount액은 1000원을 return
//        fakeRepository.save(new Member(2L,"name", Grade.VIP));
        Long memberId = 1L;
        join_in_test(memberId, "memberA", Grade.VIP);
        //when :vip일때
        Order order = orderService.createOrder(memberId, "itemA", 5000);

        //then : 1000원 할인된 가격 return
        Assertions.assertEquals(1000, order.getDisCountPrice());

    }
    @Test
    public void test_create_order_notVIP(){
        //given
//        fakeRepository.save(new Member(1L,"name", Grade.BASIC));
        Long memberId = 1L;
        join_in_test(memberId, "memberA", Grade.BASIC);
        //when
        Order order = orderService.createOrder(1L,"apple",10000);
        //then
        Assertions.assertEquals(0, order.getDisCountPrice());

    }
}
