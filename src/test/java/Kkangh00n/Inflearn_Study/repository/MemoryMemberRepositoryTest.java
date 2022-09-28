package Kkangh00n.Inflearn_Study.repository;

import Kkangh00n.Inflearn_Study.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @Test           //Test 어노테이션!!
    public void save() {

        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //get을 하면 optional을 벗겨서 값을 꺼냄
        
        assertThat(member).isEqualTo(result);
        // member = 기댓값, result = db에서 출력해온 실제 출력값
        // 이 두값이 같은지 확인!!

    }
    @Test
    public void findByName() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2); 
        //출력한 리스트의 사이즈가 2개인지 확인
    }

    @AfterEach              //Test를 한번 할때마다 실행되는 메소드
    public void afterEach() {
        repository.clearStore();
        //repository를 clear 시킴
        //왜?? -> 클래스를 전체 test하면 test가 끝날때마다 데이터가 지워지지않고 남아있어서
        //test결과에 이상이 생김
    }
    
}
