package exam2;

import java.time.LocalDate;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="JpaMember2")
public class Member2 {
	@Id
	
	@SequenceGenerator (
		name = "mySequence2",
		sequenceName="JpaMember2_Seq", // 실제 DB에 생성되는 시퀀스
		initialValue=1,
		allocationSize=1 // 1씩 늘어난다
	)
	
	@GeneratedValue(generator="mySequence2") // 시퀀스 : 별도 설정이 없을 시, 50씩 증가한다
	private Long id;
	@Access(AccessType.FIELD) // 기본값 : 멤버 변수를 통해 데이터 접근
	private String username;
	
	@Access(AccessType.PROPERTY) // 프로퍼티(getter/setter 메소드)를 통해 데이터 접근
	private String password;
	
	@Transient
	private Long timestamp1; // 방법 1 : 어노테이션으로 제외한다. 이 필드는 DB에 없는 필드니까 제외한다
	transient private Long timestamp2; // 방법 2 : 지시자를 사용하여 제외한다. 이 필드는 DB에 없는 필드니까 제외한다
	
	public Member2() {}
	
	public Member2(String username, String password) {
		this.username=username;
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
