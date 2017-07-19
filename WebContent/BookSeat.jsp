<%@page import="com.manipal.service.impl.BusServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%!Bus bus = null; %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css\homepage.css">
</head>
<script>


</script>
<body bgcolor="black">

	<%	
	String busid = request.getParameter("busid");
		Bus bus = new BusServiceImpl().retrieveBus(busid);
		Dummy dummy = new BusServiceImpl().retrieveDummy(busid);
		if(bus!=null)
		{
			System.out.println(bus.getBusId());
			session.setAttribute("bus", bus);
			session.setAttribute("dummy", dummy);
		}
	%>
		
<%
		String noOfSeats = request.getParameter("noOfSeats");
		
		if(noOfSeats!=null)
		{
			session.setAttribute("noOfSeats", noOfSeats);

%>
<div class="passengerform">
		<div class="form">
			<h2>Fill Passenger Details</h2>
			<form method="post" action="StorePassengerController" name="addForm">
				<select id="noofseat" name="seat123">
							<option selected disabled>Seats</option>
							<option  value="1">1</option>
							<option  value="2">2</option>
							<option  value="3">3</option>
							<option  value="4">4</option>
							<option  value="5">5</option>
						</select>
				<input style="width:30%;margin: 0px 50px 10px;" type="button" name="submit" value="Submit" onclick="setSeats()"/>
				<br/>
				<script>
				function enableBt()
				{
					var bt = document.getElementById("bt").disabled = false;
				}
				function setSeats()
				{
					
					var seats = document.getElementById("noofseat").value
					
					if(seats != null)
					{
						if(seats != "Seats")
							{
								window.location.href="BookSeat.jsp?noOfSeats="+seats 
							}
						else
							{
								seats=1
								window.location.href="BookSeat.jsp?noOfSeats="+seats 
							}
					}
				}
				
				</script>
				<%
					for(int i=0;i<Integer.parseInt(noOfSeats);i++)
					{
				%>
				<br/>
				<input type="text" placeholder="Passenger First Name" pattern="[a-zA-Z]+" title="Please Enter Valid FirstName" name="passengerFirstName<%=i %>" required="required" />
				<input type="text" placeholder="Passenger Last Name" pattern="[a-zA-Z]+" title="Please Enter Valid LastName" name="passengerLastName<%=i %>" required="required" />
				<input type="email" placeholder="Passenger Email" name="passengerEmail<%=i %>" required="required" />
	   
				<input type="text"  pattern="[0-9]{2}" title="Please Enter Valid Age" placeholder="Passenger Age" name="passengerAge<%=i %>" required="required" />
				<input type="text"  pattern="[7-9]{1}[0-9]{9}" title="Please Enter Valid Contact" placeholder="Passenger Contact" name="passengerContact<%=i %>" required="required" />
				<label>Gender</label><input id="male" type="radio" name="passengerGender<%=i %>" value="male" checked/><label for="male">Male</label>
	  			<input id="female" type="radio" name="passengerGender<%=i %>" value="female"/><label for="female">Female</label>	
				<%
				
				
					}
				%>
				<br/>
				<input style="width:25%;margin: 0px 40px 10px 10px;" type="submit" name="submit" value="Make Payment"/>
				<input style="width:25%;margin: 0px 40px 10px 80px;" type="reset" name="submit" value="Reset"/>
				<input style="width:25%;margin: 0px 40px 10px 10px;" type="button" name="submit" value="Back" onclick="window.location.href='Index.jsp'"/>
				
				
			</form>
		</div>
	</div>
			
<%
}
		else
		{
		%>
		<div class="passengerform">
		<div class="form">
			<h2>Select Seats You want to Book</h2>
			<form method="post" action="StorePassengerController" name="addForm">
				<select id="noofseat" name="seat123">
							<option selected disabled>Seats</option>
							<option  value="1">1</option>
							<option  value="2">2</option>
							<option  value="3">3</option>
							<option  value="4">4</option>
							<option  value="5">5</option>
						</select>
				<input style="width:30%;margin: 0px 50px 10px;" type="button" name="submit" value="Submit" onclick="setSeats()"/>
				<br/>
				<script>
				function setSeats()
				{
					
					var seats = document.getElementById("noofseat").value
					
					if(seats != null)
					{
						if(seats != "Seats")
							{
								window.location.href="BookSeat.jsp?noOfSeats="+seats 
							}
						else
							{
								seats=1
								window.location.href="BookSeat.jsp?noOfSeats="+seats 
							}
					}
				}
				</script>
			
			</form>
		</div>
	</div>
		<%
	}

	%>
	
	

</body>
</html>