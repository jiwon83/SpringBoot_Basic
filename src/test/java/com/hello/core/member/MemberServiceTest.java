package com.hello.core.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    public void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        assertEquals("memberA",findMember.getName());
    }
}
