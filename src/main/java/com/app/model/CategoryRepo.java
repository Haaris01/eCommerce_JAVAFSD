package com.app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepo extends MongoRepository<Category, Integer> {
	public List<Category> findCategoryByName(String name);
}
