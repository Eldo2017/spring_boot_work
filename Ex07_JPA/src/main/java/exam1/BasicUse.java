package exam1;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BasicUse {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ets = em.getTransaction();
		
		try {
			ets.begin();
			Member1 user = new Member1("김두한",LocalDate.now());
			// .persist : 영속성으로 객체에 데이터를 입력한다(메모리에 insert해주는 역할)
			em.persist(user);
			
			ets.commit();
		} catch(Exception e) {
			e.printStackTrace();
			ets.rollback();
		}
		em.close();
		emf.close();
	}

}
