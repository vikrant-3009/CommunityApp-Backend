package com.nagarro.service;

import java.util.List;

import com.nagarro.entity.Product;
import com.nagarro.entity.Review;

public interface ReviewService {
	
	public List<Review> getAllReviews();
	
	public Long getApprovedReviewsCount();
	
	public Review getReview(String reviewId);
	
	public List<Review> getReviewsByProductCode(String productCode);
	
	public List<Review> getNonApprovedReviews();
	
	public Review addNewReview(Review review);
	
	public Product updateApprovalStatus(String reviewId);
	
	public void deleteReview(String reviewId);
	
}
