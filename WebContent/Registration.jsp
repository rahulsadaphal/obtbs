<!DOCTYPE html>

<html>
<head>
  <meta charset="utf-8">

  <title>Registration Form</title>
  <meta name="GENERATOR" content="WDL-Website-Builder">
<link rel="stylesheet" href="css\home-style.css">
<script type="text/javascript" src="js\Validation.js"></script>

</head>

<body bgcolor="black">
<%@include file="loginheader.jsp"%>
 <%
 String ValidMessage=(String)request.getAttribute("Message");
 if(ValidMessage!=null)
 {%>
	<div class="msg" style="text-align:center;color:#004080; margin:130px 0px -120px 5px;"><%=ValidMessage%></div>
	<%
 }
 %>
<!-- Form Module-->
<div class="module form-style">
    <div class="form">
      <h2>Create an account</h2>
    <form method="post" action="RegistrationController" name="registerForm">
      <input type="text" placeholder="Username" name="userUsername" required="required" />
      <input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="Password" name="userPassword" required="required" onfocus="password_validation()"/>
	  <input type="text" placeholder="First Name" name="userFirstname" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid Name"/>
	  <input type="text" placeholder="Last Name" name="userLastname" required="required"/ pattern="[a-zA-Z]+" title="Please Enter Valid Name">
	  <input type="email" placeholder="Email" name="userEmail" required="required"/>
      <input type="text" placeholder="Contact" pattern="^[7-9]{1}[0-9]{9}$" pattern="Please Enter Valid Contact" name="userContact" required="required"/>
      <label>Gender</label><input id="male" type="radio" name="userGender" value="male" checked/><label for="male">Male</label>
	  <input id="female" type="radio" name="userGender" value="female"/><label for="female">Female</label><br/>
	  
      <input type="submit" name="register" value="Register"/>
      <input type="reset" name="reset" value="Reset"/>
      <input type="button" name="close" value="Close" onclick="window.location.href='Login.jsp'"/>
    </form>
	</div>

</div>

<%@include file="loginfooter.jsp" %>
</body>
</html>
