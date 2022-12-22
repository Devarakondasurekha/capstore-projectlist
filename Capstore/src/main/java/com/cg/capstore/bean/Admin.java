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
@Table(name="capstore_admin")
public class Admin
{
	@Id
	@Column(name="mobile_no",length=10)
	private String mobileNo;
	@Column(name="name",length=50)
	private String name;
	@Column(name="password",length=20)
	private String password;
	@Column(name="email",length=70)
	private String email;
	
	@ManyToMany(mappedBy="adminProducts",cascade=CascadeType.ALL)
	private List<Product> adminProduct = new ArrayList<>();
	
	public Admin()
	{
		super();
	}

	public Admin(String mobileNo, String name, String password, String email,Product products) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.password = password;
		this.email = email;
		this.adminProduct.add(products);
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Product> getProducts() {
		return adminProduct;
	}

	public void setProducts(Product products) {
		this.adminProduct.add(products);
	}

	@Override
	public String toString() {
		return "Admin [mobileNo=" + mobileNo + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", products=" + adminProduct + "]";
	}

	
}
