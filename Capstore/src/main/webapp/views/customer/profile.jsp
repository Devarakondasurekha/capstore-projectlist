<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="description" content="">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <meta name = "viewport" content = "width = device-width, initial-scale = 1">
      <link rel = "stylesheet"
         href = "https://fonts.googleapis.com/icon?family=Material+Icons">
      <link rel = "stylesheet"
         href = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
      <script type = "text/javascript"
         src = "https://code.jquery.com/jquery-2.1.1.min.js"></script>           
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
   </head>
   <p>&nbsp;</p>
   <center>
   <h1>Update Profile</h1>
   <div>&nbsp;</div>
   <div class = "container">
      <div class = "row">
         <form class = "col s12" name="cust_update" action="change" onsubmit="return checkForm(this);" method="POST">
             <div class = "input-field col s12">
               <i class = "material-icons prefix">call</i>
               <input name="customerMobileNo"  placeholder="Enter Your Mobile Number" type = "number"
                  class = "validate" required>
               <label for = "Mobile">Mobile Number</label>
            </div>
            
            <div class = "input-field col s12">
               <i class = "material-icons prefix">account_circle</i>
               <input name="name" type="text" placeholder="Enter Your Name" 
                  class = "active validate" required />
               <label for = "name">Name</label>
            </div>
            <div class = "input-field col s12">
               <i class = "material-icons prefix">email</i>
               <input  name="email" type="email" placeholder="Enter Your Email"
                  class = "validate">
               <label for = "email">Email</label>
            </div>
           
            <div class = "input-field col s12">  
               <i class = "material-icons prefix"> enhanced_encryption</i>
               <label for = "password">Password</label>
               <input id="password" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" name="password" type="password" placeholder="Enter Your Password"
                  class = "validate" required /> 
            </div>
            <div align="center">
               <button type="submit" class="col-sm-10 btn essence-btn blue">Update &raquo;</button>         
            </div>
         </form>
      </div>
   </div>
   
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

   
</html>
