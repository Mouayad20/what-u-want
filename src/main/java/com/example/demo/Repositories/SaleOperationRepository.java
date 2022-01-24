package com.example.demo.Repositories;

import com.example.demo.Entities.SaleOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOperationRepository extends JpaRepository<SaleOperationEntity,Long> {
}
