package com.app.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;
//import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
public class Category {
	@Id
	private int categoryId;
	private String name;
	private List<Product> products;
}
