<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
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
	<script>
	var menu = document.getElementsByClassName("adminmenubar");
	for (i = 0; i < menu.length; i++) {
		menu[i].style.display = "none"
	}
	</script>
	<%
			String busid = request.getParameter("busid1");
			if(busid!=null)
			{
					busService = new BusServiceImpl();
					bus = busService.retrieveBus(busid);
					if(bus!=null)
					{
						%>
						<div class="adminform operatorupdate"  style="display:block;width:50%;margin:100px 50px 50px 350px;">
							<div class="form">
								<h2>Update bus</h2>
								<form method="post" action="UpdatebusController?busid=<%=busid%>" name="updateForm">
								<script>
										function retrievedata() {
											alert("hi in selection")
											var busid = document
													.getElementById("selectoption").value;
											var fname = document
													.getElementById("updateForm");
											window.location.href = "UpdateBus?busid1="
													+ busid
										}
									</script>


									<select id="selectoption" name="busid"
										onchange="retrievedata()">
										<option selected disabled>bus Id</option>
										<%
											busService = new BusServiceImpl();
											busList = busService.retrieveBusList();
											for (Bus bus2 : busList) {
										%>
										<option value="<%=bus2.getBusId()%>"><%=bus2.getBusId()%></option>
										<%
											}
										%>
									<input type="text" placeholder="Bus Number" id="t1"
								name="busNumber" required="required"
								value="<%=bus.getBusNumber()%>" disabled="disabled" />
							
								<select id="t2" name="busType" disabled="disabled">
								<option selected disabled>Bus Type</option>
								<% 
								if(bus.getBusType().equals("AC"))
								{
								%>
								<option selected value="AC">AC</option>
								<option value="NON AC">NON AC</option>
								<%
								}
								else
								{
								%>
								<option  value="AC">AC</option>
								<option selected value="NON AC">NON AC</option>
								<%
								}
								%>
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
								cityService = new CityServiceImpl();
								cityList = cityService.retrieveActiveCityList();
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
							<select name="destCity" required="required">
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
								<input id="t4" type="number" max="23" min="0" placeholder="Start Time" name="startTime" required="required" /> 
								<input id="t3" type="number" max="23" min="0" placeholder="End Time" name="endTime" required="required" /> 
								
								
								<select id="selectSeat" name="seat">
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
									
								

							<select id="t5" name="busstatus" disabled="disabled">
								<option selected disabled>Status</option>
								
								<% 
								if(bus.getStatus().equals("ACTIVE"))
								{
								%>
								<option selected value="ACTIVE">ACTIVE</option>
								<option value="INACTIVE">INACTIVE</option>
								<%
								}
								else
								{
								%>
								<option  value="ACTIVE">ACTIVE</option>
								<option selected value="INACTIVE">INACTIVE</option>
								<%
								}
								%>
							</select> <input id="bt1" type="button" name="enable" value="Enable Field"
								onclick="visiblefield();" /> 
								<input id="bt2" type="submit"
								name="add" value="Update"/> 
								<input type="button" name="Back"
								value="Back" onclick="window.location.href='Bus.jsp'" />

						</form>
				</div>

			</div>
						<%
					}
			}
			else
			{
				%>
				<div class="adminform operatorupdate"  style="display:block;width:50%;margin:100px 50px 50px 350px;">
							<div class="form">
								<h2>Update bus</h2>
								<form method="post" action="UpdatebusController?busid=<%=busid%>" name="updateForm">
								<script>
										function retrievedata() {
											alert("hi in selection")
											var busid = document
													.getElementById("selectoption").value;
											var fname = document
													.getElementById("updateForm");
											window.location.href = "UpdateBus.jsp?busid1="
													+ busid
										}
									</script>


									<select id="selectoption" name="busid"
										onchange="retrievedata()">
										<option selected disabled>bus Id</option>
										<%
											busService = new BusServiceImpl();
											busList = busService.retrieveBusList();
											for (Bus bus2 : busList) 
											{
										%>
										<option value="<%=bus2.getBusId()%>"><%=bus2.getBusId()%></option>
										<%
											}
										%>
							<input type="text" placeholder="Bus Number" name="busNumber" required="required" /> 
							<select id="t2" name="busType">
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
								cityService = new CityServiceImpl();
								cityList = cityService.retrieveActiveCityList();
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
							<select name="destCity" required="required">
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
								<input id ="t3" type="number" max="23" min="0" placeholder="Start Time" name="startTime" required="required" /> 
								<input id="t4" type="number" max="23" min="0" placeholder="End Time" name="endTime" required="required" /> 
								
								
								<select id="selectSeat" name="seat">
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
									
								

							<select id="t5" name="busstatus" disabled="disabled">
								<option selected disabled>Status</option>

								<option  value="ACTIVE">ACTIVE</option>
								<option selected value="INACTIVE">INACTIVE</option>

							</select> <input id="bt1" type="button" name="enable" value="Enable Field"
								onclick="visiblefield();" /> 
								<input id="bt2" type="submit"
								name="add" value="Update"/> 
								<input type="button" name="Back"
								value="Back" onclick="window.location.href='Bus.jsp'" />

						</form>
				</div>

			</div>
				<%
				
			}

 			%>

</body>
</html>