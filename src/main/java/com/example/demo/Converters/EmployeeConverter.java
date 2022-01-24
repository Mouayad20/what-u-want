package com.example.demo.Converters;

import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Models.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConverter {

    @Autowired
    DeliveryOperationConverter deliveryOperationConverter;


    public EmployeeModel entityToModel(EmployeeEntity employee) {
        return new EmployeeModel(
                employee.getId(),
                employee.getName(),
                employee.getPassword(),
                employee.getMobile(),
                employee.getImage(),
                employee.getRegion(),
                employee.getRate(),
                employee.isIs_free(),
                deliveryOperationConverter.entityListToModelList(employee.getDeliveryOperations())
        );
    }

    public EmployeeEntity modelToEntity(EmployeeModel employee) {
        return new EmployeeEntity(
                employee.getId(),
                employee.getName(),
                employee.getPassword(),
                employee.getMobile(),
                employee.getImage(),
                employee.getRegion(),
                employee.getRate(),
                employee.isIs_free(),
                deliveryOperationConverter.modelListToEntityList(employee.getDeliveryOperations())
        );
    }
}
