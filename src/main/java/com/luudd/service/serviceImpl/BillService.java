package com.luudd.service.serviceImpl;

import com.luudd.entity.Bill;
import com.luudd.model.dto.BillDTO;
import com.luudd.model.mapper.BillMapper;
import com.luudd.model.request.BillRequest;
import com.luudd.repository.IBillRepository;
import com.luudd.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */

@Service
public class BillService implements IBillService {

    @Autowired
    private IBillRepository billRepository;

    @Override
    public List<BillDTO> getAllBills() {
        try {
            List<Bill> billList = billRepository.findAll();
            List<BillDTO> billDTOList = new ArrayList<>();
            if ( billList != null ) {
                for ( Bill bill : billList) {
                    billDTOList.add(BillMapper.toBillDTO(bill));
                }
                return billDTOList;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    @Transactional
    @Override
    public BillDTO creatBill(BillRequest billRequest) {
        try {
            Bill bill = new Bill();
            Date date = new Date();
            if ( billRequest != null ) {
                bill.setProductId(billRequest.getProductId());
                bill.setQuantity(billRequest.getQuantity());
                bill.setTotalPrice(billRequest.getTotalPrice());
                bill.setDiscount(billRequest.getDiscount());
                bill.setCreatedAt(date);
                bill.setCreatedBy("Luudd");
                bill.setUpdatedAt(date);
                bill.setUpdatedBy("Luudd");
                billRepository.save(bill);
                return  BillMapper.toBillDTO(bill);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
    @Transactional
    @Override
    public BillDTO upateBill(BillRequest billRequest, int id) {
        try {
            List<Bill> billList = billRepository.findAll();
            Date date = new Date();
            if ( billRequest != null ) {
                for ( Bill bill : billList ) {
                    if ( bill.getBillId() == id ) {
                        bill.setProductId(billRequest.getProductId());
                        bill.setQuantity(billRequest.getQuantity());
                        bill.setTotalPrice(billRequest.getTotalPrice());
                        bill.setDiscount(billRequest.getDiscount());
                        bill.setUpdatedAt(date);
                        bill.setUpdatedBy("Luudd");
                        billRepository.save(bill);
                        return BillMapper.toBillDTO(bill);
                    }
                }
            }
        } catch ( Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    @Override
    public String deleteBill(int id) {
        if (id >= 0){
            billRepository.deleteById(id);
            return "Success";
        }
        return "Unsuccess";
    }
}
