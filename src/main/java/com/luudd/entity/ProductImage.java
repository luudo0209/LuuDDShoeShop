package com.luudd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class ProductImage extends BaseEntity {
	
	@Id  
   	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int productImageId;
	@Column
	private String link;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

}
