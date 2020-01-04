package com.luudd.model.request;

import com.luudd.entity.Category;
import com.luudd.entity.ProductImage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
@Data
public class ProductRequest {
    @ApiModelProperty(
            example="Duc Luu",
            notes="Category cannot be empty",
            required=true
    )
    private @NotNull(message = "Category is required") Category category;
    private @NotNull @NotEmpty String productName;
    private @NotNull String description;
    private @NotNull @NotEmpty String productImage;
    private  @NotNull float price;
    private @NotNull double size;
    private @NotNull @NotEmpty String genderFor;
}
