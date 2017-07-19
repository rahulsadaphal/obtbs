<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%!List<Bus> busList=null;List<Operator> operatorList=null;List<City> cityList=null;List<Driver> driverList=null;List<Seat> seatList=null; %>
<%!BusService busService=null;CityService cityService=null;DriverService driverService=null;OperatorService operatorService=null;SeatService seatService=null; %>
<%!Bus bus=null;Driver driver=null;City city=null;Operator operator=null; %>
<%!String status=null; %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css\admin.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.14/css/jquery.dataTables.min.css">
</head>
<body bgcolor="black">
	<%@ include file="AdminHeader.jsp"%>

	<script type="text/javascript">
		document.getElementById("username").innerHTML = '${username}';
		hideMenu();
	</script>


	<div class="mainscreen">
		<div id="firstpart">
		
				<div id="firstparttop">
		<span style="color:white;font-size:16px;cursor:pointer">&#9776;Mouse Hover Here</span>
		</div>
			<div class="adminsubmenu">
				<button class="tablinks" onclick="showform('add')">ADD</button>
				<button class="tablinks" onclick="showform('delete')">DELETE</button>
				<button class="tablinks" onclick="window.location.href='UpdateBus.jsp'">UPDATE</button>
				<button class="tablinks" onclick="window.location.href='ViewBus.jsp'">VIEW</button>

			</div>
		</div>
	<div id="secondpart">
			<div id="secondpart">
				<%
 					String validMessage=(String)request.getAttribute("Message");
 					if(validMessage!=null)
 					{
 						Bus bus = (Bus)session.getAttribute("bus");
 						%>
 					<div class="adminform messageframe" style="display:block;height:50px;width:100%;margin-left:-200px;">
					<div class="form">
						<h2 style="font-size: 16px;"><%=bus.getBusNumber()%>&nbsp<%=validMessage%></h2>
						<input style="width:30%;height:40px;float:right;margin: -50px 5px 5px 0px;" type="button" value="Back" onclick="window.location.href='Operator.jsp'"/>
					</div>
					</div>
 						<%
 					}
 					else
 					{
						%>
 					<div class="adminform messageframe" style="display:block;height:50px;width:100%;margin-left:-200px;">
					<div class="form">
						<h2 style="font-size: 16px;">Do Some Perform Operation</h2>
						<input style="width:30%;height:40px;float:right;margin: -50px 5px 5px 0px;" type="button" value="Back" onclick="window.location.href='Operator.jsp'"/>
					</div>
					</div>
 						<%
 					}
				%>


		<!-- //--------------ADD bus-----------------------------------------------------------------------------------------------------------------------------------// -->
				<div class="adminform operator">
					<div class="form">
						<h2>Add bus</h2>
						<form method="post" action="AddBusController" name="addForm">
								
							<input type="text" placeholder="Bus Number" name="busNumber" required="required" /> 
							<select id="selectType" name="busType">
								<option value="AC">AC</option>
								<option value="NON AC">NON AC</option>
							</select> 

							<select id="selectOperator" name="operatorId">
								<option selected disabled>Operator Id</option>
								<%
									operatorService = new OperatorServiceImpl();
									operatorList = operatorService.retrieveActiveOperatorList();
									for (Operator operator : operatorList) 
									{
								%>
								<option value="<%=operator.getOperatorId()%>"><%=operator.getOperatorId()%></option>
								<%
									}
								%>
							</select>  
							
							<select id="selectDriver" name="driverId">
								<option selected disabled>Driver Id</option>
								<%
									driverService = new DriverServiceImpl();
									driverList =driverService.retrieveAvailableDriverList();
									for (Driver driver : driverList) 
									{
								%>
								<option value="<%=driver.getDriverId()%>"><%=driver.getDriverId()%></option>
								<%
									}
								%>
							</select>  
							<%
								CityService cityService = new CityServiceImpl();
								List<City> cityList = cityService.retrieveActiveCityList();
							%>
							<select name="sourceCity" required="required">
								<option selected disabled>Source City</option>
							<%
								for(City city : cityList)
      							{
      						%>
							<option><%=city.getCityName()%></option>
							<%
      							}
      						%>
							</select> 
							<%
								cityService = new CityServiceImpl();
								cityList = cityService.retrieveActiveCityList();
							%>
							<select name="dest" required="required">
								<option selected disabled>Destination City</option>
							<%
								for(City city : cityList)
      							{
      						%>
							<option><%=city.getCityName()%></option>
							<%
      							}
      						%>
							</select> 
								<input type="number" max="23" min="0" placeholder="Start Time" name="startTime" required="required" /> 
								<input type="number" max="23" min="0" placeholder="End Time" name="endTime" required="required" /> 
								
								
								<select id="selectSeat" name="seatId">
								<option selected disabled>Seat Id</option>
								<%
									seatService = new SeatServiceImpl();
									seatList =seatService.retrieveSeatList();
									for (Seat seat : seatList) 
									{
								%>
								<option value="<%=seat.getSeatId()%>"><%=seat.getSeatId()%></option>
								<%
									}
								%>
							</select> 
							<input type="submit" name="add"
								value="Add Operator" /> 
							<input type="reset" name="reset"
								value="Reset" /> 
							<input type="button" name="close"
								value="Close" onclick="window.location.href='AdminHome.jsp'" />
						</form>
					</div>
				</div>
<!-- //-----------DELETE bus--------------------------------------------------------------------------------------------------------------------------------------// -->
				<div class="adminform operatordeleted">
					<div class="form">
						<h2>Delete bus</h2>
						<form method="post" action="DeleteBusController" name="deleteForm">
							<select id="selectoption" name="busid">
								<option selected disabled>Bus Id</option>
								<%
									busService = new BusServiceImpl();
										busList = busService.retrieveActiveBusList();
										for (Bus bus : busList) {
								%>
								<option><%=bus.getBusId()%></option>
								<%
									}
								%>
							</select><br /> <input id="bt1" type="submit" name="delete"
								value="Delete"/>
							<input type="button" name="close" value="Close"
								onclick="window.location.href='Bus.jsp'" />
						</form>
					</div>

				</div>
<!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->

			</div>

		</div>


	</div>

	
<%-- 	<%@include file="SlideShow2.jsp" %> --%>
<%-- <%@ include file="AdminFooter.jsp" %> --%>
</body>
</html>