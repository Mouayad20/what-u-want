package com.example.demo.Repositories;

import com.example.demo.Entities.BuyOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyOrderRepository extends JpaRepository<BuyOrderEntity,Long> {

    @Query(value = "SELECT * FROM buy_orders WHERE sale_post_id=:p_id",nativeQuery = true)
    List<BuyOrderEntity> getBuyOrdersBySID(@Param("p_id") Long p_id);
}
