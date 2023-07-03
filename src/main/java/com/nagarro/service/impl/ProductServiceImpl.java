package com.nagarro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.Product;
import com.nagarro.repository.ProductRepository;
import com.nagarro.service.ProductService;

/** Service to get product related details */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Long getProductsCount() {
		return productRepository.count();
	}
	
	@Override
	public List<Product> getProductsBySearch(String search) {
		List<Product> products = productRepository.findAll();
		List<Product> searchedProducts = new ArrayList<Product>();
		
		// Search all products on product code, name or brand.
		for(Product p : products) {
			if(p.getProductCode().equalsIgnoreCase(search) || p.getProductName().equalsIgnoreCase(search) || p.getBrand().equalsIgnoreCase(search)) {
				searchedProducts.add(p);
			}
		}
		return searchedProducts;
	}
	
	@Override
	public List<Product> getProductsByFilter(String productCode, String brand, String productName) {
		List<Product> products = productRepository.findAll();
		List<Product> filteredProducts = new ArrayList<Product>();
		
		// Search all products on product code, name or brand.
		for(Product p : products) {
			if(p.getProductCode().equalsIgnoreCase(productCode) || p.getProductName().equalsIgnoreCase(productName) || p.getBrand().equalsIgnoreCase(brand)) {
				filteredProducts.add(p);
			}
		}
		return filteredProducts;
	}
	
	@Override
	public Product getProductByCode(String code) {
		Optional<Product> product = productRepository.findById(code);
		
		if(product.isPresent() == false) {
			return null;
		}
		return product.get();
	}

	@Override
	public Product addNewProduct(Product product) {
		String productCode = product.getProductCode();
		List<Product> products = productRepository.findAll();
		
		for(Product p: products) {
			if(p.getProductCode().equalsIgnoreCase(productCode)) {
				return null;
			}
		}
		return productRepository.save(product);
	}

}
