package com.study.shop.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name="reactmember")
public class Member {
	@Id
	private String email;
	@NonNull
	private String password;
	@NonNull
	private String name;
	
//	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;
	
	private String gender;
	private String phone;
	private String address;
	
	@Column(name="detail_address")
	private String detailAddress;
}