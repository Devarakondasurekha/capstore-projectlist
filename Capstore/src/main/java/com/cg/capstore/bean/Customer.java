package com.cg.capstore.bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer")
public class Customer
{
	@Id
	@Column(name="customer_mobile_no",length=10)
	private String customerMobileNo;
	@Column(name="name",length=50)
	private String name;
	@Column(name="email",length=70)
	private String email;
	@Column(name="password",length=20)
	private String password;
	@Column(name="gender",length=6)
	private String gender;
	@Column(name="dob",length=20)
	@Temporal(TemporalType.DATE)
	private Date dob;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="wishlist_id")
	private WishList wishlist;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;
	@OneToMany(mappedBy="customerCard",cascade=CascadeType.ALL)
	private List<SavedCardDetails> cardDetail=new ArrayList<>();
	@Column(name="active",length=5)
	private boolean active;
	@OneToMany(mappedBy="customerAddress",cascade=CascadeType.ALL)
	private List<Address> adresses=new ArrayList<>();
	
	@ManyToMany(mappedBy="customerFeedbacks",cascade=CascadeType.ALL)
	private List<Feedback> customerfeedback=new ArrayList<>();
	
	@ManyToMany(mappedBy="customerResponses",cascade=CascadeType.ALL)
	private List<Response> response=new ArrayList<>();

	@ManyToMany(mappedBy="customerOrders",cascade=CascadeType.ALL)
	private List<Orders> customerOrder=new ArrayList<>();
	
	public Customer() 
	{
		super();
	}

	public Customer(String customerMobileNo, String name, String email, String password, String gender, Date dob,
			WishList wishlist, Cart cart, SavedCardDetails cardDetail, boolean active, Address adresses,
			Feedback customerfeedback,Response response, Orders customerOrder) {
		super();
		this.customerMobileNo = customerMobileNo;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.wishlist = wishlist;
		this.cart = cart;
		this.cardDetail.add(cardDetail);
		this.active = active;
		this.adresses.add(adresses);
		this.customerfeedback.add(customerfeedback);
		this.response.add(response);
		this.customerOrder.add(customerOrder);
	}

	public String getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public WishList getWishlist() {
		return wishlist;
	}

	public void setWishlist(WishList wishlist) {
		this.wishlist = wishlist;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<SavedCardDetails> getCardDetail() {
		return cardDetail;
	}

	public void setCardDetail(SavedCardDetails cardDetail) {
		this.cardDetail.add(cardDetail);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(Address adresses) {
		this.adresses.add(adresses);
	}

	public List<Feedback> getCustomerfeedback() {
		return customerfeedback;
	}

	public void setCustomerfeedback(Feedback customerfeedback) {
		this.customerfeedback.add(customerfeedback);
	}

	public List<Response> getResponse() {
		return this.response;
	}

	public void setResponse(Response response) {
		this.response.add(response);
	}
	

	public List<Orders> getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(List<Orders> customerOrder) {
		this.customerOrder = customerOrder;
	}

	@Override
	public String toString() {
		return "Customer [customerMobileNo=" + customerMobileNo + ", name=" + name + ", email=" + email + ", password="
				+ password + ", gender=" + gender + ", dob=" + dob + ", wishlist=" + wishlist + ", cart=" + cart
				+ ", cardDetail=" + cardDetail + ", active=" + active + ", adresses=" + adresses + ", customerfeedback="
				+ customerfeedback + ", Response=" + response + ", customerOrder=" + customerOrder + "]";
	}

	
	
	
}

