package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // �ش� Ŭ������ JPA�� ��ƼƼ�̴� (���̺�� ���ε� JPA)
@Table(name="JpaMember1") // ���̺���� class �̸����� ���� �ʰ� �����Ѵ�
public class Member1 {
	@Id // ���̺� pk(�⺻Ű)
	@SequenceGenerator (
		name = "mySequence1",
		sequenceName="JpaMember1_Seq", // ���� DB�� �����Ǵ� ������
		initialValue=1
	)
	@GeneratedValue(generator="mySequence1") // ������ : ���� ������ ���� ��, 50�� �����Ѵ�
	private Long id;
	private String username;
	@Column(name="create_date") // �÷����� create_date�� �����Ѵ�
	private LocalDate createDate;
	public Member1() {}
	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}
