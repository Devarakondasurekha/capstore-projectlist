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
@Table(name="product")
public class Product
{
	@Id
	@Column(name="prod_id",length=10)
	private String prodId;
	@Column(name="name",length=70)
	private String name;
	@Column(name="sizes",length=5)
	private String sizes;
	@Column(name="inital_quantity",length=5)	
	private int initialQuantity;
	@Column(name="available_quantity",length=5)	
	private int availableQuantity;
	@Column(name="price",length=6)
	private double price;
	@Column(name="rating",length=5)
	private double rating;
	@Column(name="prodCategory",length=50)
	private String prodCategory;
	@Column(name="discount",length=5)
	private double prodDiscount;
	@Column(name="url")
	private String url;
	
	
	@ManyToMany(mappedBy="productCoupons",cascade=CascadeType.ALL)
	private List<Coupon> productCoupon=new ArrayList<>();
	
	
	
	@ManyToMany
	@JoinTable(name="merchant_product",joinColumns=@JoinColumn(name="prod_id"),
				inverseJoinColumns=@JoinColumn(name="merchant_id"))
	private List<Merchant> merchantProducts=new ArrayList<>();
	
	
	@ManyToMany(mappedBy="prodImages",cascade=CascadeType.ALL)
	private List<Image> prodImage=new ArrayList<>();

	
	@ManyToMany(mappedBy="prodFeedbacks",cascade=CascadeType.ALL)
	private List<Feedback> prodFeedback=new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="wishlist_product",
				joinColumns=@JoinColumn(name="prod_id"),
				inverseJoinColumns=@JoinColumn(name="wishlist_id"))
	private List<WishList> wishlistProducts=new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="orders_product",
				joinColumns=@JoinColumn(name="prod_id"),
				inverseJoinColumns=@JoinColumn(name="order_id"))
	private List<Orders> ordersProduct=new ArrayList<>();
	
	@ManyToMany
	private List<Cart> cartProducts=new ArrayList<>();

	@ManyToMany
	@JoinTable(name="admin_product"
					,joinColumns=@JoinColumn(name="prod_id")
					,inverseJoinColumns= {@JoinColumn(name="admin_id")}
			  )
	private List<Admin> adminProducts = new ArrayList<>();

	
	public Product() 
	{
		super();
	}



	public Product(String prodId, String name, String sizes, int initialQuantity, int availableQuantity, double price,
			double rating, String prodCategory, double prodDiscount, String url, Coupon productCoupon,
			Merchant merchantProduct, Image prodImage, Feedback prodFeedback,
			WishList wishlistProducts, Orders ordersProduct, Cart cartProducts,Admin admin) {
		super();
		this.prodId = prodId;
		this.name = name;
		this.sizes = sizes;
		this.initialQuantity = initialQuantity;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.rating = rating;
		this.prodCategory = prodCategory;
		this.prodDiscount = prodDiscount;
		this.url = url;
		this.productCoupon.add(productCoupon);
		this.merchantProducts.add(merchantProduct);
		this.prodImage.add(prodImage);
		this.prodFeedback.add(prodFeedback);
		this.wishlistProducts.add(wishlistProducts);
		this.ordersProduct.add(ordersProduct);
		this.cartProducts.add(cartProducts);
		this.adminProducts.add(admin);
	}



	public String getProdId() {
		return prodId;
	}



	public void setProdId(String prodId) {
		this.prodId = prodId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSizes() {
		return sizes;
	}



	public void setSizes(String sizes) {
		this.sizes = sizes;
	}



	public int getInitialQuantity() {
		return initialQuantity;
	}



	public void setInitialQuantity(int initialQuantity) {
		this.initialQuantity = initialQuantity;
	}



	public int getAvailableQuantity() {
		return availableQuantity;
	}



	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	public String getProdCategory() {
		return prodCategory;
	}



	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}



	public double getProdDiscount() {
		return prodDiscount;
	}



	public void setProdDiscount(double prodDiscount) {
		this.prodDiscount = prodDiscount;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public List<Coupon> getProductCoupon() {
		return productCoupon;
	}



	public void setProductCoupon(Coupon productCoupon) {
		this.productCoupon.add(productCoupon);
	}



	public List<Merchant> getMerchantProduct() {
		return merchantProducts;
	}



	public void setMerchantProduct(Merchant merchantProduct) {
		this.merchantProducts.add(merchantProduct);
	}



	public List<Image> getProdImages() {
		return prodImage;
	}



	public void setProdImages(Image prodImages) {
		this.prodImage.add(prodImages);
	}



	public List<Feedback> getProdFeedback() {
		return prodFeedback;
	}



	public void setProdFeedback(Feedback prodFeedback) {
		this.prodFeedback.add(prodFeedback);
	}



	public List<WishList> getwishlistProducts() {
		return wishlistProducts;
	}



	public void setwishlistProducts(WishList wishlistProducts) {
		this.wishlistProducts.add(wishlistProducts);
	}



	public List<Orders> getOrdersProduct() {
		return ordersProduct;
	}



	public void setOrdersProduct(Orders ordersProduct) {
		this.ordersProduct.add(ordersProduct);
	}



	public List<Cart> getCartProduct() {
		return cartProducts;
	}



	public void setCartProduct(Cart cartProduct) {
		this.cartProducts.add(cartProduct);
	}


	
	public List<Admin> getAdminProduct() {
		return adminProducts;
	}



	public void setAdminProduct(Admin adminProduct) {
		this.adminProducts.add(adminProduct);
	}



	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", name=" + name + ", sizes=" + sizes + ", initialQuantity="
				+ initialQuantity + ", availableQuantity=" + availableQuantity + ", price=" + price + ", rating="
				+ rating + ", prodCategory=" + prodCategory + ", prodDiscount=" + prodDiscount + ", url=" + url
				+ ", productCoupon=" + productCoupon + ", merchantProduct=" + merchantProducts + ", prodImages="
				+ prodImage + ", prodFeedback=" + prodFeedback + ", wishlistProducts=" + wishlistProducts + ", ordersProduct="
				+ ordersProduct + ", cartProduct=" + cartProducts + ", adminProduct=" + adminProducts + "]";
	}
}
