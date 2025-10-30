package com.study.springboot.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="MEMBERJPA02")
@Builder
public class Member {
	@Id
	@SequenceGenerator(
		name = "s02",
		sequenceName="JpaMember2_SEQ",
		allocationSize=1
	)
	@GeneratedValue(generator="s02")
	private Long id;
	private String username;
	private String email;
	
	public Member(String username, String email) {
		this.username = username;
		this.email = email;
	}
}