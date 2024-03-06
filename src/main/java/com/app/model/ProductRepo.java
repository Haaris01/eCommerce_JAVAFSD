package com.app.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ProductRepo extends MongoRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	List<Product> findByDescription(String description);
	List<Product> findByPrice(int price);
//	@Query("SELECT p.category.name FROM Product p WHERE p.category IS NOT NULL")
	//List<Category> findAllCategory();
}
