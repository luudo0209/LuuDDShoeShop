package com.luudd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class User extends BaseEntity {
	
	@Id  
   	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int userId;
	@Column
	private String userName;
	@Column
	private int userRole;
	@Column
	private String userPassword;
	@Column
	private String phoneNumber;
	
}
