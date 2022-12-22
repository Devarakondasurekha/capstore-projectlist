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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="response")
public class Response
{
	@Id
	@Column(name="response_id",length=10)
	private String responseId;
	@Column(name="description")
	private String description;
	@Column(name="rating")
	private double rating;
	
	@ManyToMany
	@JoinTable(name="merchant_response"
			,joinColumns=@JoinColumn(name="response_id")
			,inverseJoinColumns= {
					@JoinColumn(name="merchant_id",referencedColumnName="merchant_mobile_no")
					}
			)
	private List<Merchant> merchantResponses=new ArrayList<>();

	@ManyToMany
	@JoinTable(name="merchant_response"
			,joinColumns=@JoinColumn(name="response_id")
			,inverseJoinColumns= 
			{
					@JoinColumn(name="customer_id",referencedColumnName="customer_mobile_no")
			})
	private List<Customer> customerResponses=new ArrayList<>();

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(String responseId, String description, double rating, Merchant merchantResponse,
			Customer customerResponse) {
		super();
		this.responseId = responseId;
		this.description = description;
		this.rating = rating;
		this.merchantResponses.add(merchantResponse);
		this.customerResponses.add(customerResponse);
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
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

	public List<Merchant> getMerchantResponse() {
		return merchantResponses;
	}

	public void setMerchantResponse(Merchant merchantResponse) {
		this.merchantResponses.add(merchantResponse);
	}

	public List<Customer> getCustomerResponse() {
		return customerResponses;
	}

	public void setCustomerResponse(Customer customerResponse) {
		this.customerResponses.add(customerResponse);
	}

	@Override
	public String toString() {
		return "Response [responseId=" + responseId + ", description=" + description + ", rating=" + rating
				+ ", merchantResponse=" + merchantResponses + ", customerResponse=" + customerResponses + "]";
	}

	

}
