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
			Member3 user = new Member3("Dread9016","김무옥",LocalDate.now());
			System.out.println(111);
			// .persist : 영속성으로 객체에 데이터를 입력한다(메모리에 insert해주는 역할)
			em.persist(user);
			
			System.out.println(222);
			
			ets.commit();
			System.out.println(333);
			System.out.println("가입 요청 처리 완료");
		} catch(Exception e) {
			e.printStackTrace();
			ets.rollback();
		}
		em.close();
		emf.close();
	}

}
