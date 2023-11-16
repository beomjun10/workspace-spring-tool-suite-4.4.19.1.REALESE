package com.itwill.shop.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order{
/*
	이름      널?       유형            
	------- -------- ------------- 
	O_NO    NOT NULL NUMBER(10)    
	O_DESC           VARCHAR2(100) 
	O_DATE           DATE          
	O_PRICE          NUMBER(10)    
	USERID           VARCHAR2(100) 
 */
	
	@Id
	@SequenceGenerator(name = "orders_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "orders_no_seq",strategy = GenerationType.SEQUENCE)
	private Long no;
	
	private String description;
	private LocalDate orderdate;
	private int price;
	private String shipmethod;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	@OneToOne
	@JoinColumn
	private Address address;
	@OneToOne
	@JoinColumn
	private Card card;
	
	@OneToMany(mappedBy = "order")
	@Default
	private List<Orderitem> orderItems=new ArrayList<Orderitem>();
	
	
	
	
}
