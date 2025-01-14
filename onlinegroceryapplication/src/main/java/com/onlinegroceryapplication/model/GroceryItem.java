package com.onlinegroceryapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class GroceryItem {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer inventory;
    
    
	public GroceryItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroceryItem(Long id, String name, Double price, Integer inventory) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

    // Getters and Setters
    
}