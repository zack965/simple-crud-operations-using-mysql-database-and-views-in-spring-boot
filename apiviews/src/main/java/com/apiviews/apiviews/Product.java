package com.apiviews.apiviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

import lombok.NonNull;

@Entity
@Table(name="Product_Tb")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductId;

    private String ProductName;
    private double price;
    public int getProductId() {
        return ProductId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getProductName() {
        return ProductName;
    }
    public void setProductName(String productName) {
        this.ProductName = productName;
    }
    public void setProductId(int productId) {
        this.ProductId = productId;
    }
    public Product(int productId, String productName, double price) {
        ProductId = productId;
        ProductName = productName;
        this.setPrice(price);
    }
    public Product() {
    }
    
}
