package com.foodbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entities.Dish;
import com.foodbox.repo.DishRepo;

@Service
public class DishService {
	
	@Autowired
	private DishRepo dishRepo;
	
	// add dish
	public Dish addDish(Dish dish) {
		return this.dishRepo.save(dish);
	}
	
	//find dish by id
	public Dish findDish(Long did) {
		return this.dishRepo.findById(did).get();
	}
	
	//find all dishes
	public List<Dish> findAllDishes(){
		return this.dishRepo.findAll();
	}
	
	//find dish by name or salt
	public List<Dish> findByNameOrSalt(String name, String salt){
		List<Dish> dishes = this.dishRepo.findByNameContainingIgnoreCaseOrSaltContainingIgnoreCase(name, salt);
		return dishes;
	}
	
	//find dish by cuisine
	public List<Dish> findDishByCuisine(String cuisine){
		List<Dish> dishes = this.dishRepo.findByCuisine(cuisine);
		return dishes;
	}
	
	//delete dish by id
	public void deleteDishById(Long did) {
		this.dishRepo.deleteById(did);
	}
	
	//find available dishes
	public List<Dish> findTrueDish(String name){
		List<Dish> dishes = this.dishRepo.findByNameAndIsAvailableTrue(name);
		return dishes;
	}
}
