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
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.dataTables.min.css">
</head>
<body bgcolor="black">
	<%@ include file="AdminHeader.jsp"%>
	<script>
	var menu = document.getElementsByClassName("adminmenubar");
	for (i = 0; i < menu.length; i++) {
		menu[i].style.display = "none"
	}
	</script>
<div class="tabelframe operatorview" style="display:block;margin:100px 20px 20px 20px;width:105%;">
				<table id="example">
					<thead>
						<tr>
										<th>ID</th>
										<th>NUMBER</th>
										<th>TYPE</th>
										<th>OPERATOR ID</th>
										<th>DRIVER ID</th>
										<th>SOURCE CITY</th>
										<th>DESTINATION</th>
										<th>START TIME</th>
										<th>END TIME</th>
										<th>SEAT ID</th>
										<th>STATUS</th>
										<th>UPDATE</th>
										<th>DELETE</th>
										<th>BOOKINGS<th>
						</tr>
					</thead>
					<tfoot>
						<tr>
										<th>ID</th>
										<th>NUMBER</th>
										<th>TYPE</th>
										<th>OPERATOR ID</th>
										<th>DRIVER ID</th>
										<th>SOURCE CITY</th>
										<th>DESTINATION</th>
										<th>START TIME</th>
										<th>END TIME</th>
										<th>SEAT ID</th>
										<th>STATUS</th>
										<th>UPDATE</th>
										<th>DELETE</th>
										<th>BOOKINGS<th>
						</tr>
					</tfoot>
					<tbody>
<%
										busService = new BusServiceImpl(); 
										busList =	busService.retrieveBusList();
										for (Bus bus : busList) 
										{
											City c1 = new CityServiceImpl().retrieveCity(bus.getSourceCity());
											City c2 = new CityServiceImpl().retrieveCity(bus.getDestination());
									%>
									<tr>
										<td><%=bus.getBusId()%></td>
										<td><%=bus.getBusNumber()%></td>
										<td><%=bus.getBusType()%></td>
										<td><%=bus.getOperator().getOperatorId()%></td>
										<td><%=bus.getDriver().getDriverId()%></td>
										<td><%=c1.getCityName()%></td>
										<td><%=c2.getCityName()%></td>
										<td><%=bus.getStartTime()%></td>
										<td><%=bus.getEndTime()%></td>
										<td><%=bus.getSeat().getSeatId()%></td>
										<td><%=bus.getStatus()%></td>
														<td><a style="color: #004080;"
										href="UpdateBus.jsp?busid1=<%=bus.getBusId()%>">Update</a></td>
									<%
								if(bus.getStatus().equals("ACTIVE"))
								{
									status="Delete";
								}
								else
								{
									status="Recover";
								}
							%>
							<td><a style="color: #004080;" href="DeleteBusController?busid=<%=bus.getBusId()%>&status=<%=status%>"><%=status%></a></td>
														<td><a style="color: #004080;"
										href="ViewBusBookings.jsp?busid1=<%=bus.getBusId()%>">Bookings</a></td>
									</tr>
									<%}%>
					</tbody>
				</table>
		</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
	<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.flash.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	
	<script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>
	<script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script>
	<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
	<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
	<script>
	$(document).ready(function() {
	    $('#example').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
	    } );
	} );
	</script>
</body>
</html>