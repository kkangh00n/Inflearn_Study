package Kkangh00n.Inflearn_Study;


import Kkangh00n.Inflearn_Study.repository.*;
import Kkangh00n.Inflearn_Study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


//의존성 주입 파일
@Configuration          //스프링 빈에 등록 -> (자바 코드로 직접 스프링 빈 등록 방식)
public class SpringConfig {

    //private DataSource dataSource;        //JDBC Template을 위함

    /*@Autowired
    //public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    /*private EntityManager em;               //JPAf를 위함

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean               //스프링 빈에 등록
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JDBCMemberRepository(dataSource);

        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);

    }

     */
}
