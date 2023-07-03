package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.nagarro.entity.Product;
import com.nagarro.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/count")
	public Long getProductsCount() {
		return productService.getProductsCount();
	}
	
	@GetMapping("/{search}")
	public List<Product> getProductsBySearch(@PathVariable String search) {
		return productService.getProductsBySearch(search);
	}
	
	@GetMapping("/filter/{productCode}/{brand}/{productName}")
	public List<Product> getProductsByFilter(@PathVariable String productCode, @PathVariable String brand, @PathVariable String productName) {
		return productService.getProductsByFilter(productCode, brand, productName);
	}
	
	@GetMapping("/code/{code}")
	public Product getProductByCode(@PathVariable String code) {
		Product product = productService.getProductByCode(code);
		
		if(product == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product does not exists.");
		}
		return product;
	}
	
	@PostMapping
	public Product addNewProduct(@RequestBody Product product) {
		Product res = productService.addNewProduct(product);
		
		if(res == null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Product already present.");
		}
		return res;
	}
	
}
