package com.luudd.model.request;

import com.sun.istack.NotNull;
import lombok.Data;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
@Data
public class BillRequest {
    private @NotNull int quantity;
    private @NotNull float totalPrice;
    private @NotNull float discount;
    private @NotNull int productId;
}
