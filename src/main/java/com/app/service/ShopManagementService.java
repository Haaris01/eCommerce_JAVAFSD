package com.app.service;

import com.app.model.Category;
import com.app.model.CategoryRepo;
import com.app.model.Product;
import com.app.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopManagementService {
    @Autowired
    private CategoryRepo catRepo;
    @Autowired
    private ProductRepo prodRepo;

    public void addCategory(Category category) {
        catRepo.save(category);
    }

    public void updateCategory(int id, String field) {
        Optional<Category> cat = catRepo.findById(id);
        if(!cat.isEmpty()) {
            Category updatedCat = cat.get();
            updatedCat.setName(field);
            catRepo.save(updatedCat);
        }
    }

    public void deleteCategory(int id) {
        catRepo.deleteById(id);
    }

    public void addProduct(Map<String, Object> reqBody){
        System.out.println(reqBody);
        String productName = (String) reqBody.get("name");
        int productPrice = Integer.parseInt((String) reqBody.get("price"));
        String productDescription = (String) reqBody.get("description");
        String categoryName = (String) reqBody.get("category");
        String imageUrl = (String) reqBody.get("imageUrl");
        List<Category> cat = catRepo.findCategoryByName(categoryName);
        Product product = new Product();
        product.setName(productName);
        product.setPrice(productPrice);
        product.setDescription(productDescription);
        product.setImageUrl(imageUrl);
        Iterator it = cat.iterator();
        if(it.hasNext()){
            Category c = (Category) it.next();
            product.setCategoryId(c.getCategoryId());
            List<Product> newList = (c).getProducts() == null ? new ArrayList<>() : (c).getProducts();
            newList.add(product);
            c.setProducts(newList);
            catRepo.save(c);
        }
        prodRepo.save(product);
    }
}
