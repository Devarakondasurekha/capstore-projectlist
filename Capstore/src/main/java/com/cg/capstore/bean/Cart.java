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
@Table(name="cart")
public class Cart
{
	@Id
	@Column(name="cart_id")
	private String cartId;
	
	@ManyToMany(mappedBy="cartProducts",cascade=CascadeType.ALL)
	private List<Product> cartProduct = new ArrayList<>();
	
	public Cart() 
	{
		super();
	}
	public Cart(String cartId, Product products) {
		super();
		this.cartId = cartId;
		this.cartProduct.add(products);
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public List<Product> getProducts() {
		return cartProduct;
	}
	public void setProducts(Product products) {
		this.cartProduct.add(products);
	}
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + cartProduct + "]";
	}
	
}
