package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test04_Delete {

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
			
			em.remove(user); // 영속성의 객체를 삭제한다
			
			em.getTransaction().commit();
			System.out.println("탈퇴 처리 완료");
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		em.close();
		emf.close();
	}

}
