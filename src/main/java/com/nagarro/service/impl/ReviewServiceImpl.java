package com.nagarro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.Product;
import com.nagarro.entity.Review;
import com.nagarro.repository.ProductRepository;
import com.nagarro.repository.ReviewRepository;
import com.nagarro.service.ProductService;
import com.nagarro.service.ReviewService;

/** Service to get reviews related details */
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}
	
	@Override
	public Long getApprovedReviewsCount() {
		return reviewRepository.countByApproved(true);
	}
	
	@Override
	public Review getReview(String reviewId) {
		Optional<Review> reviewNew = reviewRepository.findById(reviewId);
		return reviewNew.isPresent() ? reviewNew.get() : null;
	}
	
	@Override
	public List<Review> getReviewsByProductCode(String productCode) {
		Product product = productService.getProductByCode(productCode);
		return reviewRepository.findByProductAndApproved(product, true);
	}
	
	@Override
	public List<Review> getNonApprovedReviews() {
		return reviewRepository.findByApproved(false);
	}

	@Override
	public Review addNewReview(Review review) {
		Product product = review.getProduct();
		
		product.getReviews().add(review);
		review.setProductCode(product.getProductCode());
		review.setProduct(product);
		productRepository.save(product);
		
		return reviewRepository.findById(review.getId()).get();
	}

	@Override
	public Product updateApprovalStatus(String reviewId) {
		Review review = getReview(reviewId);
		Product product = review.getProduct();
		
		product.setReviewsApproved(product.getReviewsApproved() + 1);
		product.setReviewTotal(product.getReviewTotal() + review.getRating());
		
		for(Review r: product.getReviews()) {
			if(r.getId().equals(reviewId)) {
				r.setApproved(true);
				break;
			}
		}
		return productRepository.save(product);
	}

	@Override
	public void deleteReview(String reviewId) {
		reviewRepository.deleteById(reviewId);
	}

}
