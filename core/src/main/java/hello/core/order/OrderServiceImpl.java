package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    // 이렇게 구현하면 DIP위반 why? 인터페이스인 DiscountPolicy + 구현체FixDiscountPolicy 두개에 의존
//    // 할당하는 구현체를 바꾸려고 하면 OrderServiceImpl의 코드도 수정이 필요해진다. OCP위반
//    private DiscountPolicy discountPolicy;
//    // 의존성 주입 필요 -> APP CONFIG의 등장 아래와 같이 생성자로 수정

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
