package com.cg.capstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.Address;
import com.cg.capstore.bean.Customer;
import com.cg.capstore.bean.Feedback;
import com.cg.capstore.bean.Merchant;
import com.cg.capstore.bean.Orders;
import com.cg.capstore.bean.Product;
import com.cg.capstore.dao.ICapstoreDao;

@Service

public class CapstoreServiceImpl implements ICapstoreService 
{
	
	@Autowired
	ICapstoreDao capstoreDao;
	
	

	@Override
	public Map<String, List<Product>> homepage() {
	
		return capstoreDao.homepage();
	}



	@Override
	public String validateUser(String mobileNo, String password) 
	{
		return capstoreDao.validateUser(mobileNo, password);
	}



	@Override
	public Customer registerCustomer(Customer customer) {
		return capstoreDao.registerCustomer(customer) ;
	}



	@Override
	public Address addAddress(Address address, String id) {
		return capstoreDao.addAddress(address, id);
	}



	@Override
	public Merchant registerMerchant(Merchant merchant) {
		return capstoreDao.registerMerchant(merchant);
	}



	@Override
	public Address addMerchantAddress(Address address, String id) {
		return  capstoreDao.addMerchantAddress(address, id);
	}



	@Override
	public Customer changeProfile(Customer customer) {
		return capstoreDao.changeProfile(customer);
	}



	@Override
	public List<Product> findAllProduct()
	{
		return capstoreDao.findAllProduct();
	}



	@Override
	public Product deleteProductById(String prodId)
	{
		return capstoreDao.deleteProductById(prodId);
	}



	@Override
	public List<Orders> orders(String status)
	{
		return capstoreDao.orders(status);
	}



	@Override
	public List<Merchant> findAllMerchant() {
		return capstoreDao.findAllMerchant();
	}



	@Override
	public List<Customer> findAllCustomer() {
		return capstoreDao.findAllCustomer();
	}



	@Override
	public String addAdminProduct(Product product,String admin_id) 
	{
		return capstoreDao.addAdminProduct(product,admin_id);
	}
	
	@Override
	public String addMerchantProduct(Product product) 
	{
		return capstoreDao.addMerchantProduct(product);
	}



	@Override
	public void returnGood(String productid) {
		capstoreDao.returnGood(productid);
		
	}



	@Override
	public List<Product> findAllProductsBasedOnId(String mobile) {
		
		return capstoreDao.findAllProductsBasedOnId(mobile);
	}



	@Override
	public Merchant deleteMerchantById(String merchantId) {
		
		return capstoreDao.deleteMerchantById(merchantId);
	}



	@Override
	public Map<String, Integer> businessAnalyst() {
		return capstoreDao.businessAnalyst();
	}



	@Override
	public List<Product> findAllProductsMerchant(String mobileNo) {
		return capstoreDao.findAllProductsMerchant(mobileNo);
	}



	@Override
	public Product addProduct(Product product,String merchantMobileNo) 
	{
		return capstoreDao.addProduct(product, merchantMobileNo);
	}



	@Override
	public void deleteProduct(String product) {
		capstoreDao.deleteProduct(product);
		
	}



	@Override
	public Orders checkOrderDetails(Orders order) {
		return capstoreDao.checkOrderDetails(order);	}



	@Override
	public Merchant changePassword(Merchant merchant) {
		return capstoreDao.changePassword(merchant);
	}



	@Override
	public Product updateProduct(Product product, String prodId) {
		return capstoreDao.updateProduct(product, prodId);
	}



	@Override
	public Product addDiscount(Product product) {
		return capstoreDao.addDiscount(product);
	}



	@Override
	public List<Product> getCategoryProduct(String prodCategory) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Product getProductPage(String productId) {
		return capstoreDao.getProductPage(productId);
	}



	@Override
	public List<Product> findAllProductsCustomer(String customerMobileNo) {
		return capstoreDao.findAllProductsCustomer(customerMobileNo);
	}



	@Override
	public void removeCustomerProduct(String customerMobileNo, String removeProductId) {
		capstoreDao.removeCustomerProduct(customerMobileNo, removeProductId);
		
	}



	@Override
	public void addCartProduct(String customerMobileNo, String productId) {
		capstoreDao.addCartProduct(customerMobileNo, productId);
		
	}
	public List<Product> findProductsByName(String name) {
        return capstoreDao.findProductsByName(name);
        
    }
	
	public List<Feedback> productFeedback(String prodId) 
    {
        return capstoreDao.productFeedback(prodId);
    }


	
}
