package com.example.demo.Controllers;

import com.example.demo.Entities.BuyOrderEntity;
import com.example.demo.Models.BuyOrderModel;
import com.example.demo.services.BuyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/buyOrder")
public class BuyOrderController {

    @Autowired
    BuyOrderService buyOrderService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestHeader("Authorization") String token,@RequestBody BuyOrderModel buyOrderModel){
        return buyOrderService.add(token.substring("Bearer ".length()) , buyOrderModel);
    }

    @GetMapping("/remove")
    public boolean remove(@RequestHeader("order_id") Long order_id){
        return buyOrderService.remove(order_id);
    }

    @GetMapping("/getFormat")
    public BuyOrderEntity getFormat(){
        return new BuyOrderEntity();
    }

    @GetMapping("/fetchBuyOrdersBySID")
    public List<BuyOrderModel> fetchBuyOrdersBySID(@RequestHeader("p_id") Long p_id){
        return buyOrderService.fetchBuyOrdersBySID(p_id);
    }



}
