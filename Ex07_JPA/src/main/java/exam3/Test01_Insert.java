package exam3;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test01_Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ets = em.getTransaction();
		
		try {
			ets.begin();
			Member3 user = new Member3("Dread9016","�蹫��",LocalDate.now());
			System.out.println(111);
			// .persist : ���Ӽ����� ��ü�� �����͸� �Է��Ѵ�(�޸𸮿� insert���ִ� ����)
			em.persist(user);
			
			System.out.println(222);
			
			ets.commit();
			System.out.println(333);
			System.out.println("���� ��û ó�� �Ϸ�");
		} catch(Exception e) {
			e.printStackTrace();
			ets.rollback();
		}
		em.close();
		emf.close();
	}

}
