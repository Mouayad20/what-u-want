package com.example.demo.Controllers;

import com.example.demo.Models.SaleOperationModel;
import com.example.demo.services.SaleOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/saleOperation")
public class SaleOperationController {

    @Autowired
    SaleOperationService saleOperationService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody SaleOperationModel saleOperationModel){
        return saleOperationService.create(saleOperationModel);
    }


}

/*
 @PostMapping("/createSaleOperationBySeller")
    public ResponseEntity<Object> createSaleOperationBySeller(@RequestHeader(name = "Authorization") String token){
        return saleOperationService.createSaleOperationBySeller(token.substring("Bearer ".length()));
    }

    @PostMapping("/createSaleOperationByBuyer")
    public ResponseEntity<Object> createSaleOperationByBuyer(@RequestHeader(name = "Authorization") String token){
        return saleOperationService.createSaleOperationByBuyer(token.substring("Bearer ".length()));
    }
 */

