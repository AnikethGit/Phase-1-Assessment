package com.foodbox.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.entities.Dish;

@Repository
public interface DishRepo extends JpaRepository<Dish, Long>{
	public List<Dish> findByNameContainingIgnoreCaseOrSaltContainingIgnoreCase(String name, String salt);
	public List<Dish> findByCuisine(String cuisine);
	public List<Dish> findByNameAndIsAvailableTrue(String name);
}