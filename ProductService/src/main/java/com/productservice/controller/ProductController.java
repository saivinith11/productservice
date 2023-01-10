package com.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.model.ProductDetails;
import com.productservice.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl service;

	@PostMapping("/addproduct")
	
	public String saveAdmin(@RequestBody ProductDetails productdetails) {
	productdetails.setId(service.getSequenceNumber(productdetails.SEQUENCE_NAME));
	service.save(productdetails);//user will save his details
	return "product placed Succesfull!!!";
	} 
	

	@GetMapping("/allproducts")
	
	public List<ProductDetails> findAll() {
	return service.findAll();
	}
	
	@GetMapping("/allproducts/{id}")
	
	public Optional<ProductDetails> getid(@PathVariable int id)
	{
	return service.getorderdetailbyid(id);
	}
	
	@PutMapping("/updateproduct/{id}")
	
	public String updateDetails(@RequestBody ProductDetails order,@PathVariable int id ) {
	service.updateDetails(id,order);
	return "update product Succesfull!!!";
	} 
	
	@DeleteMapping("/deleteproduct/{id}")
	
	public String deleteorderbyid(@PathVariable int id ) {
	service.deleteorder(id);
	return "delete product Succesfull!!!"; 
	}
}
