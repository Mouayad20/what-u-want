package com.example.demo.Repositories;

import com.example.demo.Entities.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity,Long> {

}
