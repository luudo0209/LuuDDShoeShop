package com.luudd.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Product extends BaseEntity {
	@Id  
   	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int productId;
	@Column
	private String productName;
	@Column
	private String description;
	@Column
	private float price;
	@Column
	private double size;
	@Column
	private String genderFor;
//	@Column
//	private int categoryId;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "product")
	private List<ProductImage> productImages ;
}
