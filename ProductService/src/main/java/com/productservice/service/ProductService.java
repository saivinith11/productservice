package com.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.productservice.dao.ProductRepository;
import com.productservice.model.ProductDetails;

public interface ProductService {
	
	
	
	public void save(ProductDetails productdetails);
	
	public List<ProductDetails> findAll();
	
	public Optional<ProductDetails> getorderdetailbyid(int id);
	
	public void updateDetails(int id, ProductDetails order);
	
	public void deleteorder(int id);
}
