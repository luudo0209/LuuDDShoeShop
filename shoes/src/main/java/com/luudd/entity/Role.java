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
	private int roleName;
	
	/*
	 * private List<User> users = new ArrayList<>();
	 * 
	 * public List<User> getUsers() { return users; }
	 * 
	 * @ManyToMany(mappedBy = "roles") public void setUsers(List<User> users) {
	 * this.users = users; }
	 */
	public int getRoleName() {
		return roleName;
	}

	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}


	public int getRoleId() {
		return roleId;
	}
	
	
}
