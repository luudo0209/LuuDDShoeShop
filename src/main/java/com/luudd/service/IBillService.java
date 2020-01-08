package com.luudd.service;

import com.luudd.model.dto.BillDTO;
import com.luudd.model.request.BillRequest;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.List;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
public interface IBillService {
    public List<BillDTO> getAllBills();

    public BillDTO creatBill(BillRequest billRequest);

    public BillDTO upateBill(BillRequest billRequest, int id);

    public String deleteBill(int id);
}
