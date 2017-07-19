<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%!List<Booking> bookingList=null; %>
<%!BookingService bookingService=null; %>
<%!Booking booking=null; %>
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
	<%
	String busId = request.getParameter("busid1");
	if(busId!=null)
	{
	%>
<div class="tabelframe operatorview" style="display:block;margin:100px 20px 20px 20px;width:90%;">
				<table id="example">
					<thead>
						<tr>
										<th>BOOKING ID</th>
										<th>SOURCE CITY</th>
										<th>DESTINATION</th>
										<th>BUS ID</th>
										<th>BOOKING DATE</th>
										<th>DEPARTURE DATE</th>
										<th>BOOKED SEAT</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
										<th>BOOKING ID</th>
										<th>SOURCE CITY</th>
										<th>DESTINATION</th>
										<th>BUS ID</th>
										<th>BOOKING DATE</th>
										<th>DEPARTURE DATE</th>
										<th>BOOKED SEAT</th>
						</tr>
					</tfoot>
					<tbody>
									<%
										bookingService = new BookingServiceImpl(); 
										bookingList =	bookingService.retrieveBusBooking(busId);
										for(Booking booking : bookingList)
										{
											Bus bus = new BusServiceImpl().retrieveBus(busId);
											City c1 = new CityServiceImpl().retrieveCity(bus.getSourceCity());
											City c2 = new CityServiceImpl().retrieveCity(bus.getDestination());

									%>
									<tr>
										<td><%=booking.getBookingId()%></td>
										<td><%=c1.getCityName()%></td>
										<td><%=c2.getCityName()%></td>
										<td><%=busId%></td>
										<td><%=booking.getBookingDate()%></td>
										<td><%=booking.getDummy().getDepartureDate()%></td>
										<td><%=booking.getNumberOfSeatsBooked()%></td>
										
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
	<%} %>
</body>
</html>