package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Reply {
	@Id
	@SequenceGenerator (
		name="re",
		sequenceName="Reply_SEQ",
		allocationSize=1
	)
	@GeneratedValue(generator="re")
	private Long rno;
	
	@Column(nullable=false)
	private String content;
	
	@Column(nullable=false)
	private String writer;
	
	@Column(name="ref_bno", nullable=false)
	private Long refBno;
	
	@CreatedDate
	@Column(name="created_date")
	private LocalDateTime CreatedDate;
	
	@LastModifiedDate
	@Column(name="updated_date")
	private LocalDateTime UpdatedDate;
}
