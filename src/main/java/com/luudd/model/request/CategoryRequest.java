package com.luudd.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Do Duc Luu on 1/5/2020.
 */
@Data
public class CategoryRequest {
    private @NotNull @NotEmpty String categoryName;
}
