<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
<link href="css\homepage.css" rel="stylesheet" type="text/css">
<link href="css\home-style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js\service.js"></script>
</head>
<body bgcolor="black">
<%@ include file="AdminHeader.jsp" %>
<script type="text/javascript">
document.getElementById("username").innerHTML = '${username}';
</script>

<%-- <%@include file="SlideShow2.jsp" %> --%>
<%@ include file="AdminFooter.jsp" %>

</body>
</html>