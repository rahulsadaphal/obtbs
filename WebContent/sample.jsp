<%@page import="com.manipal.service.OperatorService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%!List<Bus> busList; %>
<%!BusService busService=null; %>
<%!Bus bus=null; %>
<%!String status=null; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css\admin.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.14/css/jquery.dataTables.min.css">
</head>
<body>
	<div class="tabelframe">
				<div class="tabelframe operatorview" style="width:70%;margin: 110px 0px 0px -130px;">
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
						</tr>
					</tfoot>
					<tbody>
								<%-- <%
										busService = new BusServiceImpl(); 
										busList =	busService.retrieveBusList();
										for (Bus bus : busList) 
										{

									%>
									<tr>
										<td><%=bus.getBusId()%></td>
										<td><%=bus.getBusNumber()%></td>
										<td><%=bus.getBusType()%></td>
										<td><%=bus.getOperator().getOperatorId()%></td>
										<td><%=bus.getDriver().getDriverId()%></td>
										<td><%=bus.getSourceCity()%></td>
										<td><%=bus.getDestination()%></td>
										<td><%=bus.getStartTime()%></td>
										<td><%=bus.getEndTime()%></td>
										<td><%=bus.getSeat().getSeatId()%></td>
										<td><%=bus.getStatus()%></td>
														<td><a style="color: #004080;"
										href="Bus.jsp?busid=<%=bus.getBusId()%>">Update</a></td>
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

									</tr>
									<%}%> --%>
					</tbody>
				</table>
		</div>
</div>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.14/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
	
</body>
</html>