<%@page import="com.cg.capstore.bean.Product"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Capstore | Product</title>

<!-- Favicon  -->
<link rel="icon" href="../resources/img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="../resources/css/core-style.css">
<link rel="stylesheet" href="../resources/css/style.css">

</head>

<body>

    <%--    <% String sess = (String) request.getSession().getAttribute("sessionid");
    if (sess == null) { 
        response.sendRedirect("/getLogin");
    }  else {
    %> --%>
    <!-- ##### Header Area Start ##### -->
    <header class="header_area">
        <div
            class="classy-nav-container breakpoint-off d-flex align-items-center justify-content-between">
            <!-- Classy Menu -->
            <nav class="classy-navbar" id="essenceNav">
                <!-- Logo -->
                <a class="nav-brand" href="/">CapStore</a>
                <!-- Navbar Toggler -->
                <div class="classy-navbar-toggler">
                    <span class="navbarToggler"><span></span><span></span><span></span></span>
                </div>
                <!-- Menu -->
                <div class="classy-menu">
                    <!-- close btn -->
                    <div class="classycloseIcon">
                        <div class="cross-wrap">
                            <span class="top"></span><span class="bottom"></span>
                        </div>
                    </div>
                    <!-- Nav Start -->
                    <div class="classynav">
                        <ul>

                            <li><a href="contact.html">Contact</a></li>
                        </ul>
                    </div>
                    <!-- Nav End -->
                </div>
            </nav>

            <!-- Header Meta Data -->
            <div class="header-meta d-flex clearfix justify-content-end">
                <!-- Search Area -->
                <div class="search-area">
                    <form action="/search" method="get">
                        <input type="search" name="search" id="headerSearch"
                            placeholder="Type for search">
                        <button type="submit">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </form>
                </div>
                <!-- User Login Info -->

                <%
                    String sessn = (String) request.getSession().getAttribute("sessionid");
                    if (sessn == null) {
                %>
                <div class="favourite-area">
                    <a href="#" data-toggle="modal" data-target="#registerModal">Register</a>
                </div>

                <div class="user-login-info">
                    <a href="getLogin">Sign In</a>
                </div>
                <%
                    } else {
                %>
                <!-- Favourite Area -->
                <!-- Cart Area -->

                <div class="cart-area">
                    <a href="profile" id="essenceUserBtn"><img
                        src="../resources/img/images.png" alt="" height="150px"
                        width="150px"><span> <!--add product quantity-->
                    </span></a>
                </div>
                <div class="user-login-info">
                    <a href="getLogout">Log Out</a>
                </div>
                <%
                    }
                %>

                <!-- Cart Area -->
                <div class="cart-area">
                    <a href="#" id="essenceCartBtn"><img
                        src="../resources/img/core-img/bag.svg" alt=""> <span></span></a>
                </div>
            </div>

        </div>
    </header>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Right Side Cart Area ##### -->
    <div class="cart-bg-overlay"></div>

    <div class="right-side-cart-area">

        <!-- Cart Button -->
        <div class="cart-button">
            <a href="#" id="rightSideCart"><img
                src="../resources/img/core-img/bag.svg" alt=""> <span></span></a>
        </div>

        <div class="cart-content d-flex">

            <!-- Cart List Area -->
            <div class="cart-list">
                <c:forEach items="${prodList}" var="prod">
                    <!-- Single Cart Item -->
                    <div class="single-cart-item">

                        <a href="#" class="product-image"> <img style="height: 190px"
                            src="${prod.url}" class="cart-thumb" alt=""> <!-- Cart Item Desc -->
                            <div class="cart-item-desc">


                                <span class="product-remove">
                                
                                <% String sessnn = (String) request.getSession().getAttribute("sessionid");
                                if (sessnn == null) { %> 
                                
                                <a href="/getLogin"><i class="fa fa-close" aria-hidden="true"></i></a>
                                
                                </span> 
                             
                                 <% } else { %>
 <a href="/removeCartProduct?removeid=${prod.prodId}&currentid=${product.prodId}"><i class="fa fa-close" aria-hidden="true"></i></a></span> 
                                    
                        <% } %> 
                                
                                    <span class="badge">${prod.name }</span>
                                <h6>${prod.prodCategory }</h6>
                                <p class="size">Size: S</p>
                                <p class="color">Discount:${prod.prodDiscount}%</p>
                                <p class="price">${prod.price}</p>
                            </div>
                        </a>

                    </div>
                </c:forEach>
            </div>

            <!-- Cart Summary -->
            <div class="cart-amount-summary">
                <%

double total=0;
double priceafterdiscount=0;

for(Product d:(List<Product>)request.getAttribute("prodList"))
{
    System.out.println("Discount "+d.getProdDiscount());
    priceafterdiscount+=d.getPrice()-(d.getPrice()*d.getProdDiscount())/100;
    //priceafterdiscount+=(d.getPrice()*d.getProdDiscount())/100;
    total=total+d.getPrice();   
    
    
}
    
double percent=20;


%>





                <h2>Summary</h2>
                <ul class="summary-table">
                    <li><span>subtotal:</span> <span><%=total %></span></li>
                    <li><span>delivery:</span> <span>Free</span></li>
                    <li><span>discount:</span> <span><%=percent %>%</span></li>
                    <li><span>total:</span> <span><%=priceafterdiscount %></span></li>
                </ul>
                <div class="checkout-btn mt-100">
                <% String sess = (String) request.getSession().getAttribute("sessionid");
                    if (sess == null) { %> 
                        <a href="/getLogin" class="btn essence-btn">check out</a>
                        <% } else { %>
                    <a href="/getCheckout?totalPrice=<%= priceafterdiscount %>" class="btn essence-btn">check out</a>
                        <% } %> 
        
                
                </div>
            </div>
        </div>
    </div>


    <!-- ##### Right Side Cart End ##### -->

    <!-- ##### Single Product Details Area Start ##### -->
    <section class="single_product_details_area d-flex align-items-center">

        <!-- Single Product Thumb -->
        <div class="single_product_thumb clearfix">
            <div class="product_thumbnail_slides owl-carousel">
                <img src="${product.url}" alt=""> <img src="${product.url}"
                    alt=""> <img src="${product.url}" alt="">
            </div>
        </div>
        <
        <!-- Single Product Description -->
        <div class="single_product_desc clearfix">
            <span>${product.prodId}</span> <a href="addToCart/${product.prodId}">
                <h2>${product.name}</h2>
            </a>
            <p class="product-price">${product.price}</p>
            <p class="product-desc">${product.prodCategory}</p>

            <!-- Form -->
            <form class="cart-form clearfix" method="post">
                <!-- Select Box -->
                <div class="select-box d-flex mt-50 mb-30">
                    <select name="select" id="productSize" class="mr-5">
                        <option value="value">Size: XL</option>
                        <option value="value">Size: X</option>
                        <option value="value">Size: M</option>
                        <option value="value">Size: S</option>
                    </select> <select name="select" id="productColor">
                        <option value="value">Color: Black</option>
                        <option value="value">Color: White</option>
                        <option value="value">Color: Red</option>
                        <option value="value">Color: Purple</option>
                    </select>
                </div>
                <!-- Cart & Favourite Box -->
                <div class="cart-fav-box d-flex align-items-center">
                    <!-- Cart -->
                    <% String sessnn = (String) request.getSession().getAttribute("sessionid");
                    if (sessnn == null) { %> 
                        <a href="/getLogin" class="btn essence-btn">Add to cart</a>
                        <% } else { %>
                    <a href="/addToCart/?id=${product.prodId}"
                        class="btn essence-btn">Add to cart</a>
                        <% } %> 
        
        <c:forEach items="${feedback}" var="feeback">
        
        ${feeback.description}${feeback.rating}
     
        </c:forEach>
        
                    
                    <!-- Favourite -->
                    <div class="product-favourite ml-4">
                        <a href="#" class="favme fa fa-heart"></a>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <!-- ##### Single Product Details Area End ##### -->

    <!-- ##### Footer Area Start ##### -->
 <footer class="footer_area clearfix">
		<div class="container">
			<div class="row">
				<div class="single_widget_area d-flex mb-30">
					<div class="footer-logo mr-60">
						<h2 class="heading">CapStore</h2>
						<p>CapStore is a web based e-commerce website that allows
							users to buy or sell products. Users can view products from
							different categories and buy them .The user will be able to see
							products of similar category, sort them, compare them etc.</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-12 col-md-2 text-right">
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br> <img
						src="https://image.flaticon.com/icons/png/512/69/69366.png"
						style="height: 40px; width: 40px"> &nbsp;&nbsp; <img
						src="http://www.cashadvance6online.com/data/archive/img/2001035463.png"
						style="height: 40px; width: 40px"> &nbsp;&nbsp; <img
						src="http://pluspng.com/img-png/twitter-logo-png-twitter-icon-circle-logo-png-512.png"
						style="height: 40px; width: 40px"> &nbsp;&nbsp;



				</div>

				<div class="col-12 col-md-10  text-right">
					<div class="sign-gd-two">
						<h4>Our Information</h4>
						<div class="w3-address">
							<div class="w3-address-grid">
								<div class="w3-address-left">
									<div class="w3-address-right">
										<h6>Phone Number</h6>
										<p>+789593092</p>
									</div>
								</div>
							</div>
							<div class="w3-address-grid">
								<div class="w3-address-left">
									<div class="w3-address-right">
										<h6>Email Address</h6>
										<p>capstore@gmailcom</p>
									</div>
								</div>
							</div>
							<div class="w3-address-grid">
								<div class="w3-address-left">
									<div class="w3-address-right">
										<h6>Location</h6>
										<p>Capstore,Pune</p>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="row">

				<div class="col-12 col-md-12 text-center">

					<p>
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | CapStore</a>
					</p>
				</div>
			</div>

		</div>
	</footer>
    <%-- <% } %>
                    --%>
    <!-- ##### Footer Area End ##### -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="../resources/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="../resources/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="../resources/js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="../resources/js/plugins.js"></script>
    <!-- Classy Nav js -->
    <script src="../resources/js/classy-nav.min.js"></script>
    <!-- Active js -->
    <script src="../resources/js/active.js"></script>
</body>

</html>
