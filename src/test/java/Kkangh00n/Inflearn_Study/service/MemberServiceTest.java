package Kkangh00n.Inflearn_Study.service;

import Kkangh00n.Inflearn_Study.domain.Member;
import Kkangh00n.Inflearn_Study.repository.MemoryMemberRepository;
import Kkangh00n.Inflearn_Study.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach             //Test를 실행하기 전 실행되는 메소드
    public void beforeEach(){           //DI
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach              //Test를 한번 할때마다 실행되는 메소드
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //Given
        Member member = new Member();
        member.setName("hello");

        //When
        Long saveId = memberService.join(member);

        //Then
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());

    }

    @Test
    public void 중복_회원_예외() throws Exception {

        //Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원이다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}