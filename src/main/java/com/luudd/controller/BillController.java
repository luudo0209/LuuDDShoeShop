package com.luudd.controller;

import com.luudd.model.dto.BillDTO;
import com.luudd.model.dto.CategoryDTO;
import com.luudd.model.mapper.BillMapper;
import com.luudd.model.request.BillRequest;
import com.luudd.model.request.CategoryRequest;
import com.luudd.repository.IBillRepository;
import com.luudd.service.serviceImpl.BillService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
@CrossOrigin
@RestController
public class BillController {

    @Autowired
    private BillService billService;

    // Create bill
    @ApiOperation(value="Create bill", response = BillDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("/api/bill")
    public ResponseEntity<?> createBill (@RequestBody BillRequest billRequest){
        return ResponseEntity.ok(billService.creatBill(billRequest));
    }

    // Update bill
    @ApiOperation(value="Update bill", response = BillDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PutMapping("/api/bill/{id}")
    public ResponseEntity<?> updateBill (@RequestBody BillRequest billRequest, int id){
        return ResponseEntity.ok(billService.upateBill(billRequest, id));
    }

    // Get all bills
    @ApiOperation(value="Get all bills", response = BillDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/api/bill")
    public ResponseEntity<?> getAllBills (){
        return ResponseEntity.ok(billService.getAllBills());
    }
    // Delete bill
    @ApiOperation(value="Delete bill", response = BillDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @DeleteMapping("/api/bill/{id}")
    public ResponseEntity<?> deleteBill (@PathVariable int id){
        return ResponseEntity.ok(billService.deleteBill(id));
    }
}
