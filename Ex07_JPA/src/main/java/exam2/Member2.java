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
		sequenceName="JpaMember2_Seq", // ���� DB�� �����Ǵ� ������
		initialValue=1,
		allocationSize=1 // 1�� �þ��
	)
	
	@GeneratedValue(generator="mySequence2") // ������ : ���� ������ ���� ��, 50�� �����Ѵ�
	private Long id;
	@Access(AccessType.FIELD) // �⺻�� : ��� ������ ���� ������ ����
	private String username;
	
	@Access(AccessType.PROPERTY) // ������Ƽ(getter/setter �޼ҵ�)�� ���� ������ ����
	private String password;
	
	@Transient
	private Long timestamp1; // ��� 1 : ������̼����� �����Ѵ�. �� �ʵ�� DB�� ���� �ʵ�ϱ� �����Ѵ�
	transient private Long timestamp2; // ��� 2 : �����ڸ� ����Ͽ� �����Ѵ�. �� �ʵ�� DB�� ���� �ʵ�ϱ� �����Ѵ�
	
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
