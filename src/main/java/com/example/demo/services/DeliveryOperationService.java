package com.example.demo.services;

import com.example.demo.Repositories.DeliveryOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryOperationService {

    @Autowired
    DeliveryOperationRepository deliveryOperationRepository;

}
