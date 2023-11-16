package com.itwill.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Card {
	
	@Id
	private String no;
	private String name;
	private String expiry;
	private String cvc;
	
}
