package com.luudd.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
@Data
public class ProductRequest {
    @NotNull(message = "Category is required")
    @ApiModelProperty(
            example="Duc Luu",
            notes="Category cannot be empty",
            required=true
    )
    private int categoryId;
    @NotNull
    @NotEmpty
    private String productName;
    @NotNull
    private String description;
    @NotNull
    @NotEmpty
    private int productImageId;
    @NotNull
    @NotEmpty
    private float price;
    @NotNull
    @NotEmpty
    private double size;
    @NotNull
    @NotEmpty
    private String genderFor;
}
