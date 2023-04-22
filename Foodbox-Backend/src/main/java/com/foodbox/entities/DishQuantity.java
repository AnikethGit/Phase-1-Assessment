package com.foodbox.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DishQuantity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dqid;
	
	@OneToOne
	private Dish dish;
	
	private int quantity;
	
	
	public DishQuantity() {
		
	}

	public DishQuantity(Long dqid, Dish dish, int quantity) {
		super();
		this.dqid = dqid;
		this.dish = dish;
		this.quantity = quantity;
	}

	public Long getDqid() {
		return dqid;
	}

	public void setDqid(Long dqid) {
		this.dqid = dqid;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
