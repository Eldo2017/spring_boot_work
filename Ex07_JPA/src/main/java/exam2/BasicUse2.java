package exam2;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BasicUse2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ets = em.getTransaction();
		
		try {
			ets.begin();
			Member2 user = new Member2("�����","Glare9524");
			// .persist : ���Ӽ����� ��ü�� �����͸� �Է��Ѵ�(�޸𸮿� insert���ִ� ����)
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
