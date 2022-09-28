package Kkangh00n.Inflearn_Study.repository;

import Kkangh00n.Inflearn_Study.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//테스트 케이스 작성 : 잘 작동되는지 검증 -> JUnit을 통해
//test/java/Kkangh00n.../MemmoryMemberRepositoryTest

//테스트 케이스를 먼저 작성 -> 그다음 개발
//테스트 주도 개발!!


//@Repository             //스프링 빈에 등록 -> 자동으로 생성자 호출 (컴포넌트 스캔방식 -> 어노테이션 안에 @Component 등록되어있음)
//리포지토리 (도메인 객체를 관리하는 db역할)
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
    //얘는 왜 있을까??
    //Test 클래스 돌릴 때, 깔끔하게 지워줘야 됨
}
