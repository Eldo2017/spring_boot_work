package exam4;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test04_Parameter_like {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		/*
		 * TypedQuery Ŭ���� : sql���� ���� �ۼ��Ϸ��� �ϸ�(������ �´� select���� �����ڰ� �ϸ�)
		   - �Ϲ� sql���� �ƴϰ� ���Ӽ��� ��ü�� ���� ���� jpa �����̴�
		     select * => *�� ��� �Ұ� => ���̺��� ��Ī�� �־���� �Ѵ�
		 */
		
		TypedQuery<Member4> query = em.createQuery(
													"select m from Member4 m where m.name like :name order by m.name",
													Member4.class
													)
										.setParameter("name","%��%");
		
		List<Member4> ls = query.getResultList();
		
		if(ls.isEmpty()) {
			System.out.println("DB�� ȸ�� �����Ͱ� �����ϴ�.");
		} else {
			ls.forEach(user -> 
				System.out.println("|" + user.getEmail() + "|" + user.getName() + "|" + user.getCreateDate() + "|")
			);
		}
		em.close();
		emf.close();
		
	}
}
