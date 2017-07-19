<%@page import="com.manipal.service.impl.BookingServiceImpl"%>
<%@page import="com.manipal.service.BookingService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css\admin.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css\admin.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.14/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.dataTables.min.css">
</head>
<body bgcolor="black">
		
		
		<%		
 					String validMessage=(String)request.getAttribute("Message");
 					if(validMessage!=null)
 					{
 						%>
 					<div class="adminform messageframe" style="display:block;height:50px;width:60%;margin-left:240px;">
					<div class="form">
						<h2 style="font-size: 16px;"><%=validMessage%></h2>
						<input style="width:30%;height:40px;float:right;margin: -50px 5px 5px 0px;" type="button" value="Back" onclick="window.location.href='Index.jsp'"/>
					</div>
					</div>
					<%
						if(validMessage.equals("Payment Done Successfully"))
						{
					%>

	
	<div class="tabelframe operatorview" style="display:block; width:80%;margin-left:130px;">
				<table id="example">
					<thead>
						<tr>
							<th>BOOKING ID</th>
							<th>SOURCE CITY</th>
							<th>DESTINATION</th>
							<th>BUS ID</th>
							<th>OPERATOR</th>
							<th>BOOKING DATE</th>
							<th>DEPARTURE DATE</th>
							<th>SEATS BOOKED</th>
							<th>AMOUNT PAID</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>BOOKING ID</th>
							<th>SOURCE CITY</th>
							<th>DESTINATION</th>
							<th>BUS ID</th>
							<th>OPERATOR</th>
							<th>BOOKING DATE</th>
							<th>DEPARTURE DATE</th>
							<th>SEATS BOOKED</th>
							<th>AMOUNT PAID</th>
						</tr>
					</tfoot>
					<tbody>
						<%
									String bookingId = (String) request.getAttribute("bookingId");
									Double total = (Double) request.getAttribute("total");
									BookingService bookingService = new BookingServiceImpl();
									Booking	booking = bookingService.retrieveBooking(bookingId);
									Bus bus = new BusServiceImpl().retrieveBus(booking.getDummy().getBusId());
									City c1 = new CityServiceImpl().retrieveCity(bus.getSourceCity());
									City c2 = new CityServiceImpl().retrieveCity(bus.getDestination());
						%>
						<tr>
							<td><%=booking.getBookingId()%></td>
							<td><%=c1.getCityName()%></td>
							<td><%=c2.getCityName()%></td>
							<td><%=bus.getBusId()%></td>
							<td><%=bus.getOperator().getOperatorName()%></td>
							<td><%=booking.getBookingDate()%></td>
							<td><%=booking.getDummy().getDepartureDate().split(" ")[0]%></td>
							<td><a style="color: #004080;"
										href="PassengerDetails.jsp?bid=<%=booking.getBookingId()%>"><%=booking.getNumberOfSeatsBooked()%></a></td>
							
							<td><%=total %></td>
							
							
						</tr>
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
	
	<%
	}
 					}
	%>

</body>
</html>