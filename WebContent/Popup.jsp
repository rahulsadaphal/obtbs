<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.popup{
position:relative;
display:inline-block;
cursor:pointer;
}
.popup .popuptext
{
	visibility:hidden;
	width:200px;
	background-color:grey;
	color:red;
	text-align:center;
	border-radius:6px;
	padding:10px 0;
	position:absolute;
}

.popup .show{
	visibility:visible;
	-webkit-animation:fadeIn 1s;
	animation:fadeIn 1s;
}
</style>
</head>


<script>
function myfunction()
{
	var popup = document.getElementById("mypopup");
	popup.classList.toggle("show");

	}
</script>
<body>


<div class="popup" onclick="myfunction()">Click me
	<span class="popuptext" id="mypopup">Your Details are Updated Successfully</span>
</div>

</body>
</html>