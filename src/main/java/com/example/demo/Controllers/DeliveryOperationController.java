package com.example.demo.Controllers;
import com.example.demo.services.DeliveryOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/deliveryOperation")
public class DeliveryOperationController {

    @Autowired
    DeliveryOperationService deliveryOperationService;
}
