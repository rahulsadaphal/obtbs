
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="css\home-style.css">
<script type="text/javascript">
</script>
</head>
<body bgcolor="black">
 <%@include file="loginheader.jsp"%>
 
  <%
 String validMessage=(String)request.getAttribute("Message");
 if(validMessage!=null)
 {%>
	<div class="msg" style="text-align:center;color:white; margin:140px 0px -40px px;"><%=validMessage%></div>
	<%
 }

 %>
<!-- Form Module-->
<div class="module form-style">
    <div class="form">
    <h2>Login to an account</h2>
    <form method="post" name="LoginForm" action="LoginController">
      <input type="text" placeholder="Username" name="userUsername" required="required"/>
      <input type="password" placeholder="Password" name="userPassword" required="required"/>
      <select id="selectType" name="userType">
      	<option value="User">User</option>
      	<option value="Admin">Admin</option>
      </select>
      <input type="submit" name="login" value="Login"/>
      <input type="button" name="Back" value="Back" onclick="window.location.href='Index.jsp'"/>
    </form>
	</div>

    <div class="cta">
      <a href="Registration.jsp">New User?</a>
    </div>
</div>

<%@include file="loginfooter.jsp"%>
</body>
</html>