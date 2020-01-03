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
public class Bill extends BaseEntity {
	@Id  
   	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int billId;
	@Column
	private int productId;
	@Column
	private int userId;
	@Column
	private int categoryId;
	@Column
	private int quantity;
	@Column
	private float totalPrice;
	@Column
	private float discount;

	
	
}
