
<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%!List<City> cityList; %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IndexPage</title>
<link href="css\homepage.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="js\service.js"></script>
<body bgcolor="black">

<%@include file="Header.jsp"%>
<script type="text/javascript">
document.getElementById("username").innerHTML = "Passenger";

</script>
<%
session.setAttribute("uname", "Passenger");


%>
	<div class="searchframe">
		<form method="post" action="SearchBusController" name="searchForm">
		<%
			CityService cityService = new CityServiceImpl();
			cityList = cityService.retrieveActiveCityList();
			int cnt1=0;
		
		%>
			<select id ="fromcity" name="fromcity" value="From City" required="required" onchange="destCityDisable(this)">
				<option selected disabled>Source City</option>
				<%for(City city : cityList)
      		{
      	%>
				<option><%=city.getCityName()%></option>
				<%
      		}
      	%>
			</select> 
			
			
			
			<script>
			function destCityDisable(selectedCity)
			{
				var destCity = document.getElementById("tocity")
				for(var i=1;i<destCity.length;i++)
					{
						destCity.options[i].disabled = false ; 
					}
				
				var cityIndex = selectedCity.selectedIndex;
				document.getElementById("tocity").options[cityIndex].disabled = true ;	
				
				
			}
			function srcCityDisable(selectedCity)
			{
				var srcCity = document.getElementById("fromcity")
				for(var i=1;i<srcCity.length;i++)
					{
					srcCity.options[i].disabled = false ; 
					}
				
				
				
				var cityIndex = selectedCity.selectedIndex;
				document.getElementById("fromcity").options[cityIndex].disabled = true ;		
			}
			</script>
			
			
			
			
			<select id ="tocity" name="tocity" value="To City" required="required" onchange="srcCityDisable(this)" >
				<option selected disabled>Destination City</option>
		<%
			int cnt2=0;
      		cityList = cityService.retrieveActiveCityList();
      		for(City city : cityList)
      		{
        %>
				<option><%=city.getCityName()%></option>
				<%
          		}
        %>
			</select>
			<%
      		Calendar cal = Calendar.getInstance();
      		cal.add(Calendar.DATE,0);
      		Date date = cal.getTime();
      		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      		String curDate = sdf.format(date);
      		
      		cal = Calendar.getInstance();
      		cal.add(Calendar.DATE,6);
      		date = cal.getTime();
      		String sevenDate = sdf.format(date);
      %>
			<input type="date" placeholder="OnBoard Date&nbsp" name="onboarddate"
				required="required" min="<%=curDate%>" max="<%=sevenDate %>"/> 
				<input
				class="searchbutton" type="submit" name="searchbus"
				value="Search Buses" onclick="showbuslist()" />
		</form>
	</div>
	<%
	List<Dummy> busList = (ArrayList)session.getAttribute("busList");
	if(busList!=null)
	{
		
		
		if(busList.size()!=0)
		{
			for (Dummy dummy : busList) {
				Bus bus = new BusServiceImpl().retrieveBus(dummy.getBusId());
				City c1 = new CityServiceImpl().retrieveCity(bus.getSourceCity());
				City c2 = new CityServiceImpl().retrieveCity(bus.getDestination());
				
				
				String busTime = bus.getStartTime();
				String hour[] = busTime.split(":");
				
				int busTime1 = Integer.parseInt(hour[0]);
				
				System.out.println("Start Time : "+busTime1);
				
				cal = Calendar.getInstance();
			  	cal.add(Calendar.DATE,0);
			  	Date time = cal.getTime();
			  	SimpleDateFormat sdf1 = new SimpleDateFormat("H");
			  	String curTime = sdf1.format(time);
			  	int curTime1 = Integer.parseInt(curTime);
			  	
			  	System.out.println("Current Time : "+curTime1);
				
			  	
			  	if((busTime1-1) == curTime1)
			  	{ 
			  	%>
					<div class="buslist">
					<div class="buscontent">
						<div id="top" style="color: grey;">
						<form action="BookSeat.jsp?busid=<%=bus.getBusId()%>" name="bookForm" method="post">
						<div id="part1">
							<br /> <span id="firstrow"><%=bus.getOperator().getOperatorName()%></span>
							<span style="color: blue;"><%=c1.getCityName()%> -- <%=c2.getCityName()%></span><br />
							<br /> <span id="secondrow"><%=bus.getBusType()%> | <%=bus.getSeat().getSeatType()%> | <%=dummy.getDepartureDate().split(" ")[0] %></span>

						</div>
						<div id="part2">
							<br /> <span id="firstrow"><%=dummy.getStartTime()%> --- <%=dummy.getEndTime()%></span><br />
							<br /> <span id="secondrow">Remain Seats <%=dummy.getRemainSeats() %></span>
						</div>
						<div id="part3">
							<br /> <span id="firstrow">INR <%=bus.getSeat().getFare()%></span><br />
							<br /> <span id="secondrow">Total Seats <%=bus.getSeat().getNumberOfSeats()%></span>
							
							<span id="secondrow" style="color: red;">
							<b>BOOKING CLOSED</b></span>
							
						</div>
						</form>
						</div>
						<div id="bottom">
							<span id="busfeature" style="margin: 0px 100px 0px 440px; color:red">Booking Not Allowed 1 Hour Before Departure Time of Bus</span> 
						</div>
						<hr noshade style="border-color: #5be5f9; color: white;" />

					
				</div>
				</div>
				
				<%
			  		
			  	}
			  	else
			  	{ 	
			  	
		%>
		<div class="buslist">
			<div class="buscontent">
				<div id="top">
				<form action="BookSeat.jsp?busid=<%=bus.getBusId()%>" name="bookForm" method="post">
				<div id="part1">
					<br /> <span id="firstrow"><%=bus.getOperator().getOperatorName()%></span>
					<span style="color: blue;"><%=c1.getCityName()%> -- <%=c2.getCityName()%></span><br />
					<br /> <span id="secondrow"><%=bus.getBusType()%> | <%=bus.getSeat().getSeatType()%> | <%=dummy.getDepartureDate().split(" ")[0] %></span>

				</div>
				<div id="part2">
					<br /> <span id="firstrow"><%=dummy.getStartTime()%> --- <%=dummy.getEndTime()%></span><br />
					<br /> <span id="secondrow">Remain Seats <%=dummy.getRemainSeats() %></span>
				</div>
				<div id="part3">
					<br /> <span id="firstrow">INR <%=bus.getSeat().getFare()%></span><br />
					<br /> <span id="secondrow">Total Seats <%=bus.getSeat().getNumberOfSeats()%></span>
					<span id="secondrow">
					<input type="submit" value="Book Tickets" /></span>
				</div>
				</form>
				</div>
				<div id="bottom">
					<span id="busfeature" onclick="amentiesframe()">Amenties</span> 
					<span id="busfeature" style="margin: 0px 100px -10px 240px;"
						onclick="bdframe()">Boarding & Dropping Points</span> 
					<span id="busfeature">Cancellation Policy</span>
				</div>

				<hr noshade style="border-color: #5be5f9; color: white;" />

			</div>
		</div>
		
		<%
			
			  	}
			
			}
		}
		else
		{
		%>
			<div class="buslist">
			<div class="buscontent">
			<div id="part1">
			<br /><br/>
			<span style="margin:20px 20px 0px 200px;color:#3f4b51;font-size:20px;">There is no Bus Available</span>
			</div>
			<br /><br/>
			<input type="button" onclick="window.location.href='Index.jsp'" value="Refresh Page" />
			</div>
			</div>
		<%	
		}

	}
	else
	{
		String msg = (String)session.getAttribute("emptyList");
		if(msg!=null)
		{
		%>
		<div class="buslist">
		<div class="buscontent">
		<div id="part1">
		<br /><br/>
		<span style="margin:20px 20px 0px 160px;color:#3f4b51;font-size:30px;"><%=msg%></span>
		</div>
		<br /><br/>
		<input type="button" onclick="window.location.href='Index.jsp'" value="Refresh Page" />
		</div>
		</div>
		<%
		}
		else
		{
			%>
			<div class="buslist">
			<div class="buscontent">
			<div id="part1">
			<br /><br/>
			<span style="margin:20px 20px 0px 120px;color:#3f4b51;font-size:30px;">Please Select Search Bus Option</span>
			</div>
			<br /><br/>
			<input type="button" onclick="showsearchframe()" value="Click Here to Search Bus" />
			</div>
			</div>
			<%	
		}
	}
	
	%>
	


	<%@include file="SlideShow.jsp"%>
	<%@include file="Footer.jsp"%>


</body>
</html>