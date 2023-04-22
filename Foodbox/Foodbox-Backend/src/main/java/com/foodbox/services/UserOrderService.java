package com.foodbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entities.DishQuantity;
import com.foodbox.entities.UserOrder;
import com.foodbox.repo.OrderRepo;
import com.foodbox.repo.DishQuantityRepo;

@Service
public class UserOrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private DishQuantityRepo dishQuantityRepo;
	
	public UserOrder saveOrder(UserOrder userOrder) {
		UserOrder orderSaved = this.orderRepo.save(userOrder);
		return orderSaved;
	}
	public void saveDishQuantity(DishQuantity dishQuantity) {
		this.dishQuantityRepo.save(dishQuantity);
	}
	
	public List<UserOrder> getAll(){
		return this.orderRepo.findAll();
	}
	
	public List<UserOrder> getUserOrders(String username){
		List<UserOrder> orders = this.orderRepo.findByUsername(username);
		return orders;
	}
	
	public UserOrder getOrderById(Long oid) {
		UserOrder order = this.orderRepo.findById(oid).get();
		return order;
	}
	
	public void deleteOrder(Long oid) {
		this.orderRepo.deleteById(oid);
	}

}
