package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.Product;
import com.nagarro.entity.Review;
import com.nagarro.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "http://localhost:4200/")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public List<Review> getAllReviews() {
		return reviewService.getAllReviews();
	}
	
	@GetMapping("/approvedCount")
	public Long getApprovedReviewsCount() {
		return reviewService.getApprovedReviewsCount();
	}
	
	@GetMapping("/{productCode}")
	public List<Review> getReviewsByProductCode(@PathVariable String productCode) {
		return reviewService.getReviewsByProductCode(productCode);
	}
	
	@GetMapping("/nonApproved")
	public List<Review> getNonApprovedReviews() {
		return reviewService.getNonApprovedReviews();
	}
	
	@PostMapping
	public Review addNewReview(@RequestBody Review review) {
		return reviewService.addNewReview(review);
	}
	
	@PatchMapping("/{reviewId}")
	public Product updateAppovalStatus(@PathVariable String reviewId) {
		return reviewService.updateApprovalStatus(reviewId);
	}
	
	@DeleteMapping("/{reviewId}")
	public void deleteReview(@PathVariable String reviewId) {
		reviewService.deleteReview(reviewId);
	}
	
}
