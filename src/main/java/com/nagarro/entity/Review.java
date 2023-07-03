package com.nagarro.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Review {
	@Id
	@Column(name = "ReviewId")
	@NotNull
	@Size(min=10)
	private String id;
	
	@Column(name = "Rating")
	@NotNull
	@Min(1)
	@Max(5)
	private int rating;
	
	@Column(name = "Title")
	@NotNull
	private String title;
	
	@Column(name = "Description")
	@NotNull
	@Size(min=30, max=400)
	private String description;
	
	@Column(name = "PCode")
	@NotNull
	private String pCode;
	
	@Column(name = "Approved")
	private boolean approved;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productCode")
	private Product product;
	
	public Review() {}

	public Review(@NotNull @Size(min = 10) String id, @NotNull @Min(1) @Max(5) int rating, @NotNull String title,
			@NotNull @Size(min = 30, max = 400) String description, @NotNull String productCode, boolean approved,
			Product product) {
		super();
		this.id = id;
		this.rating = rating;
		this.title = title;
		this.description = description;
		this.pCode = productCode;
		this.approved = approved;
		this.product = product;
	}

	public void prePersist() {
		String customId = generateCustomId();
		setId(customId);
	}
	
	private String generateCustomId() {
		return "R" + UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getProductCode() {
		return pCode;
	}

	public void setProductCode(String productCode) {
		this.pCode = productCode;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
