package com.nagarro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.Product;
import com.nagarro.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
	
	List<Review> findByProductAndApproved(Product product, Boolean status);
	
	List<Review> findByApproved(Boolean status);
	
	Long countByApproved(Boolean status);

}
