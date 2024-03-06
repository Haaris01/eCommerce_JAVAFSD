package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Product {
    @Id
    private int productId;
    private String name;
    private int price;
    private String description;
    private String imageUrl;
    private int categoryId;
}