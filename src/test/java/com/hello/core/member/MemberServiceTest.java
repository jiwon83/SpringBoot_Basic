package com.hello.core.member;

import com.hello.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig config = new AppConfig();
        memberService = config.memberService();
    }
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
