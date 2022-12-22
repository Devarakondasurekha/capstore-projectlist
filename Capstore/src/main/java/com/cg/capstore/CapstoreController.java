package com.cg.capstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capstore.bean.Address;
import com.cg.capstore.bean.Customer;
import com.cg.capstore.bean.Feedback;
import com.cg.capstore.bean.Merchant;
import com.cg.capstore.bean.Product;
import com.cg.capstore.service.ICapstoreService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/")
public class CapstoreController {
	String id;
	@Autowired
	ICapstoreService capstoreService;

//--------------------------------------------------------------------------------------------------//
//=====================Customer=====================================================================//
	@RequestMapping("/")
	public String home(ModelMap modelMap) {
		modelMap.addAttribute("map", capstoreService.homepage());
		return "/views/customer/index.jsp";
	}

	@RequestMapping("/getContact")
	public String getContact() {
		return "/views/customer/contact.jsp";
	}
	
	
	
	@RequestMapping("/err")
	public String geterr() {
		return "/views/maintaince.jsp";
	}
	
	
	
	@RequestMapping("/getLogin")
	public String login() {
		return "/views/login.jsp";
	}
	@RequestMapping("/search")
	public String searchByName(@RequestParam("search")String name,ModelMap model) 
	{
		List<Product> product=capstoreService.findProductsByName(name);
	Map<String,List<Product>> categoryMap=new HashMap<>();
	categoryMap.put(product.get(0).getProdCategory(),product);
		
		model.addAttribute("map", categoryMap);
		return "/views/customer/index.jsp";
	}


	@RequestMapping(method = RequestMethod.POST, value = "validateUser")
	public String validate(@RequestParam(value = "mobileNo") String mobileNo,@RequestParam(value = "password") String password, ModelMap modelMap, HttpServletRequest request) {

		Map<String, List<Product>> list = capstoreService.homepage();
		modelMap.addAttribute("map", capstoreService.homepage());

		if (mobileNo.equals("7530124558") && password.equals("admin")) {
			Gson gsonObj = new Gson();
			Map<Object,Object> map = null;
			List<Map<Object,Object>> listOfObject = new ArrayList<Map<Object,Object>>();
				
			Map<String,Integer> SM=capstoreService.businessAnalyst();
			
			
			for(Entry<String, Integer> m:SM.entrySet())
			{
				map = new HashMap<Object,Object>();
				map.put("label",m.getKey()); 
				map.put("y", m.getValue());
				listOfObject.add(map);

			}
			 	
				
				
			String dataPoints = gsonObj.toJson(listOfObject);

			
			
			
			modelMap.addAttribute("analysis",dataPoints);	
			
			
			
			request.getSession().setAttribute("sessionid", mobileNo);
			return "/views/admin/AdminHome.jsp";
		}
		String user = capstoreService.validateUser(mobileNo, password);

		if (user.equals("merchantpage")) {
			
			List<Product> listofMerchantProduct=capstoreService.findAllProductsMerchant(mobileNo);
			Map<String,Integer> map=new HashMap<>();
			for(Product i:listofMerchantProduct)
			{
				
					map.put(i.getName(), i.getInitialQuantity()-i.getAvailableQuantity());
			}
			Gson gsonObj=new Gson();
			Map<Object,Object> map1=null;
			List<Map<Object,Object>> listOfObject=new ArrayList<Map<Object,Object>>();

			
			for(Entry<String, Integer> m:map.entrySet())
			{
				map1 = new HashMap<Object,Object>();
				map1.put("label",m.getKey()); 
				map1.put("y", m.getValue());
				listOfObject.add(map1);

			}
			 	
				
				
			String dataPoints = gsonObj.toJson(listOfObject);
			
			modelMap.addAttribute("analysis",dataPoints);	
			
			
			
			
			request.getSession().setAttribute("sessionid", mobileNo);
			return "/views/merchant/merchant_home.jsp";
		}

		else if (user.equals("home")) {
			request.getSession().setAttribute("sessionid", mobileNo);
			return "/views/customer/home.jsp";
		}
		return "/views/login.jsp";
	}
	
	  
	 @RequestMapping("/registerAsCustomer") public String registerCustomer() {
	  
	  return "/views/customer/registerCustomer.jsp"; }
	  
	  
	 @RequestMapping(value="/customeraddresspage") public String
	  addAddress(@Valid @ModelAttribute("customer") Customer customer) {
	 
	  capstoreService.registerCustomer(customer);
	 id=customer.getCustomerMobileNo(); return
	  "/views/customer/customeraddresspage.jsp"; }
	  
	  
	  
	  @RequestMapping(value="/success") public String
	  registered(@Valid @ModelAttribute("address") Address address) {
	  
	  capstoreService.addAddress(address,id); return "/views/customer/success.jsp";
	  }
	  
	  
	  @RequestMapping(value="/merchantsuccess") public String
	  merchantRegistered(@Valid @ModelAttribute("address") Address address) {
	  
	  capstoreService.addMerchantAddress(address,id); return
	  "/views/admin/AdminMerchantSuccess.jsp"; }
	  
	  
	  @RequestMapping("/registerAsMerchant")
	  public String registerMerchant()
	  {
	  
	  return "/views/merchant/registerMerchant.jsp";
	 
	 
	 }
	  
	 @RequestMapping(value="/merchantaddresspage") 
	 public String addAddress(@Valid @ModelAttribute("merchant") Merchant merchant) {
	  capstoreService.registerMerchant(merchant);
	  id=merchant.getMerchantMobileNo();
	 return  "/views/merchant/merchantaddresspage.jsp";
	 }
	  
	  
	  @RequestMapping(value="/profile") public String addAddress() 
	  {
		  
	  
	  
//	  capstoreService.registerMerchant(merchant);
//	  id=merchant.getMerchantMobileNo(); 
		  return "/views/customer/customer.jsp";
	  }
	  
	  
	  @RequestMapping(value="/ordered")
		public String myOrder(Model model,HttpServletRequest request)
		{
			List<Product> products=capstoreService.findAllProductsCustomer((String)request.getSession().getAttribute("sessionid"));
			
			model.addAttribute("products", products);
			return "/views/customer/ordered.jsp";
	}
	  
	  

		@RequestMapping(value="/return")
		public String returnpage(@RequestParam ("id") String productid,Model model)
		{
			capstoreService.returnGood(productid);
			model.addAttribute("prodid", productid);
			return "/views/customer/returnPage.jsp";
		}
	  
	  
	  
	  @RequestMapping(value="/profilepage") public String changeProfile(){
	  
	 return "/views/customer/profile.jsp"; }
	  
	  
	  @RequestMapping("/change") public String change(Customer customer) {
	  capstoreService.changeProfile(customer);
	  
	  
	  return "/views/customer/sucess.jsp";
	  
	  
	  }
	  
	  //]===============================================[//
	 
	  
	  @RequestMapping("/getCategory")
		public  String categoryProduct(@RequestParam("category")String prodCategory, Model model) {
			Query query;
			
			Map<String,List<Product>> categoryMap = new HashMap<>();
			
			
			
			List<Product> productList=capstoreService.getCategoryProduct(prodCategory);
			categoryMap.put(prodCategory, productList);
			model.addAttribute("map", categoryMap);
			return "/views/customer/index.jsp";
			
			
		}
		

	  @RequestMapping(value="/getProduct")
	    public ModelAndView getProductPage(@RequestParam("id") String productId,HttpServletRequest request,ModelMap modelMap ) {
	        
	        List<Feedback> feedback=new ArrayList<>();
	        Product product=capstoreService.getProductPage(productId);
	        
	        List<Product> cartProdList= new ArrayList<>();
	        
	        String sess = (String) request.getSession().getAttribute("sessionid");
	        if (sess == null) {
	            cartProdList.add(product);
	        }
	        else
	        {
	               String  customerMobileNo=request.getSession().getAttribute("sessionid").toString();
	               cartProdList=capstoreService.findAllProductsCustomer(customerMobileNo);
	               feedback=capstoreService.productFeedback(productId);
	        }
	           modelMap.addAttribute("feedback", feedback);
	           modelMap.addAttribute("prodList", cartProdList);
	            
	    
	        
	        return new ModelAndView("/views/customer/product.jsp","product",product);
	    }
	    
		@RequestMapping(value="/removeCartProduct")
		public ModelAndView removeCartProduct(@RequestParam("removeid")String removeProductId,@RequestParam("currentid")String currentProductId, HttpServletRequest request,ModelMap modelMap  ) {
		
			
			
			String customerMobileNo=request.getSession().getAttribute("sessionid").toString();
		
			capstoreService.removeCustomerProduct(customerMobileNo, removeProductId);
			List<Product> cartProdList=capstoreService.findAllProductsCustomer(customerMobileNo);
			Product product=capstoreService.getProductPage(currentProductId);
			modelMap.addAttribute("prodList", cartProdList);
			
			return new ModelAndView("/views/customer/product.jsp","product",product);
		}
		
		@RequestMapping(value="/addToCart")
		public ModelAndView addCartProduct(@RequestParam("id")String productId, HttpServletRequest request,ModelMap modelMap  ) {
		
			
			
			String customerMobileNo=request.getSession().getAttribute("sessionid").toString();
			capstoreService.addCartProduct(customerMobileNo, productId);
			List<Product> cartProdList=capstoreService.findAllProductsCustomer(customerMobileNo);
			Product product=capstoreService.getProductPage(productId);
			
			
			modelMap.addAttribute("prodList", cartProdList);
			
			return new ModelAndView("/views/customer/product.jsp","product",product);
		}
		
		@RequestMapping(value="/getCheckout")
		public String getCheckoutPage(@RequestParam("totalPrice") String totalPrice,ModelMap modelMap ) {
			modelMap.addAttribute("totalPrice",totalPrice);
			return "/views/customer/checkout.jsp";
		}
		
		@RequestMapping(value="/Invoice")
		public String invoice(@RequestParam("totalPrice") String totalPrice,HttpServletRequest request ,ModelMap modelMap  ){
			String customerMobileNo=request.getSession().getAttribute("sessionid").toString();
			List<Product> cartProdList=capstoreService.findAllProductsCustomer(customerMobileNo);
			modelMap.addAttribute("list",cartProdList);
			modelMap.addAttribute("totalPrice",totalPrice);
			return "/views/customer/Invoice.jsp";  
		}
		
		@RequestMapping(value="/getLogout")
		public String Logout(HttpServletRequest request){
			request.getSession().invalidate();
			return "/views/customer/home.jsp";  
		}
	  
	  
	  
//------------------------------------------------------------------------------------------------//
//====================================ADMIN======================================================//

	@RequestMapping(value = "/admin_order_confirmed")
	public String getOrderConfirmationPage(ModelMap map) {
		map.addAttribute("orders", capstoreService.orders("Confirmed"));
		return "/views/admin/ConfirmedProducts.jsp";

	}

	@RequestMapping(value = "/admin_order_deliver")
	public String getOrderDeliverPage(ModelMap map) {
		map.addAttribute("orders", capstoreService.orders("Delivered"));
		return "/views/admin/DeliveredProducts.jsp";

	}

	@RequestMapping(value = "/admin_order_returned")
	public String getOrderReturnPage(ModelMap map) {
		map.addAttribute("orders", capstoreService.orders("Returned"));
		return "/views/admin/ReturnedProducts.jsp";

	}

	@RequestMapping(value = "/admin_add_product")
	public String getAddProductPage() {
		return "/views/admin/AdminAddProduct.jsp";
	}

	@RequestMapping(value = "/admin_remove_products")
	public String getRemoveProductPage(ModelMap model) {
		List<Product> prod = capstoreService.findAllProduct();

		model.addAttribute("abc", prod);
		return "/views/admin/AdminRemoveProduct.jsp";
	}

	@RequestMapping("/AdminRegisterMerchant")
	public String registerAdminMerchant() {
		return "/views/admin/AdminMerchantRegister.jsp";
	}

	@RequestMapping(value = "/AdminMerchantAddress")
	public String addMerchantAddress(@Valid @ModelAttribute("merchant") Merchant merchant) {
		capstoreService.registerMerchant(merchant);
		id = merchant.getMerchantMobileNo();
		return "/views/admin/AdminMerchantAddress.jsp";
	}

	@RequestMapping(value = "/AdminMerchantSuccess")
	public String AdminMerchantRegistered(@Valid @ModelAttribute("address") Address address) {
		capstoreService.addMerchantAddress(address, id);
		return "/views/admin/AdminMerchantSuccess.jsp";
	}

	@RequestMapping(value = "/adminDeleteProduct")
	public String getRemoveProductPage(@RequestParam("id") String prodId, ModelMap model) {
		capstoreService.deleteProductById(prodId);
		List<Product> prod = capstoreService.findAllProduct();
		model.addAttribute("abc", prod);
		return "/views/admin/AdminRemoveProduct.jsp";
	}

	@RequestMapping(value = "/AdminDeleteMerchant")
	public String getdeleteMerchantPage(ModelMap model)
	{
		List<Merchant> merchant = capstoreService.findAllMerchant();
		model.addAttribute("merchants", merchant);
		return "/views/admin/AdminRemoveMerchant.jsp";

	}
	
	@RequestMapping(value = "/AdminRemoveMerchant")
	public String getRemoveMerchantPage(@RequestParam("id") String merchantId, ModelMap model) {
		capstoreService.deleteMerchantById(merchantId);
		List<Merchant> merchant = capstoreService.findAllMerchant();
		model.addAttribute("merchants", merchant);
		return "/views/admin/AdminRemoveMerchant.jsp";
	}

	@RequestMapping(value = "/admin_all_customers")
	public String getCustomersPage(ModelMap model) {
		List<Customer> customer = capstoreService.findAllCustomer();
		model.addAttribute("customers", customer);
		return "/views/admin/AdminAllCustomers.jsp";

	}

	@RequestMapping(value = "/admin_all_merchants")
	public String getMerchantPage(ModelMap model) {
		List<Merchant> merchant = capstoreService.findAllMerchant();
		model.addAttribute("merchants", merchant);
		return "/views/admin/AdminAllMerchants.jsp";

	}

	@RequestMapping(value = "/admin_all_products")
	public String getProductPage(Model model) {
		List<Product> prod = capstoreService.findAllProduct();
		model.addAttribute("products", prod);
		return "/views/admin/AdminAllProducts.jsp";

	}

	@RequestMapping(value = "/Adminsuccess")
	public String Success(@ModelAttribute("addProduct") Product product, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("sessionid");
		id = capstoreService.addAdminProduct(product, admin_id);
		return "/views/admin/Success.jsp";

	}

//------------------------------------------------------------------------------------------//
//====================Merchant==============================================================//


	@RequestMapping(value="/discount")
	public String afterDiscountHome(@ModelAttribute Product product)
	{
		Product prod=capstoreService.addDiscount(product);
		return "/views/merchant/merchant_home.jsp";
		
	}
	@RequestMapping(value="/merchantHome")
	public String merchantHome(@ModelAttribute("merchant") Merchant merchant)
	{
		Merchant merchantupdated=capstoreService.changePassword(merchant);
		return "/views/merchant/merchant_home.jsp";
		
	}
	@RequestMapping(value="/updatedProduct")
	public String updatedProductDetails(@ModelAttribute("product") Product product,@RequestParam("Id") String prodId)
	{
		Product updatedProduct=capstoreService.updateProduct(product,prodId);
		return "/views/merchant/merchant_home.jsp";
		
	}
	@RequestMapping(value="/merchant_display_products")
	public String myOrders(Model model,HttpServletRequest request)
	{
		List<Product> products=capstoreService.findAllProductsMerchant((String)request.getSession().getAttribute("sessionid"));
		
		model.addAttribute("prod", products);
		return "/views/merchant/merchant_display_products.jsp";
	}
	
	
	@RequestMapping(value="/merchant_add_product")
	public String getaddCategoryPage()
	{
		return "/views/merchant/merchant_add_product.jsp";
		
	}
	@RequestMapping(value="/merchant_change_password")
	public String getaddMerchantPage()
	{
		return "/views/merchant/merchant_change_password.jsp";
		
	}
	@RequestMapping(value="/merchant_check_order_details")
	public String getCustomersPage()
	{
		return "/views/merchant/merchant_check_order_details.jsp";
		
	}
	@RequestMapping(value="/merchant_delete_product")
	public String getMerchantPage(Model model,HttpServletRequest request)
	{
		List<Product> product=capstoreService.findAllProductsMerchant((String)request.getSession().getAttribute("sessionid"));
		model.addAttribute("products", product);
		return "/views/merchant/merchant_delete_product.jsp";
		
	}
	@RequestMapping(value="/deleteProduct")
	public String updatedProducts(@RequestParam("id") String prodId,Model model,HttpServletRequest request)
	{
		capstoreService.deleteProduct(prodId);
		List<Product> product=capstoreService.findAllProductsMerchant((String)request.getSession().getAttribute("sessionid"));
		model.addAttribute("products", product);
		return "/views/merchant/merchant_delete_product.jsp";
		
	}
	@RequestMapping(value="/Success")
	public String successRegister(@ModelAttribute("product") Product product,HttpServletRequest request)
	{
		Random random=new Random();
		String prodId="P"+Integer.toString(random.nextInt(100));
		product.setProdId(prodId);
		capstoreService.addProduct(product,(String)request.getSession().getAttribute("sessionid"));
		return "/views/merchant/merchant_home.jsp";
		
	}
	
	@RequestMapping(value="/merchant_discounts")
	public String productDiscount()
	{
		
		
		return "/views/merchant/merchant_discounts.jsp";
		
	}
	
	@RequestMapping(value="/merchant_update_product")
	public String updateProduct(@RequestParam("id") String prodId,Model model)
	{
		//Product product=new Product();
		model.addAttribute("prodid", prodId);
		//model.addAttribute("product", product);
		return "/views/merchant/merchant_update_product.jsp";
		
	}
	


}
