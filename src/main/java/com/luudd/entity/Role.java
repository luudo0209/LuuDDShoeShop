package com.luudd.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Role extends BaseEntity{
	
	@Id  
   	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int roleId;
	@Column
	private String roleName;

//	@ManyToMany(mappedBy = "roles")
//	private List<User> users = new ArrayList<>();
	
	
}
