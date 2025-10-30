package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test03_Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Member3 user = em.find(Member3.class, "Dread9016");
	
			if(user == null) {
				System.out.println("해당 ID가 데이터에 없습니다");
				return;
			}
			
			user.changeName("문영철"); // Setter 메소드를 이용하여 구현해도 상관없다
			
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		em.close();
		emf.close();
	}
}
