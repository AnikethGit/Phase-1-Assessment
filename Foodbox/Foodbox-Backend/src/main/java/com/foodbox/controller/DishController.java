package com.foodbox.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodbox.config.ImageUtil;
import com.foodbox.entities.Dish;
import com.foodbox.entities.DishImage;
import com.foodbox.services.DishService;

@RestController
@CrossOrigin(origins = "*")
public class DishController {
	
	@Autowired
	private DishService dishService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	//add new dish
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/add/dish")
	public ResponseEntity<?> addNewDish(@RequestParam("dish") String dish, 
										   @RequestParam("image") MultipartFile file) throws IOException{
		
		DishImage img = new DishImage();
		img.setName(file.getOriginalFilename());
		img.setType(file.getContentType());
		img.setImageData(ImageUtil.compressImage(file.getBytes()));
		Dish p = null;
		try {
			p = objectMapper.readValue(dish,Dish.class);
			p.setDishImage(img);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
		}
		Dish saveDish = this.dishService.addDish(p);
		return ResponseEntity.ok(saveDish);
	}
	
	//update existing dish
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/update/dish/{id}")
	public ResponseEntity<?> updateDish(@PathVariable("id") Long id,@Valid @RequestBody Dish dish){
		Dish updateDish = this.dishService.findDish(id);
		updateDish.setName(dish.getName());
		updateDish.setCourse(dish.getCourse());
		updateDish.setCuisine(dish.getCuisine());
		updateDish.setDescription(dish.getDescription());
		updateDish.setSalt(dish.getSalt());
		updateDish.setTotalAvailable(dish.getTotalAvailable());
		updateDish.setPrice(dish.getPrice());
		this.dishService.addDish(updateDish);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//find dish by id
	@GetMapping("get-dish/{id}")
	public ResponseEntity<?> getDishById(@PathVariable("id") Long id){
		Dish dish = this.dishService.findDish(id);
		DishImage img =  new DishImage();
		img.setImageData(ImageUtil.decompressImage(dish.getDishImage().getImageData()));
		img.setImgId(dish.getDishImage().getImgId());
		img.setName(dish.getDishImage().getName());
		img.setType(dish.getDishImage().getType());
		dish.setDishImage(img);
		return ResponseEntity.ok(dish);
	}
	
	//find all dishes
	@GetMapping("/get/all-dishes")
	public ResponseEntity<?> getAllDishes(){
		List<Dish> allDishes = this.dishService.findAllDishes();
		allDishes.forEach(dish -> {
			DishImage img =  new DishImage();
			img.setImageData(ImageUtil.decompressImage(dish.getDishImage().getImageData()));
			img.setImgId(dish.getDishImage().getImgId());
			img.setName(dish.getDishImage().getName());
			img.setType(dish.getDishImage().getType());
			dish.setDishImage(img);
		});
		if(allDishes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.ok(allDishes);
		}
	}
	
	@GetMapping(value = {"/get/dishes/{name}"})
	public ResponseEntity<?> getDishByName(@PathVariable("name") String name,@PathVariable("name") String salt){
		List<Dish> dishes = this.dishService.findByNameOrSalt(name, salt);
		dishes.forEach(dish -> {
			DishImage img =  new DishImage();
			img.setImageData(ImageUtil.decompressImage(dish.getDishImage().getImageData()));
			img.setImgId(dish.getDishImage().getImgId());
			img.setName(dish.getDishImage().getName());
			img.setType(dish.getDishImage().getType());
			dish.setDishImage(img);
		});
		if(dishes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.ok(dishes);
		}
	}
	@GetMapping("/get/dishes-by-cuisine/{cuisine}")
	public ResponseEntity<?> getDishesByCuisine(@PathVariable("cuisine") String cuisine){
		List<Dish> dishes = this.dishService.findDishByCuisine(cuisine);
		dishes.forEach(dish -> {
			DishImage img =  new DishImage();
			img.setImageData(ImageUtil.decompressImage(dish.getDishImage().getImageData()));
			img.setImgId(dish.getDishImage().getImgId());
			img.setName(dish.getDishImage().getName());
			img.setType(dish.getDishImage().getType());
			dish.setDishImage(img);
		});
		if(dishes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.ok(dishes);
		}
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/delete/dish/{id}")
	public ResponseEntity<?> deleteDish(@PathVariable("id") Long id){
		this.dishService.deleteDishById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/set-availability/dish/{id}")
	public ResponseEntity<?> setAvailability(@PathVariable("id") Long id, @RequestBody Dish dish){
		Dish updateDish = this.dishService.findDish(id);
		updateDish.setAvailable(dish.isAvailable());
		this.dishService.addDish(updateDish);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/get/{name}")
	public ResponseEntity<?> getAvailable(@PathVariable("name") String name){
		List<Dish> dishes = this.dishService.findTrueDish(name);
		if(dishes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.ok(dishes);
		}
	}
	
	
	
}
