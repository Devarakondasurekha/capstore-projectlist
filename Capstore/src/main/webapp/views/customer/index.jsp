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
<title>Capstore | HOME</title>

<!-- Favicon  -->
<link rel="icon" href="../resources/img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="../resources/css/core-style.css">
<link rel="stylesheet" href="../resources/css/style.css">

</head>

<body>

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
							<li><a href="#">Categories</a>
								<ul class="dropdown">
									<c:forEach items="${map.keySet()}" var="categoryMap">

										<li><a href="/getCategory/?category=${categoryMap}">${categoryMap}</a></li>
									</c:forEach>
								</ul></li>
							<li><a href="/getContact">Contact</a></li>
						</ul>
					</div>
					<!-- Nav End -->
				</div>
			</nav>

			<!-- Header Meta Data -->
			<div class="header-meta d-flex clearfix justify-content-end">
				<!-- Search Area -->
				<div class="search-area">
					<form action="/search" method="GET" >
						<input type="search" name="search" id="headerSearch"
							placeholder="Type for search">
						<button type="submit">
							<i class="fa fa-search" aria-hidden="true"></i>
						</button>
					</form>
				</div>
				<!-- Favourite Area -->
				<%
					String sess = (String) request.getSession().getAttribute("sessionid");
					if (sess == null) {
				%>
				<div class="favourite-area">
					<a href="#" data-toggle="modal" data-target="#registerModal">Register</a>
				</div>

				<div class="user-login-info">
					<a href="/getLogin">Sign In</a>
				</div>
				<%
					} else {
				%>
				<!--      Favourite Area
 -->
				<!-- Cart Area -->

				<div class="cart-area">
					<a href="profile" id="essenceUsrBtn"><img
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
					<a href="err" id="essenceCartBtn"><img
						src="../resources/img/core-img/bag.svg" alt=""> <span>
							<!--add product quantity-->
					</span></a>
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
				src="../resources/img/core-img/bag.svg" alt=""> <span>
					<!--add product quantity-->
			</span></a>
		</div>

		<div class="cart-content d-flex">

			<!-- Cart List Area -->
			<div class="cart-list">
				<c:forEach items="${map.keySet()}" var="category">
					<!-- Single Cart Item -->
					<div class="single-cart-item">
						<!-- Please add product id from cart in here -->
						<a href="/getProduct" class="product-image"> <img
							src="../resources/img/product-img/product-1.jpg"
							class="cart-thumb" alt=""> <!-- Cart Item Desc -->
							<div class="cart-item-desc">
								<span class="product-remove"><i class="fa fa-close"
									aria-hidden="true"></i></span> <span class="badge"></span>
								<h6></h6>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>

			<!-- Cart Summary -->
			<div class="cart-amount-summary">

				<h2>Summary</h2>
				<ul class="summary-table">
					<!--  Add calculated data from database -->
					<li><span>SUBTOTAL:</span> <span></span></li>
					<li><span>DELIVERY:</span> <span></span></li>
					<li><span>DISCOUNT:</span> <span></span></li>
					<li><span>TOTAL:</span> <span></span></li>
				</ul>
				<div class="checkout-btn mt-100">
					<a href="/getCheckout" class="btn essence-btn">CHECK OUT</a>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Right Side Cart End ##### -->

	<!-- ##### Welcome Area Start ##### -->
	<section class="welcome_area bg-img background-overlay"
		style="background-image: url(../resources/img/bg-img/mainbg.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="hero-content">
						<h2>New Collection</h2>
						<a href="#move" class="btn essence-btn">Start Exploring</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ##### Welcome Area End ##### -->

	<!-- ##### Top Catagory Area Start ##### -->
	<div class="top_catagory_area section-padding-80 clearfix">
		<div class="container">
			<div class="row justify-content-center">
				<!-- Modal -->
				<div class="modal fade" id="registerModal" role="dialog">
					<div class="modal-dialog modal-lg">

						<!-- Modal content-->
						<div class="modal-content">

							<div class="modal-body">
								<div class="merchantBtn pull-right">
									<a href="registerAsMerchant" class="btn essence-btn">Register
										as Merchant</a>
								</div>
								<div class="customerBtn pull-left">
									<a href="registerAsCustomer" class="btn essence-btn">Register
										as Customer</a>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn essence-btn"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
	<section id="move">
		<div>
			<!-- ##### Top Category Area End ##### -->
			<c:forEach items="${map.entrySet()}" var="productList">
				<h2 id="move" class="container">${productList.getKey()}</h2>
				<br>

				<div class="container">
					<div class="row">

						<div class="col-12">

							<div class="popular-products-slides owl-carousel">


								<c:forEach items="${productList.getValue()}" var="product">



									<!-- Single Product -->
									<div class="single-product-wrapper">
										<!-- Product Image -->
										<div class="product-img">
											<a href="/getProduct?id=${product.prodId}"> <img
												style="height: 280px; width: 350px" src="${product.url}"
												alt="">
											</a>
											<!-- Hover Thumb -->

											<!-- Favourite -->
											<c:out value="${product.prodId}"></c:out>

											<div class="product-favourite">
												<a href="#" class="favme fa fa-heart"></a>
											</div>
										</div>
										<!-- Product Description -->
										<div class="product-description">
											<a href="/getProduct?id=${product.prodId}"> <span>${product.name}
											</span>
											</a> <a href="/getProduct?id=${product.prodId}">
												<h6>${product.sizes}</h6>
											</a> <a href="/getProduct?id=${product.prodId}">
												<p class="product-price">${product.price}</p>
											</a>

											<!-- Hover Content -->
										
											<div class="hover-content">
											
											
												<!-- Add to Cart -->
												<div class="add-to-cart-btn">
												 <% String sessnnn = (String) request.getSession().getAttribute("sessionid");
                    if (sessnnn == null) { %> 
                       <a href="/getLogin" class="btn essence-btn">Add to Cart</a>
                        <% } else { %>
                   <a href="addToCart?id=${product.prodId}"
														class="btn essence-btn">Add to Cart</a></a>
                        <% } %>
											
												</div>
											</div>
										</div>
									</div>

								</c:forEach>


							</div>
						</div>

					</div>
				</div>

			</c:forEach>
		</div>
	</section>
	<!-- ##### New Arrivals Area End ##### -->

	<!-- ##### Brands Area Start ##### -->
	<div
		class="brands-area d-flex align-items-center justify-content-between">
		<!-- Brand Logo -->
		<div class="single-brands-logo">
			<img src="../resources/img/core-img/brand1.png" alt="">
		</div>
		<!-- Brand Logo -->
		<div class="single-brands-logo">
			<img src="../resources/img/core-img/brand2.png" alt="">
		</div>
		<!-- Brand Logo -->
		<div class="single-brands-logo">
			<img src="../resources/img/core-img/brand3.png" alt="">
		</div>
		<!-- Brand Logo -->
		<div class="single-brands-logo">
			<img src="../resources/img/core-img/brand4.png" alt="">
		</div>
		<!-- Brand Logo -->
		<div class="single-brands-logo">
			<img src="../resources/img/core-img/brand5.png" alt="">
		</div>
		<!-- Brand Logo -->
		<div class="single-brands-logo">
			<img src="../resources/img/core-img/brand6.png" alt="">
		</div>
	</div>
	<!-- ##### Brands Area End ##### -->

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
