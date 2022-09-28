package Kkangh00n.Inflearn_Study.MemberControllers;

import Kkangh00n.Inflearn_Study.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import Kkangh00n.Inflearn_Study.service.MemberService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller             //스프링 빈에 등록 -> 자동으로 생성자 호출 (컴포넌트 스캔방식 -> 어노테이션 안에 @Component 등록되어있음)
public class MemberController {
    private final MemberService memberService;

    @Autowired                  //의존관계 주입(memberservice를 membercontroller에 주입)
    //Autowired를 통해서 스프링 빈에 등록되어있는 memberService를 생성자에 등록시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    //의존성 주입 방식
    //1. 필드주입
    //2. 생성자주입 (권장)
    //3. setter주입

    
    
    //회원 가입
    
    @GetMapping(value = "/members/new")         //members/new url로 이동하고 첫 화면
    public String createForm() {
        // 빈칸에 이름을 적고 등록하면, MemberForm의 name에 이름이 등록 -> 34행
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")        
    //createMemberForm.html에서 액션이 취해지면 post방식으로 메소드를 호출
    //그때 @PostMapping어노테이션 메소드 호출함
    public String create(MemberForm form) {     //MemberForm의 정보를 매개로 받아들임
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
    
    
    //회원 목록 조회

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
    
}
