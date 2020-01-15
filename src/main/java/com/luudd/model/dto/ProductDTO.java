package com.luudd.model.dto;

import com.luudd.entity.Category;
import com.luudd.entity.ProductImage;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
@Data
public class ProductDTO {
    private int productId;
    private String productName;
    private String description;
    private float price;
    private double size;
    private String genderFor;
    private int category_id;
    private String image;
}
