package Kkangh00n.Inflearn_Study.repository;

import Kkangh00n.Inflearn_Study.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


//JPA를 이용한 리포지토리
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;
    //JPA는 EntityManager로 동작을 함


    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Member save(Member member) {
        em.persist(member);     //영속
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);      //조회
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
        //쿼리 생성

    }
}
