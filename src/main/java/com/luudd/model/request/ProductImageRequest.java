package com.luudd.model.request;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
@Data
public class ProductImageRequest {
    private @NotNull @NotEmpty String link;
    private @NotNull int productId;
}
