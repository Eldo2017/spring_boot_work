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
				System.out.println("�ش� ID�� �����Ϳ� �����ϴ�");
				return;
			}
			
			user.changeName("����ö"); // Setter �޼ҵ带 �̿��Ͽ� �����ص� �������
			
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		em.close();
		emf.close();
	}
}
