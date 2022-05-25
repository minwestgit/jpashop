package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // CQS로 볼 때 Command에 속하므로 return값 가급적 안만들지만 id 정도만 해주는 것
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
