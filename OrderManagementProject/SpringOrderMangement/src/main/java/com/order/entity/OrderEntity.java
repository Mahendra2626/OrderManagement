package com.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	 private String device;
	 private Double price;
	 private String brand;
	public OrderEntity() {
		super();
	}
	public OrderEntity(Integer id, String device, Double price, String brand) {
		super();
		this.id = id;
		this.device = device;
		this.price = price;
		this.brand = brand;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	 
	

}
