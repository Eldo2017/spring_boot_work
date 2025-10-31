package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity(name="Boardam")
public class Board {
	@Id
	
	@SequenceGenerator(
		name = "b01",
		sequenceName="Boardam_SEQ",
		allocationSize=1
	)
	@GeneratedValue(generator="b01")
	private Long bno;
	private String title;
	private String content;
	
	@ManyToOne
	@JoinColumn(name="writer")
	private Member member;
	
	
}
