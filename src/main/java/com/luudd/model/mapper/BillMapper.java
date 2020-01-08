package com.luudd.model.mapper;

import com.luudd.entity.Bill;
import com.luudd.model.dto.BillDTO;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
public class BillMapper {
    public static BillDTO toBillDTO(Bill bill){
        BillDTO billDTO = new BillDTO();
        billDTO.setBillId(bill.getBillId());
        billDTO.setQuantity(bill.getQuantity());
        billDTO.setDiscount(bill.getDiscount());
        billDTO.setTotalPrice(bill.getTotalPrice());
        billDTO.setProductId(bill.getProductId());
        return billDTO;
    }
}
