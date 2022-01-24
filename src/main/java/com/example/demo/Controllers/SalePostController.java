package com.example.demo.Controllers;

import com.example.demo.Models.SalePostModel;
import com.example.demo.services.SalePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/salePost")
public class SalePostController {

    @Autowired
    SalePostService salePostService;

    @PostMapping("/create")
    public SalePostModel create(@RequestHeader("Authorization") String token,@RequestBody  SalePostModel salePostModel) {
        return salePostService.create(token.substring("Bearer ".length()),salePostModel);
    }

    @PutMapping("/update")
    public SalePostModel update(@RequestBody SalePostModel salePostModel) {
        return salePostService.update(salePostModel);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestHeader("p_id") Long p_id) {
        return salePostService.delete(p_id);
    }

    @GetMapping("/getFormat")
    public SalePostModel getFormat() {
        return new SalePostModel();
    }

    @GetMapping("/fetchByType/t_id={t_id}")
    public List<SalePostModel> fetchByType(@PathVariable(name = "t_id") Long t_id) {
        return salePostService.fetchByType(t_id);
    }

}
