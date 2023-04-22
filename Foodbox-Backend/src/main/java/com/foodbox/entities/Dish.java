package com.foodbox.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="dishes")
public class Dish {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long did;
	
	@NotBlank(message = "name cannot be blank")
	private String name;
	
	@NotBlank(message = "course cannot be blank")
	private String course;
	
	@NotBlank(message = "cuisine cannot be blank")
	private String cuisine;
	
	@NotBlank(message = "description cannot be blank")
	private String description;
	
	@NotBlank(message = "salt cannot be blank")
	private String salt;
	
	@NotNull(message = "available cannot be null")
	private int totalAvailable;
	
	@NotNull(message = "price cannot be null")
	private Double price;
	
	@NotNull(message = "isAvailable cannot be null")
	private boolean isAvailable;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private DishImage dishImage;
	
	public Dish() {
		super();
	}
	public Dish(Long did, String name, String course, String cuisine,String description, String salt, int totalAvailable, Double price,
			boolean isAvailable, DishImage dishImage) {
		super();
		this.did = did;
		this.name = name;
		this.course = course;
		this.cuisine = cuisine;
		this.description = description;
		this.salt = salt;
		this.totalAvailable = totalAvailable;
		this.price = price;
		this.isAvailable = isAvailable;
		this.dishImage = dishImage;
	}
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getTotalAvailable() {
		return totalAvailable;
	}
	public void setTotalAvailable(int totalAvailable) {
		this.totalAvailable = totalAvailable;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public DishImage getDishImage() {
		return dishImage;
	}
	public void setDishImage(DishImage dishImage) {
		this.dishImage = dishImage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
