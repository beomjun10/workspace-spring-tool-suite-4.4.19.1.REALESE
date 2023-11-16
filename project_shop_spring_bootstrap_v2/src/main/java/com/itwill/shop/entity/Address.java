package com.itwill.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	@SequenceGenerator(name = "address_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "address_no_seq",strategy = GenerationType.SEQUENCE)
	private int no;
	private String checkoutFn;
	private String checkoutIn;
	private String checkoutEmail;
	private String checkoutPhone;
	private String checkoutCompany;
	private String checkoutCountry;
	private String checkoutCity;
	private String checkoutZip;
	private String checkoutAddress1;
	private String checkoutAddress2;
	
	
}
