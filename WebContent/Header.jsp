<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8" content="">
  <title>Login Form</title>
  <meta name="GENERATOR" content="WDL-Website-Builder">
<link rel="stylesheet" href="css\home-style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<div class="title">
	<div id="first">
  		<h1>OBTBS</h1>
  		<h2>Online Bus Ticket Service</h2>
 	</div>
 	<div id="second">
 		<marquee direction="left"><h2>Pune<i>-</i>Bangalore<i>-</i>Mumbai<i>-</i>Chennai<i>-</i>Kolkata</h2></marquee>
 		<marquee direction="right"><h2>Pune<i>-</i>Bangalore<i>-</i>Mumbai<i>-</i>Chennai<i>-</i>Kolkata</h2></marquee>
 	</div>
 	<div id="third">
	 	<div class="up">
	 		 <ul class="fa-ul" style="list-style-type:none;">
				<li id="li"><a href="#"><i class="fa fa-facebook fa-2x"></i></a> </li>
	             <li id="li"><a href="#"><i class="fa fa-twitter fa-2x"></i></a> </li>
	             <li id="li"><a href="#"><i class="fa fa-google fa-2x"></i></a> </li>
	        </ul>
	 	</div>
	 	<div class="down">
		 	<div class="name">
		 			<span style="color:#5be5f9;">Welcome!...</span>
		 			<h2 style=" margin: 0 0px 5px 20px;">
		 			<span id="username" name ="username"></span>
		 			</h2>
		 	</div>
		 	<div class="list">
		 	        <select id="userService" class="userService" onchange="chooseService();">
		 	        <option value="Account" selected disabled>Account</option>
					<option value="Login">Login</option>
					<option value="Search Bus">Search Bus</option>
					<option value="Logout"disabled="disabled">Logout</option>
				</select>
			</div>
		</div>
 	</div>
 </div>


  <div class="menubar">
    <button class="tablinks" onclick="window.location.href='Home.jsp'">Home</button> 
	<button class="tablinks" onclick="window.location.href='AboutUs.jsp'">About Us</button> 
	<button class="tablinks" onclick="window.location.href='Gallery.jsp'">Gallery</button>
	<button class="tablinks" onclick="window.location.href='TC.jsp'">Terms&Conditions</button> 
	<button class="tablinks" onclick="window.location.href='ContactUs.jsp'">Contact Us</button>
  </div><br>
</body>
</html>
