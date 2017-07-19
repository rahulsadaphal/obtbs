<!DOCTYPE html>

<html>
<head>
  <meta charset="utf-8">

  <title>Password Changer Form</title>
  <meta name="GENERATOR" content="WDL-Website-Builder">
<link rel="stylesheet" href="css\home-style.css">
</head>
<body bgcolor="black">
<%@include file="loginheader.jsp"%>
  
<!-- Form Module-->
<div class="module form-style">
    <div class="form">
      <h2>Password Changer</h2>
    <form method="post" action="OTPForget.jsp" name="registerForm">
      <input type="text" placeholder="Username" name="username" required="required"/>
      <input type="submit" name="submit" value="Submit"/>
    </form>
	</div>
</div>
<%@include file="loginfooter.jsp"%>
</body>
</html>