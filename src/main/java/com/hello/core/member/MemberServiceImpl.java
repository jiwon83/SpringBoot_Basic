package com.hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository; // = new MemoryMemberRepository(); //DIP 위반, 추상화에도 의존, 구체화에도 의존
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override

    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }
}
