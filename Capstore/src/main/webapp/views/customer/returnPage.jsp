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
				<a class="nav-brand" href="index">CapStore</a>
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
									<c:forEach items="${categories}" var="category">
										<li><a href="getCategory/${category}">${category}</a></li>
									</c:forEach>
								</ul></li>
							<li><a href="getContact">Contact</a></li>
						</ul>
					</div>
					<!-- Nav End -->
				</div>
			</nav>

			<!-- Header Meta Data -->
			<div class="header-meta d-flex clearfix justify-content-end">
				<!-- Search Area -->
				<div class="search-area">
					<form action="#" method="post">
						<input type="search" name="search" id="headerSearch"
							placeholder="Type for search">
						<button type="submit">
							<i class="fa fa-search" aria-hidden="true"></i>
						</button>
					</form>
				</div>
				<!-- Favourite Area -->
				<div class="favourite-area">
					<a href="#" data-toggle="modal" data-target="#registerModal">Register</a>
				</div>
				<!-- User Login Info -->
				<div class="user-login-info">
					<a href="getLogin">Sign In</a>
				</div>
				<!-- Cart Area -->
				<div class="cart-area">
					<a href="#" id="essenceCartBtn"><img
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
				<c:forEach items="${categories}" var="category">
					<!-- Single Cart Item -->
					<div class="single-cart-item">
						<!-- Please add product id from cart in here -->
						<a href="getProduct" class="product-image"> <img
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
</div>
</div>
<div class="container">
  <p><h1>Ordered returned successfully</h1></p>
  <div class="panel panel-default">
    <div class="panel-body"><p>&nbsp &nbsp            <h1>${prodid}</h1>               </p></div>
  </div>
</div>
</body>

</html>