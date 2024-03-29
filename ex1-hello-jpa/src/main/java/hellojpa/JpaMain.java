package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
//			Member member = new Member();
//			member.setId(2L);
//			member.setName("HelloB");
			
//			Member findMember = em.find(Member.class, 1L);
//			findMember.setName("HelloJPA");
			
			List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
			
			for(Member m : result) {
				System.out.println(m);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}
}
