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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="merchant")
public class Merchant 
{
	@Id
	@Column(name="merchant_mobile_no")
	private String merchantMobileNo;
	@Column(name="merchant_name",length=50)
	private String merchantName;
	@Column(name="email",length=70)
	private String email;
	@Column(name="password",length=20)
	private String password;
	@Column(name="merchant_type",length=50)
	private String merchantType;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="merchantAddress")
	private List<Address> addresses=new ArrayList<>();
	
	@ManyToMany(mappedBy="merchantFeedbacks",cascade=CascadeType.ALL)
	private List<Feedback> merchantFeedback=new ArrayList<>();
	
	@ManyToMany(mappedBy="merchantResponses",cascade=CascadeType.ALL)
	private List<Response> merchantResponse=new ArrayList<>();
	
	@ManyToMany(mappedBy="merchantProducts",cascade=CascadeType.ALL)
	private List<Product> merchantProduct = new ArrayList<>();
 	
	public Merchant() 
	{
		super();
	}

	public Merchant(String merchantMobileNo, String merchantName, String email, String password, String merchantType,
			Address addresses, Feedback feedback, Response response, Product products) {
		super();
		this.merchantMobileNo = merchantMobileNo;
		this.merchantName = merchantName;
		this.email = email;
		this.password = password;
		this.merchantType = merchantType;
		this.addresses.add(addresses);
		this.merchantFeedback.add(feedback);
		this.merchantResponse.add(response);
		this.merchantProduct.add(products);
	}

	public String getMerchantMobileNo() {
		return merchantMobileNo;
	}

	public void setMerchantMobileNo(String merchantMobileNo) {
		this.merchantMobileNo = merchantMobileNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Address addresses) {
		this.addresses.add(addresses);
	}

	public List<Feedback> getFeedback() {
		return merchantFeedback;
	}

	public void setFeedback(Feedback feedback) {
		this.merchantFeedback.add(feedback);
	}

	public List<Response> getResponse() {
		return merchantResponse;
	}

	public void setResponse(Response response) {
		this.merchantResponse.add(response);
	}

	public List<Product> getProducts() {
		return merchantProduct;
	}

	public void setProducts(Product products) {
		this.merchantProduct.add(products);
	}

	@Override
	public String toString() {
		return "Merchant [merchantMobileNo=" + merchantMobileNo + ", merchantName=" + merchantName + ", email=" + email
				+ ", password=" + password + ", merchantType=" + merchantType + ", addresses=" + addresses
				+ ", feedback=" + merchantFeedback + ", response=" + merchantResponse + ", products=" + merchantProduct + "]";
	}


}
