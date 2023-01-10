package com.productservice.model;

import java.beans.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="productdetails")
public class ProductDetails {
	
	@Id
	private Long id;
    private String productname;
	private String description;
	private double price;
	
	
	
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@org.springframework.data.annotation.Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public ProductDetails(Long id, String productname, String description, double price) {
		super();
		this.id = id;
		this.productname = productname;
		this.description = description;
		this.price = price;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", productname=" + productname + ", description=" + description + ", price="
				+ price + "]";
	}

	
}
