package com.luudd.entity;

import lombok.Data;
import javax.persistence.*;

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
    private String productImage;
	/*@Column
	private  String image;*/
	@Column
	private float price;
	@Column
	private double size;
	@Column
	private String genderFor;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

}
