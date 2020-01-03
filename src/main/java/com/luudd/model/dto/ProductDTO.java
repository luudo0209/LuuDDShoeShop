package com.luudd.model.dto;

import lombok.Data;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
@Data
public class ProductDTO {
    private int productId;
    private int categoryId;
    private String productName;
    private String description;
    private int productImageId;
    private float price;
    private double size;
    private String genderFor;
}
