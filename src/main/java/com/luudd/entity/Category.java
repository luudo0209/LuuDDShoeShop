package com.luudd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
}
