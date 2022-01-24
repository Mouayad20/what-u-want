package com.example.demo.Controllers;

import com.example.demo.Models.TypeModel;
import com.example.demo.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/getFormat")
    public TypeModel getFormat(){
        return new TypeModel();
    }


    @PostMapping("/addType")
    public ResponseEntity<Object> addType(@RequestBody TypeModel typeModel){
        return typeService.addType(typeModel);
    }

    @GetMapping("/fetchAllTypes")
    public List<TypeModel> fetchAllTypes(){
        return typeService.fetchAllTypes();
    }

}
/*
@GetMapping("/fetchAllTypes")
    public List<TypeModel> fetchAllTypes(@RequestParam(name = "page") int page,@RequestParam(name = "size") int size ){
        return typeService.fetchAllTypes(page,size);
    }
 */