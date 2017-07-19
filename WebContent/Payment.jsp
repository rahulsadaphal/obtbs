<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%!Bus bus = null; %>
<%!double total=0; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css\homepage.css">
</head>
<body bgcolor="black">

	<%
	Bus bus = (Bus) session.getAttribute("bus");
	if(bus!=null)
	{
		String noOfSeats = (String) session.getAttribute("noOfSeats");
		if(noOfSeats!=null)
		{
			double fare = bus.getSeat().getFare();
			total = fare*Double.parseDouble(noOfSeats);
			session.setAttribute("total", total);
		}
	
		String modeNo =request.getParameter("pmode");
		if(modeNo!=null)
		{	
			if(modeNo.equals("1"))
			{
				%>
				<div class="passengerform">
				<div class="form">
					<h2>Make Payment</h2>
					<form method="post" action="PaymentController" name="addForm">
						<select id="mode" name="paymentMode" onchange="changeMode()">
							<option selected disabled>Payment Mode</option>
							<option  selected value="Card Payment">Card Payment</option>
							<option value="Netbanking">Netbanking</option>
						</select>
						<script>
						function changeMode()
						{
							var mode = document.getElementById("mode").value
							if(mode=="Card Payment")
							{
								window.location.href="Payment.jsp?pmode=1"
							}
							else
							{
								window.location.href="Payment.jsp?pmode=2"
							}
						}
						</script>
						<input type="text" placeholder="Card Number" pattern="^\d{16}$" title="Please Enter Valid Card Number (16 digit)" name="cardNumber" required="required"/>
						<input type="text" placeholder="Card Holder Name" pattern="[a-zA-Z\s]+" title="Please Enter Valid Name" name="cardHolderName" required="required"/>
						<select id="t5" name="month">
							<option selected disabled>Month</option>
							<option  value="1">1</option>
							<option  value="2">2</option>
							<option  value="3">3</option>
							<option  value="4">4</option>
							<option  value="5">5</option>
							<option  value="6">6</option>
							<option  value="7">7</option>
							<option  value="8">8</option>
							<option  value="9">9</option>
							<option  value="10">10</option>
							<option  value="11">11</option>
							<option  value="12">12</option>
						</select>
						<select id="t5" name="year">
							<option selected disabled>Year</option>
							<option  value="2018">18</option>
							<option  value="2019">19</option>
							<option  value="2020">20</option>
							<option  value="2021">21</option>
							<option  value="2022">22</option>
							<option  value="2022">23</option>
							<option  value="2022">24</option>
							<option  value="2022">25</option>
							<option  value="2022">26</option>

						</select>
						<input type="password" placeholder="CVV" name="cvv" pattern="^\d{3}$" title="Please Enter Valid CVV (3 digit)" required="required"/>
						<input type="text"  name="amount" disabled="disabled" value="<%=total%>"/>
						<input type="submit" name="submit" value="Do Payment" />

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
					<h2>Make Payment</h2>
					<form method="post" action="PaymentController" name="addForm">
						<select id="mode" name="paymentMode" onchange="changeMode()">
							<option selected disabled>Payment Mode</option>
							<option   value="Card Payment">Card Payment</option>
							<option selected value="Netbanking">Netbanking</option>
						</select>
						<script>
						function changeMode()
						{
							var mode = document.getElementById("mode").value
							if(mode=="Card Payment")
							{
								window.location.href="Payment.jsp?pmode=1"
							}
							else
							{
								window.location.href="Payment.jsp?pmode=2"
							}
						}
						</script>
						<input type="text" placeholder="Account Number" name="accountNumber" pattern="^\d{15}$" title="Please Enter Valid Account Number (15 digit)" required="required"/>
						<input type="text" placeholder="Account Holder Name" name="accountHolderName" pattern="[a-zA-Z\s]+" title="Please Enter Valid Name" required="required"/>
						<select id="t5" name="bank">
							<option selected disabled>Bank</option>
							<option  value="Axis Bank">Axis Bank</option>
							<option  value="ICICI Bank">ICICI Bank</option>
							<option  value="SBI Bank">SBI Bank</option>
							<option  value="Yes Bank">Yes Bank</option>

						</select>
						<input type="text" placeholder="IFSC Code" pattern="[a-zA-Z]{4}[0-9]{7}$" title="Please Enter Valid IFSC Code (11 digit)" name="ifscCode" required="required"/>
						<input type="text"  name="amount" disabled="disabled" value="<%=total%>"/>
						<input type="submit" name="submit" value="Do Payment" />

					</form>
				</div>
			</div>
				<%
				
			}
		}
		else
		{
		%>
		<div class="passengerform">
				<div class="form">
			<h2>Make Payment</h2>
			<form method="post" action="PaymentController" name="addForm">
				<select id="mode" name="paymentMode" onchange="changeMode()">
					<option selected disabled>Payment Mode</option>
					<option  value="Card Payment">Card Payment</option>
					<option value="Netbanking">Netbanking</option>
				</select>
				<script>
				function changeMode()
				{
					var mode = document.getElementById("mode").value
					if(mode=="Card Payment")
					{
						window.location.href="Payment.jsp?pmode=1"
					}
					else
					{
						window.location.href="Payment.jsp?pmode=2"
					}
				}
				</script>
				<input type="text" placeholder="Account Number" name="accountNumber" pattern="^\d{15}$" title="Please Enter Valid Account Number (15 digit)" required="required"/>
						<input type="text" placeholder="Account Holder Name" name="accountHolderName" required="required" pattern="[a-zA-Z\s]+" title="Please Enter Valid Name"/>
						<select id="t5" name="bank">
							<option selected disabled>Bank</option>
							<option  value="Axis Bank">Axis Bank</option>
							<option  value="ICICI Bank">ICICI Bank</option>
							<option  value="SBI Bank">SBI Bank</option>
							<option  value="Yes Bank">Yes Bank</option>

						</select>
						<input type="text" placeholder="IFSC Code" pattern="[a-zA-Z0-9]{11}$" title="Please Enter Valid IFSC Code (11 digit)" name="ifscCode" required="required"/>
						<input type="text"  name="amount" disabled="disabled" value="<%=total%>"/>
						<input type="submit" name="submit" value="Do Payment" />


			</form>
		</div>
	</div>
		<%
			
		}
	}
	else
	{
		session.invalidate();
		%>
		<script>window.location.href="Index.jsp"</script>
		
		<%
	}
	
	%>
		
</body>
</html>