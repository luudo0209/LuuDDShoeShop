package com.luudd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Bill extends BaseEntity {
	@Id  
   	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int billId;
	@Column
	private int quantity;
	@Column
	private float totalPrice;
	@Column
	private float discount;
	@Column
	private int productId;

	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Product> products = new ArrayList<>();

	/*@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Category> categories = new ArrayList<>();*/

	
}
