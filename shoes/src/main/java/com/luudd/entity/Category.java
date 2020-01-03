package com.luudd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Category extends BaseEntity {
	
	@Id  
   	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int categoryId;
	@Column
	private String categoryName;
	
}
