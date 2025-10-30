package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // 해당 클래스가 JPA의 엔티티이다 (테이블과 매핑된 JPA)
@Table(name="JpaMember1") // 테이블명을 class 이름으로 하지 않고 지정한다
public class Member1 {
	@Id // 테이블 pk(기본키)
	@SequenceGenerator (
		name = "mySequence1",
		sequenceName="JpaMember1_Seq", // 실제 DB에 생성되는 시퀀스
		initialValue=1
	)
	@GeneratedValue(generator="mySequence1") // 시퀀스 : 별도 설정이 없을 시, 50씩 증가한다
	private Long id;
	private String username;
	@Column(name="create_date") // 컬럼명을 create_date로 지정한다
	private LocalDate createDate;
	public Member1() {}
	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}
