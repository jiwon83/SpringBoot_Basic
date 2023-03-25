package com.hello.core.member;

public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository = new MemoryMemberRepository(); //DIP 위반, 추상화에도 의존, 구체화에도 의존
    @Override

    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }
}
