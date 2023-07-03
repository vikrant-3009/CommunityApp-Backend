package com.nagarro.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Product {
	@Id
	@Column(name = "ProductCode")
	@Size(min=3)
	@NotNull
	private String productCode;
	
	@Column(name = "ProductName")
	@NotNull
	private String productName;
	
	@Column(name = "Brand")
	@NotNull
	private String brand;
	
	@Column(name = "ReviewTotal")
	private Integer reviewTotal;
	
	@Column(name = "ReviewsApproved")
	private Integer reviewsApproved;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	public Product() {}	

	public Product(@Size(min = 3) @NotNull String productCode, @NotNull String productName, @NotNull String brand,
			Integer reviewTotal, Integer reviewsApproved, List<Review> reviews) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.brand = brand;
		this.reviewTotal = reviewTotal;
		this.reviewsApproved = reviewsApproved;
		this.reviews = reviews;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public Integer getReviewTotal() {
		return reviewTotal;
	}

	public void setReviewTotal(Integer reviewTotal) {
		this.reviewTotal = reviewTotal;
	}
	
	public Integer getReviewsApproved() {
		return reviewsApproved;
	}

	public void setReviewsApproved(Integer reviewsApproved) {
		this.reviewsApproved = reviewsApproved;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
