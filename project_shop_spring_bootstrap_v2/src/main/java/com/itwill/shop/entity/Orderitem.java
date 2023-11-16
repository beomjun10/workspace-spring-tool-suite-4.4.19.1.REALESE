package com.itwill.shop.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orderitem {
	/*
	이름     널?       유형         
	------ -------- ---------- 
	OI_NO  NOT NULL NUMBER(10) 
	OI_QTY          NUMBER(10) 
	O_NO            NUMBER(10) 
	P_NO            NUMBER(10)
	 */
	@Id
	@SequenceGenerator(name = "orderitem_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "orderitem_no_seq",strategy = GenerationType.SEQUENCE)
	private Long no;
	
	private int qty;
	
	@ManyToOne
	@JoinColumn(name="orderno")
	@Default
	private Order order=new Order();
	
	@ManyToOne
	@JoinColumn(name="productno",unique = false)
	@Default
	private Product product =new Product();
	
}
