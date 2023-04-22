package com.foodbox.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.config.ImageUtil;
import com.foodbox.entities.CartItem;
import com.foodbox.entities.CartOrder;
import com.foodbox.entities.Dish;
import com.foodbox.entities.DishImage;
import com.foodbox.entities.DishQuantity;
import com.foodbox.entities.UserOrder;
import com.foodbox.services.DishService;
import com.foodbox.services.UserOrderService;

@RestController
@CrossOrigin(origins = "*")
public class UserOrderController {
	
	@Autowired
	private UserOrderService userOrderService;
	
	@Autowired
	private DishService dishService;
	
	@PreAuthorize("hasAuthority('USER')")
	@PostMapping("/user/create/order")
	public ResponseEntity<?> createOrder(@Valid @RequestBody CartOrder cartOrder){
		
		UserOrder userOrder = new UserOrder();
		userOrder.setUsername(cartOrder.getUsername());
		userOrder.setFirstName(cartOrder.getFirstName());
		userOrder.setLastName(cartOrder.getLastName());
		userOrder.setAddress(cartOrder.getAddress());
		userOrder.setDistrict(cartOrder.getDistrict());
		userOrder.setState(cartOrder.getState());
		userOrder.setContact(cartOrder.getContact());
		userOrder.setPinCode(cartOrder.getPinCode());
		
		DateFormat df = DateFormat.getDateInstance();
		Calendar cl = Calendar.getInstance();
		String orderDate = df.format(cl.getTime());
		userOrder.setDate(orderDate);
		userOrder.setStatus("PLACED");
		userOrder.setPaidAmount(cartOrder.getPaidAmount());
		userOrder.setPaymentMode(cartOrder.getPaymentMode());
		Set<CartItem> cartItems  = cartOrder.getCartItem();
		Set<DishQuantity> dq = new HashSet<>();
		for(CartItem item : cartItems) {
			Dish dish = this.dishService.findDish(item.getDid());
			int quantity = item.getQuantity();
			DishQuantity dishQuantity = new DishQuantity();
			dishQuantity.setDish(dish);
			dishQuantity.setQuantity(quantity);
			this.userOrderService.saveDishQuantity(dishQuantity);
			dq.add(dishQuantity);
		}
		
		userOrder.setDishes(dq);
		UserOrder orderCreated = this.userOrderService.saveOrder(userOrder);
		return ResponseEntity.ok(orderCreated);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/get/all/orders")
	public ResponseEntity<?> getAllOrders(){
		List<UserOrder> orders = this.userOrderService.getAll();
		return ResponseEntity.ok(orders);
	}
	
	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("/get/orders/{username}")
	public ResponseEntity<?> userOrders(@PathVariable("username") String username){
		List<UserOrder> orders = this.userOrderService.getUserOrders(username);
		if(orders.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.ok(orders);
		}
	}
	
	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
	@GetMapping("/get/order-invoice/{oid}")
	public ResponseEntity<?> getUserOrderById(@PathVariable("oid") Long oid){
		UserOrder order = this.userOrderService.getOrderById(oid);
		Set<DishQuantity> dishes = order.getDishes();
		dishes.forEach(p -> {
			DishImage img = new DishImage();
			img.setImageData(ImageUtil.decompressImage(p.getDish().getDishImage().getImageData()));
			img.setName(p.getDish().getDishImage().getName());
			img.setImgId(p.getDish().getDishImage().getImgId());
			img.setType(p.getDish().getDishImage().getType());
			p.getDish().setDishImage(img);
		});
		order.setDishes(dishes);
		return ResponseEntity.ok(order);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/delete/order/{oid}")
	public ResponseEntity<?> deleteOrderById(@PathVariable("oid") Long oid){
		this.userOrderService.deleteOrder(oid);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
