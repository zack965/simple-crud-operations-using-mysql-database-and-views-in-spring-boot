package com.apiviews.apiviews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> GetProducts(){
        return productRepository.findAll();
    }
    public void SaveProduct(Product prd){
        productRepository.save(prd);
    }
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public Product UpdateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
    public void DeleteProduct(int id){
        productRepository.deleteById(id);
    }
    
}
