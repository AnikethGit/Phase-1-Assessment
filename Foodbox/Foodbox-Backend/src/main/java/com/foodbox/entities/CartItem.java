package com.foodbox.entities;

public class CartItem {
	
	private Long did;
	private int quantity;
	public CartItem() {
		
	}
	public CartItem(Long did, int quantity) {
		super();
		this.did = did;
		this.quantity = quantity;
	}
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
