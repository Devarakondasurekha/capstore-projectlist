package com.cg.capstore.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback
{
	@Id
	@Column(name="feedback_id",length=10)
	private String feedbackId;
	@Column(name="description")
	private String description;
	@Column(name="rating")
	private double rating;
	
	@ManyToMany
	@JoinTable(name="merchant_feedback"
			,joinColumns=@JoinColumn(name="feedback_id")
			,inverseJoinColumns= {
					@JoinColumn(name="merchant_id",referencedColumnName="merchant_mobile_no")
					}
			)
	private List<Merchant> merchantFeedbacks=new ArrayList<>(); 
	@ManyToMany
	@JoinTable(name="customer_feedback"
			,joinColumns=@JoinColumn(name="feedback_id")
			,inverseJoinColumns= 
			{
					@JoinColumn(name="customer_id",referencedColumnName="customer_mobile_no")
			})
	private List<Customer> customerFeedbacks=new ArrayList<>();
	@ManyToMany
	@JoinTable(name="product_feedback"
			,joinColumns=@JoinColumn(name="feedback_id")
			,inverseJoinColumns= @JoinColumn(name="prod_id")
			)
	private List<Product> prodFeedbacks=new ArrayList<>(); 

	public Feedback() 
	{
		super();
	}

	public Feedback(String feedbackId, String description, double rating,Merchant merchantFeedback,
			Customer customerFeedbacks,Product prodFeedback) {
		super();
		this.feedbackId = feedbackId;
		this.description = description;
		this.rating = rating;
		this.merchantFeedbacks.add(merchantFeedback);
		this.customerFeedbacks.add(customerFeedbacks);
		this.prodFeedbacks.add(prodFeedback);
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Merchant> getMerchantFeedback() {
		return merchantFeedbacks;
	}

	public void setMerchantFeedback(Merchant merchantFeedback) {
		this.merchantFeedbacks.add(merchantFeedback);
	}

	public List<Customer> getCustomerFeedback() {
		return customerFeedbacks;
	}

	public void setCustomerFeedback(Customer customerFeedback) {
		this.customerFeedbacks.add(customerFeedback);
	}

	public List<Product> getProdFeedback() {
		return prodFeedbacks;
	}

	public void setProdFeedback(Product prodFeedback) {
		this.prodFeedbacks.add(prodFeedback);
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", description=" + description + ", rating=" + rating
				+ ", merchantFeedback=" + merchantFeedbacks + ", customerFeedback=" + customerFeedbacks
				+ ", prodFeedback=" + prodFeedbacks + "]";
	}

	
}
