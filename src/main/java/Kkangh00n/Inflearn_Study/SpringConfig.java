package Kkangh00n.Inflearn_Study;


import Kkangh00n.Inflearn_Study.repository.JDBCMemberRepository;
import Kkangh00n.Inflearn_Study.repository.MemberRepository;
import Kkangh00n.Inflearn_Study.repository.MemoryMemberRepository;
import Kkangh00n.Inflearn_Study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


//의존성 주입 파일
@Configuration          //스프링 빈에 등록 -> (자바 코드로 직접 스프링 빈 등록 방식)
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean               //스프링 빈에 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        return new JDBCMemberRepository(dataSource);

    }
}
