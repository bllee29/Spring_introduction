package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 직접 대입하지 않고 생성자로 할당 -> 생성자 주입]
    @Autowired // ac.getBean(MemberRepository.class)와 같이 동작?
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        // 어떤 repository가 들어갈지는 알지 못하고 인터페이스에만 의존
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
