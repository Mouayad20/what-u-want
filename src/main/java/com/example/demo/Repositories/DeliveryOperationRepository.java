package com.example.demo.Repositories;

import com.example.demo.Entities.DeliveryOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryOperationRepository extends JpaRepository<DeliveryOperationEntity,Long> {
}
