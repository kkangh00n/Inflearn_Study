package Kkangh00n.Inflearn_Study.MemberControllers;


//웹 등록 화면(createMemberForm.html)에서 데이터를 전달 받을 폼 객체
public class MemberForm {           //회원가입 폼
    private String name;
    //name은 createMemberForm.html의 name과 매칭이 됨!!!
    //스프링이 html태그에 들어온 name을
    //setter를 통해 값을 전달함

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
