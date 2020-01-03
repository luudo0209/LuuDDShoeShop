package com.luudd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Product extends BaseEntity {
	@Id  
   	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int productId;
	@Column
	private int categoryId;
	@Column
	private String productName;
	@Column
	private String description;
	@Column
	private int productImageId;
	@Column
	private float price;
	@Column
	private double size;
	@Column
	private String genderFor;
	
	
	
}
