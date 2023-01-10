package com.productservice.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.productservice.dao.ProductRepository;
import com.productservice.model.DatabaseSequence;
import com.productservice.model.ProductDetails;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
    private ProductRepository repo;
	
	public void save(ProductDetails productdetails) {
		repo.save(productdetails);
	}
	
	public List<ProductDetails> findAll() {
		List<ProductDetails> s=repo.findAll();
		return s;
	}
	
	
	@Override
	public Optional<ProductDetails> getorderdetailbyid(int id) {
		return repo.findById(id);
	}
	
	
	
	@Override
	public void updateDetails(int id, ProductDetails order) {
		ProductDetails o=repo.findById(id).get();
		
		repo.save(order);
	}
	
	@Override
	public void deleteorder(int id) {
		ProductDetails o=repo.findById(id).get();
		
	}


	@Autowired
	private MongoOperations mongoOperations;



	public long getSequenceNumber(String sequenceName) {
	//get sequence no
	Query query = new Query(Criteria.where("id").is(sequenceName));
	//update the sequence no
	Update update = new Update().inc("seq", 1);
	//modify in document
	DatabaseSequence counter = mongoOperations.findAndModify(query,
	update, options().returnNew(true).upsert(true),
	DatabaseSequence.class);



	return !Objects.isNull(counter) ? counter.getSeq() : 1;



	}

}

