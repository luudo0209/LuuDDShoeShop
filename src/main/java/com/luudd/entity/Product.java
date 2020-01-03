package com.luudd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductImage> productimages = new ArrayList<>();
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
