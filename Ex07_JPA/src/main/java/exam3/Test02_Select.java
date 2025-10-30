package exam3;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test02_Select {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
			
		/*
		 * �˻� �� find() �޼ҵ带 ����϶�
		   - Dread9016�� ã�� Member3�� ��� �����´�
		     > �ƹ��͵� �������� �ʴ´ٸ� @Id�� ���� �⺻Ű�� �̿��� �˻��ؼ� �������� �ȴ�
		 */
		Member3 user = em.find(Member3.class, "Dread9016");
		System.out.println(user);
		// select * from JpaMember3 where email = 'Dread9016'
		em.persist(user);
		
		if(user != null) {
			System.out.println("�̸�: " + user.getName());
			/*
			   't' or 'T' : ��¥ or �ð�(��¥�� �ð� ���Ĺ��� �տ� �����Ѵ�)
			   'Y' : ������ �ǹ�(4�ڸ�)
			   'y' : ������ �ǹ�(2�ڸ�)
			   'm' : ��(01~12)
			   'd' : ��(01~31)
			   'e' : ��(1~31)
			   'H' : 24�ð� ������ �ð�(00~23, 24 = 0)
			   'I' : 12�ð� ������ �ð�(01~12)
			   'M' : ��(00~59)
			   'S' : ��(00~59)
			   
			   %<�� ��� �ε��� ������ ������ �μ��� ���� �ε����� ����� ���� �ִ�
			 */
			System.out.printf("������: %tY/%<tm/%<td", user.getCreateDate());
		} else {
			System.out.println("ID�� �������� �ʽ��ϴ�");
		}
		
		em.close();
		emf.close();
	}
}
