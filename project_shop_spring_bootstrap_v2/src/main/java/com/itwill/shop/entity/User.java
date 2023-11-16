package com.itwill.shop.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 =================================== 
 이름 			널? 		유형
 =================================== 
 USERID 	NOT NULL 	VARCHAR2(100) 
 PASSWORD	NOT NULL	VARCHAR2(100) 
 NAME 		NOT NULL 	VARCHAR2(200) 
 EMAIL 			 		VARCHAR2(300)
 ===================================
 */
@Entity(name = "USERINFO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@Column(name = "userid")
	private String userid;
	private String password;
	private String name;
	private String email;
	
	
	@OneToMany(mappedBy = "user")
	@Default
	private List<Order> orders=new ArrayList<>(); 
	
	
	
	public boolean isMatchPassword(String password) {
		boolean isMatch = false;
		if (this.password.equals(password)) {
			isMatch = true;
		}
		return isMatch;
	}


}
