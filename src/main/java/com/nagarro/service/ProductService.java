package com.nagarro.service;

import java.util.List;

import com.nagarro.entity.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Long getProductsCount();
	
	public List<Product> getProductsBySearch(String search);
	
	public List<Product> getProductsByFilter(String productCode, String brand, String productName);
	
	public Product getProductByCode(String code);
	
	public Product addNewProduct(Product product);
}
