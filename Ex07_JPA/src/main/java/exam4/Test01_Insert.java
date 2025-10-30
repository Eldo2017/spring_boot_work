package exam4;

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
			Member4 user;
			user = new Member4("Demons3620@naver.com","�����",LocalDate.now());
			em.persist(user);
			user = new Member4("Vail9915@naver.com","������",LocalDate.now());
			em.persist(user);
			user = new Member4("Destream1623@naver.com","��ȭ��",LocalDate.now());
			em.persist(user);
			user = new Member4("Glare6237@naver.com","�蹫��",LocalDate.now());
			em.persist(user);
			user = new Member4("Gazer8255@naver.com","����ö",LocalDate.now());
			em.persist(user);
			user = new Member4("Glare2@naver.com","�̰���",LocalDate.now());
			em.persist(user);
			user = new Member4("Regad2259@naver.com","�ſ���",LocalDate.now());
			em.persist(user);
			user = new Member4("RegadOmega16@naver.com","ȫ����",LocalDate.now());
			em.persist(user);
			user = new Member4("Dread3645@naver.com","�����",LocalDate.now());
			em.persist(user);
			user = new Member4("Eldo8845@naver.com","����",LocalDate.now());
			em.persist(user);
			
			ets.commit();
			System.out.println("���� ��û ó�� �Ϸ�");
		} catch(Exception e) {
			e.printStackTrace();
			ets.rollback();
		}
		em.close();
		emf.close();
	}

}
