<!DOCTYPE html>

<html>
<head>
  <meta charset="utf-8">

  <title>Password OTP Form</title>
  <meta name="GENERATOR" content="WDL-Website-Builder">
<link rel="stylesheet" href="css\home-style.css">
</head>
<body bgcolor="black">
<%@include file="loginheader.jsp"%>
<!-- Form Module-->
<div class="module form-style">
    <div class="form">
      <h2>Change Password</h2>
    <form method="post" action="Login.jsp" name="registerForm">
      <input type="text" placeholder="OTP Pin" name="otp" required="required"/>
	  <input type="password" placeholder="New Password" name="newpassword" required="required"/>
	  <input type="password" placeholder="Confirm Password" name="confirmpassword" required="required"/>
      <input type="submit" name="setpassword" value="Set Password"/>
    </form>
	</div>
</div>
<%@include file="loginfooter.jsp"%>
</body>
</html>