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
									String bookid = request.getParameter("bid");
									System.out.println("Booking Id : "+bookid);
									
									
							
						%>
		
	 					<div class="adminform messageframe" style="display:block;height:50px;width:60%;margin-left:240px;">
					<div class="form">
						<h2 style="font-size: 16px;">Booking Id <%=bookid%></h2>
						<input style="width:30%;height:40px;float:right;margin: -50px 5px 5px 0px;" type="button" value="Close" onclick="window.location.href='Index.jsp'"/>
					</div>
					</div>
	
	<div class="tabelframe operatorview" style="display:block; width:80%;margin-left:130px;">
				<table id="example">
					<thead>
						<tr>
							<th>PASSENGER ID</th>
							<th>FIRST NAME</th>
							<th>LAST NAME</th>
							<th>EMAIL</th>
							<th>GENDER</th>
							<th>AGE</th>
							<th>CONTACT</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>PASSENGER ID</th>
							<th>FIRST NAME</th>
							<th>LAST NAME</th>
							<th>EMAIL</th>
							<th>GENDER</th>
							<th>AGE</th>
							<th>CONTACT</th>
						</tr>
					</tfoot>
					<tbody>
						<%
						
						List<Passenger> passengerList =  new PassengerServiceImpl().retrieveBookPassenger(bookid);
						System.out.println(passengerList.size());
						
						for(Passenger passenger : passengerList)
						{
							
						%>
					
						<tr>
							<td><%=passenger.getPassengerId()%></td>
							<td><%=passenger.getPassengerFirstname()%></td>
							<td><%=passenger.getPassengerLastname()%></td>
							<td><%=passenger.getPassengerEmail()%></td>
							<td><%=passenger.getPassengerGender()%></td>
							<td><%=passenger.getPassengerAge()%></td>
							<td><%=passenger.getPassengerContact()%></td>
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