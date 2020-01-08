package com.luudd.model.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
@Data
public class BillDTO {
    private int billId;
    private int quantity;
    private float totalPrice;
    private float discount;
    private int productId;
}
