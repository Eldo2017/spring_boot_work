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
		 * 검색 시 find() 메소드를 사용하라
		   - Dread9016을 찾아 Member3에 담아 가져온다
		     > 아무것도 지정하지 않는다면 @Id가 붙은 기본키를 이용해 검색해서 가져오게 된다
		 */
		Member3 user = em.find(Member3.class, "Dread9016");
		System.out.println(user);
		// select * from JpaMember3 where email = 'Dread9016'
		em.persist(user);
		
		if(user != null) {
			System.out.println("이름: " + user.getName());
			/*
			   't' or 'T' : 날짜 or 시간(날짜나 시간 서식문자 앞에 지정한다)
			   'Y' : 연도를 의미(4자리)
			   'y' : 연도를 의미(2자리)
			   'm' : 월(01~12)
			   'd' : 일(01~31)
			   'e' : 일(1~31)
			   'H' : 24시간 형식의 시간(00~23, 24 = 0)
			   'I' : 12시간 형식의 시간(01~12)
			   'M' : 분(00~59)
			   'S' : 초(00~59)
			   
			   %<로 상대 인덱스 지정해 직전의 인수와 같은 인덱스를 사용할 수가 있다
			 */
			System.out.printf("생성일: %tY/%<tm/%<td", user.getCreateDate());
		} else {
			System.out.println("ID가 존재하지 않습니다");
		}
		
		em.close();
		emf.close();
	}
}
