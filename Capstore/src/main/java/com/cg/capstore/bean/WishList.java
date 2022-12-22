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
@Table(name="wishlist")
public class WishList 
{
	@Id
	@Column(name="wishlist_id")
	private String wishlistId;
	@ManyToMany(mappedBy="wishlistProducts",cascade=CascadeType.ALL)
	private List<Product> wishlistProd=new ArrayList<>();
	
	public WishList()
	{
		super();
	}

	public WishList(String wishlistId,Product wishlistProd) {
		super();
		this.wishlistId = wishlistId;
		this.wishlistProd.add(wishlistProd);
	}

	public String getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(String wishlistId) {
		this.wishlistId = wishlistId;
	}

	public List<Product> getWishlistProd() {
		return wishlistProd;
	}

	public void setWishlistProd(Product wishlistProd) {
		this.wishlistProd.add(wishlistProd);
	}

	@Override
	public String toString() {
		return "WishList [wishlistId=" + wishlistId + ", wishlistProd=" + wishlistProd + "]";
	}

	
	
}
