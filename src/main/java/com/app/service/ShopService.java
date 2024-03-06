package com.app.service;

import java.util.List;

import com.app.model.Category;
import com.app.model.CategoryRepo;
import com.app.model.ProductRepo;
import com.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	@Autowired
	private CategoryRepo catRepo;
	@Autowired
	private ProductRepo prodRepo;
	
	public List<Product> getAllproducts() {
		List<Product> prods = prodRepo.findAll();
		return prods;
	}

	public List<Product> getProductsByName(String name) {	
		return prodRepo.findByName(name);
	}

	public List<Product> getProductsByPrice(int price) {
		return prodRepo.findByPrice(price);
	}

	public List<Product> getProductsByDesc(String description) {
		return prodRepo.findByDescription(description);
	}

	public List<Category> getAllCategories() {
		return catRepo.findAll();
	}

	public List<Category> getCategoriesByName(String name) {
		return catRepo.findCategoryByName(name);
	}
}
