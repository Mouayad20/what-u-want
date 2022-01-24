package com.example.demo.Repositories;

import com.example.demo.Entities.SalePostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalePostRepository extends JpaRepository<SalePostEntity,Long> {

    @Query(value = "SELECT * FROM sale_posts WHERE item_type=:t_id" ,nativeQuery = true)
    List<SalePostEntity> fetchByType(@Param("t_id") Long t_id);
}
