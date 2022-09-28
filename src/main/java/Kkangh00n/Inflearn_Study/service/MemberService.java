package Kkangh00n.Inflearn_Study.service;

import Kkangh00n.Inflearn_Study.domain.Member;
import Kkangh00n.Inflearn_Study.repository.MemberRepository;
import Kkangh00n.Inflearn_Study.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//@Service            //스프링 빈에 등록 -> 자동으로 생성자 호출 (컴포넌트 스캔방식 -> 어노테이션 안에 @Component 등록되어있음)
//서비스 (비즈니스 로직 구현)
public class MemberService {       //Test를 만들고싶으면?? ctrl + shift + t
    private final MemberRepository memberRepository;

    @Autowired                  //의존관계 주입(memberRepository를 memberservice에 주입)
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    
    //회원가입
    public Long join(Member member) {

        validateDuplicateMember(member);
        //ctrl + alt + m을 통해 로직(메소드)으로 뽑아냄
        //리포지토리에 가입을 원하는 member의 이름이 있다면, "이미 존재합니다" 출력

        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원이다.");});
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //ID를 이용해 회원 검색
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
