package Kkangh00n.Inflearn_Study.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity             //JPA가 관리하는 엔티티

//도메인 (회원)
public class Member {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 id를 알아서 생성해줌
    private Long id;
    private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
    }
}
