package com.cg.capstore.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address 
{
	@Id
	@Column(name="address_id",length=10)
	private String addressId;
	@Column(name="houseNo",length=10)
	private String houseNo;
	@Column(name="area",length=20)
	private String area;
	@Column(name="city",length=20)
	private String city;
	@Column(name="pincode",length=6)
	private String pincode;
	@Column(name="states",length=30)
	private String states;
	@Column(name="landmark",length=50)
	private String landmark;
	@Column(name="name",length=50)
	private String name;
	@Column(name="alternate_mobile",length=10)
	private String alternateMobileNo;
	@Column(name="address_type",length=10)
	private String addressType;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customerAddress;
	
	@ManyToOne
	@JoinColumn(name="merchant_id")
	private Merchant merchantAddress;
	
	public Address()
	{
		super();
	}

	public Address(String addressId, String houseNo, String area, String city, String pincode, String states,
			String landmark, String name, String alternateMobileNo, String addressType, Customer customerAddress,
			Merchant merchantAddress) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.states = states;
		this.landmark = landmark;
		this.name = name;
		this.alternateMobileNo = alternateMobileNo;
		this.addressType = addressType;
		this.customerAddress = customerAddress;
		this.merchantAddress = merchantAddress;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlternateMobileNo() {
		return alternateMobileNo;
	}

	public void setAlternateMobileNo(String alternateMobileNo) {
		this.alternateMobileNo = alternateMobileNo;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public Customer getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Customer customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Merchant getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(Merchant merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNo=" + houseNo + ", area=" + area + ", city=" + city
				+ ", pincode=" + pincode + ", states=" + states + ", landmark=" + landmark + ", name=" + name
				+ ", alternateMobileNo=" + alternateMobileNo + ", addressType=" + addressType + ", customerAddress="
				+ customerAddress + ", merchantAddress=" + merchantAddress + "]";
	}
	
}
