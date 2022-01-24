package com.example.demo.Repositories;

import com.example.demo.Entities.BuyPostEntity;
import com.example.demo.Entities.SalePostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyPostRepository extends JpaRepository<BuyPostEntity,Long> {

}
