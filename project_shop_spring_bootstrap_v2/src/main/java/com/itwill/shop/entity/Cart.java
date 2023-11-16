package com.itwill.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;


/*
이름       널?       유형            
-------- -------- ------------- 
CART_NO  NOT NULL NUMBER(10)    
USERID            VARCHAR2(100) 
P_NO              NUMBER(10)    
CART_QTY          NUMBER(10)   
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
	@Id
	@SequenceGenerator(name = "cart_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "cart_no_seq",strategy = GenerationType.SEQUENCE)
	private int no;
	private int qty;
	
	/******User************/
	@ManyToOne
	@JoinColumn(name="userid")
	@Default
	private User user=new User();//FK
	
	
	@ManyToOne
	@JoinColumn(name = "productno")
	@Default
	private Product product=new Product();//FK
	
	
	
	
	
}
