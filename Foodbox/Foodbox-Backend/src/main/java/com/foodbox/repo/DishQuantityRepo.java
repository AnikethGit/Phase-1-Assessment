package com.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.entities.DishQuantity;

@Repository
public interface DishQuantityRepo extends JpaRepository<DishQuantity, Long>{

}
