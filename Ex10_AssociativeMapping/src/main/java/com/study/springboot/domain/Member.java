package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="MEMBERJPA03")
@EntityListeners(AuditingEntityListener.class)

public class Member {
	@Id	
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String passwd;
	
	// 생성 시간, 수정 시간을 기록하는 필드
	@CreatedDate
	@Column(name="create_at")
	private LocalDateTime createAt;
	
	@LastModifiedDate
	@Column(name="update_at")
	private LocalDateTime updateAt;
}