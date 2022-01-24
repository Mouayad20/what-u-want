package com.example.demo.Controllers;

import com.example.demo.Models.BuyPostModel;
import com.example.demo.Models.SalePostModel;
import com.example.demo.services.BuyPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/buyPost")
public class BuyPostController {

    @Autowired
    BuyPostService buyPostService;

    @PostMapping("/create")
    public BuyPostModel create(@RequestBody BuyPostModel buyPostModel){
        return buyPostService.create(buyPostModel);
    }

    @PutMapping("/update")
    public BuyPostModel update(@RequestBody BuyPostModel buyPostModel){
        return buyPostService.update(buyPostModel);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestHeader("o_id") Long o_id){
        return buyPostService.delete(o_id);
    }

    @GetMapping("/fetch")
    public List<BuyPostModel> fetchByType() {
        return buyPostService.fetchByType();
    }


}
