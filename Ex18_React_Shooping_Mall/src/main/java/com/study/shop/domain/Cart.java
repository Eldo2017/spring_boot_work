
package com.study.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Cart {
	@Id
	@SequenceGenerator (
		name = "cartSeq",
		sequenceName = "cart_seq",
		allocationSize = 1
	)
	@GeneratedValue(generator="cartSeq")
	private Long cartid;
	
	private Long id;
	private String title;
	private Long count;
	private String memId;
}
