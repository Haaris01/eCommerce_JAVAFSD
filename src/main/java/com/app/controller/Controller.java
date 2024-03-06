package com.app.controller;

import java.util.List;
import java.util.Map;

import com.app.model.Category;
import com.app.service.ShopManagementService;
import com.app.service.ShopService;
import com.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller{
	
	@Autowired
	private ShopService shop;
	@Autowired
	private ShopManagementService shopManagementService;

	@GetMapping("/")
	public String print(){
		return "This is the homepage";
	}
	
	@GetMapping("/products")
	public List<Product> fetchAllProducts() {
		return shop.getAllproducts();
	}
	
	@PostMapping("/products")
	public List<Product> fetchProductsByField(@RequestBody Product prod){
		System.out.println(prod);
		String name = prod.getName() != null ? prod.getName() : "" ;
		int price = prod.getPrice();
	    String description = prod.getDescription() != null ? prod.getDescription() : "";
	    
	    if (!name.isEmpty()) {
	        return shop.getProductsByName(name);
	    } else if (price > 0) {
	        return shop.getProductsByPrice(price);
	    } else if (!description.isEmpty()) {
	        return shop.getProductsByDesc(description);
	    } else {
	        return null;
	    }
	}

	@GetMapping("/categories")
	public List<Category> fetchCategories(){
		return shop.getAllCategories();
	}

	@PostMapping("/categories")
	public List<Category> fetchCategoriesByField(@RequestBody Category catg){
		String name = catg.getName() != null ? catg.getName() : "" ;

		if (!name.isEmpty()) {
			return shop.getCategoriesByName(name);
		} else {
			return null;
		}
	}

	@PostMapping("/categories/add-category")
	public RedirectView addCategory(@RequestBody Category category){
		shopManagementService.addCategory(category);
		return new RedirectView("/categories");
	}

	@PutMapping("/categories/{id}")
	public RedirectView updateCategory(@PathVariable int id, @RequestBody Category cat){
		String field = cat.getName();
		shopManagementService.updateCategory(id, field);
		return new RedirectView("/categories");
	}

	@DeleteMapping("/categories/{id}")
	public RedirectView deletecategory(@PathVariable int id){
		shopManagementService.deleteCategory(id);
		return new RedirectView("/categories");
	}

	@PostMapping("/products/add-product")
	public RedirectView addProduct(@RequestBody Map<String, Object> reqBody){
		shopManagementService.addProduct(reqBody);
		return new RedirectView("/products");
	}
}
