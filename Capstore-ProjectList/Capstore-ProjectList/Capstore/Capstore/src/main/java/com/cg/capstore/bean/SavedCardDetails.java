package com.cg.capstore.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "savedcard")
public class SavedCardDetails 
{
	@Id
	@Column(name="sno")
	private String sno;
	@Column(name="card_holder_name",length=50)
	private String cardHolderName;
	@Column(name="cardno",length=16)
	private String CardNumber;
	@Column(name="expirymonth",length=2)
	private  int expiryMonth;
	@Column(name="expiry_year",length=4)
	private int expiryYear;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customerCard;
	
	public SavedCardDetails() 
	{
		super();
	}

	public SavedCardDetails(String sno, String cardHolderName, String cardNumber, int expirymonth, int expiryYear,
			Customer customerCard) {
		super();
		this.sno = sno;
		this.cardHolderName = cardHolderName;
		CardNumber = cardNumber;
		this.expiryMonth = expirymonth;
		this.expiryYear = expiryYear;
		this.customerCard = customerCard;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public int getExpirymonth() {
		return expiryMonth;
	}

	public void setExpirymonth(int expirymonth) {
		this.expiryMonth = expirymonth;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	public Customer getCustomerCard() {
		return customerCard;
	}

	public void setCustomerCard(Customer customerCard) {
		this.customerCard = customerCard;
	}

	@Override
	public String toString() {
		return "SavedCardDetails [sno=" + sno + ", cardHolderName=" + cardHolderName + ", CardNumber=" + CardNumber
				+ ", expirymonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", customerCard=" + customerCard
				+ "]";
	}
}
