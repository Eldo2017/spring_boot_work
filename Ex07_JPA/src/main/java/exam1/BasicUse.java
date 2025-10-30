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
			Member1 user = new Member1("�����",LocalDate.now());
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
