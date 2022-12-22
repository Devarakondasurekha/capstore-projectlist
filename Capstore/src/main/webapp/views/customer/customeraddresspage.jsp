<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Customer Registration</title>
	
	 <!-- Favicon  -->
    <link rel="icon" href="../resources/img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="../resources/css/core-style.css">
    <link rel="stylesheet" href="../resources/style.css">
	
</head>
<body>

<!-- Form Validation Script-->

<script type="text/javascript">
  function checkPassword(str)
  {
    var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    return re.test(str);
  }
  function checkForm(form)
  {
    if(form.password1.value != "" && form.password1.value == form.password2.value) {
      if(!checkPassword(form.password1.value)) {
        alert("The password you have entered is not valid!");
        form.password1.focus();
        return false;
      }
    } else {
      alert("ERROR: Please MAKE SURE your passwords MATCH!!");
      form.password1.focus();
      return false;
    }
     var formData = JSON.stringify($("#cust_register").serializeArray());
    $.ajax({
  	  type: "POST",
  	  url: "http://localhost:4496/registerCustomer",
  	  data: formData,
  	  success: function(){},
  	  dataType: "json",
  	  contentType : "application/json"
  	});
  }
     
</script>


    <!-- ##### Header Area Start ##### -->
    <header class="header_area">
        <div class="classy-nav-container breakpoint-off d-flex align-items-center justify-content-between">
            <!-- Classy Menu -->
            <nav class="classy-navbar" id="essenceNav">
                <!-- Logo -->
                <a class="nav-brand" href="index.html">CapStore</a>
                <!-- Navbar Toggler -->
                <div class="classy-navbar-toggler">
                    <span class="navbarToggler"><span></span><span></span><span></span></span>
                </div>
                <!-- Menu -->
               
            </nav>

            <!-- Header Meta Data -->
            <div class="header-meta d-flex clearfix justify-content-end">
                <!-- Search Area -->
                <div class="search-area">
                    <form action="searchProduct" method="post">
                        <input type="search" name="searchProduct" id="headerSearch" placeholder="Type for search">
                        <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
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
                <div class="user-profile-info">
                    <a href="getProfile">Profile</a>
                </div>
            </div>

        </div>
    </header>
    <!-- ##### Header Area End ##### -->
<div class="checkout_area section-padding-80">
	    <div class="container">
		
		
		<!-- Modal -->
			  <div class="modal fade" id="registerModal" role="dialog">
				<div class="modal-dialog modal-lg">
				
				  <!-- Modal content-->
				  <div class="modal-content">
					
					<div class="modal-body">
					  <div class="merchantBtn pull-right">
						<a href="#" class="btn essence-btn">Register as Merchant</a>
					  </div>
					  <div class="customerBtn pull-left">
						<a href="#" class="btn essence-btn">Register as Customer</a>
					  </div>
					</div>
					<div class="modal-footer">
					  <button type="button" class="btn essence-btn" data-dismiss="modal">Close</button>
					</div>
				  </div>
				  
				</div>
			  </div>
		
		
		<h3>Register Customer</h3>
		<div><br></div>
            <div class="row">
				<div class="col-md-6">
			<sf:form name="cust_register" id="cust_register" class="form-horizontal" onsubmit="return checkForm(this);" action="success" method="POST"  modelAttribute="address">
			 <div class="form-group">
                  <label for="addressLine1" class="col-sm-6 control-label">House Number</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="houseNo" placeholder="Enter Your House Number" required>
                  </div>
                </div>
				<div class="form-group">
                  <label for="addressLine2" class="col-sm-6 control-label">Area</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="area" placeholder="Enter Your Area" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="country" class="col-sm-6 control-label">Landmark</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="landmark" placeholder="Enter Your Landmark" required>
                  </div>
                </div>
				<div class="form-group">
                  <label for="city" class="col-sm-6 control-label">City</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="city" placeholder="Enter Your City" required>
                  </div>
                </div>
				<div class="form-group">
                  <label for="state" class="col-sm-6 control-label">State</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="states" placeholder="Enter Your State" required>
                  </div>
                </div>
				<div class="form-group">
                  <label for="pincode" class="col-sm-6 control-label">Pin Code</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="pincode" pattern="^[1-9][0-9]{5}$" placeholder="Enter Your Pin Code" required>
                  </div>
                </div>
			 </div>      
			 <div class="col-md-6">
			 <div class="form-group">
                <div class="form-group">
                  <label for="country" class="col-sm-6 control-label">Alternate Name</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" placeholder="Enter Your Alternate Name">
                  </div>
                </div>
                 <label for="addressLine1" class="col-sm-6 control-label">Alternate Mobile Number</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="alternate_mobile_no" placeholder="Enter Your Alternate Mobile Number">
                  </div>
                </div>
				<div class="form-group">
                  <label for="addressLine2" class="col-sm-6 control-label">Address Type</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="address_type" placeholder="Enter Your Address Type">
                  </div>
                </div>
			 </div>            
			</div>
		   </div>
		   <div class="row">
		   <div class="col-md-3"></div>
		   <div class="col-md-6">
		    <div id="RegisterBtn" class="box-footer">
                <button type="submit" class="col-sm-10 btn essence-btn">Register</button>
              </div>
			  </sf:form>
			  </div>
			  <div class="col-md-3"></div>
              <!-- /.box-footer -->
		   </div>
		</div>    
     </div>
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
	<!-- Form Validation -->
	
</body>
</html>