package com.productservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.productservice.model.ProductDetails;


@Repository
public interface ProductRepository extends MongoRepository<ProductDetails, Integer>{

}
