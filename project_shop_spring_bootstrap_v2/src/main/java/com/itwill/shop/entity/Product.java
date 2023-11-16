package com.itwill.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	@SequenceGenerator(name = "product_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "product_no_seq",strategy = GenerationType.SEQUENCE)
	private Long no;
	private String name;
	private int price;
	private String image;
	private String description;
	private int clickcount;

}
