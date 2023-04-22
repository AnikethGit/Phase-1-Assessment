package com.foodbox.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class DishImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long imgId;
	
	private String name;
	
	private String type;
	
	@Lob
	@Column(name = "imagedata")
	private byte[] imageData;
	
	@OneToOne(mappedBy = "dishImage")
	@JsonBackReference
	private Dish dish;

	public DishImage() {
		super();
	}

	public DishImage(Long imgId, String name, String type, byte[] imageData, Dish dish) {
		super();
		this.imgId = imgId;
		this.name = name;
		this.type = type;
		this.imageData = imageData;
		this.dish = dish;
	}

	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	

}
