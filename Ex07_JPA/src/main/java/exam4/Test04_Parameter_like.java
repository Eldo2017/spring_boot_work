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
		 * TypedQuery 클래스 : sql문을 직접 작성하려고 하면(나에게 맞는 select문을 만들자고 하면)
		   - 일반 sql문이 아니고 영속성의 객체에 넣을 구문 jpa 문법이다
		     select * => *는 사용 불가 => 테이블의 별칭을 넣어줘야 한다
		 */
		
		TypedQuery<Member4> query = em.createQuery(
													"select m from Member4 m where m.name like :name order by m.name",
													Member4.class
													)
										.setParameter("name","%영%");
		
		List<Member4> ls = query.getResultList();
		
		if(ls.isEmpty()) {
			System.out.println("DB에 회원 데이터가 없습니다.");
		} else {
			ls.forEach(user -> 
				System.out.println("|" + user.getEmail() + "|" + user.getName() + "|" + user.getCreateDate() + "|")
			);
		}
		em.close();
		emf.close();
		
	}
}
