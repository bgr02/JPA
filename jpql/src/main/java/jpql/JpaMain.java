package jpql;

import java.util.List;

import javax.persistence.*;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Member member = new Member();
			member.setUsername("member1");
			em.persist(member);

			TypedQuery<Member> query = em.createQuery("select m from Member m ", Member.class);

			List<Member> resultList = query.getResultList();

			for (Member member1 : resultList) {
				System.out.println("member1 = " + member1);
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}
}
