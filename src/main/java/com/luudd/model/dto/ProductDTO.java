package com.luudd.model.dto;

import com.luudd.entity.Category;
import com.luudd.entity.ProductImage;
import lombok.Data;

import java.util.List;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
@Data
public class ProductDTO {
    private int productId;
    private Category category;
    private String productName;
    private String description;
    private String productImage;
    private float price;
    private double size;
    private String genderFor;
}
