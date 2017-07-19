<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%!List<Driver> driverList=null; %>
<%!DriverService driverService=null; %>
<%!Driver driver=null; %>
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
<script>
function showform(txt) {
	if (txt == "add") {

		var MenuAdd = document.getElementsByClassName("operator");
		var MenuDelete = document.getElementsByClassName("operatordeleted");
		var MenuUpdate = document.getElementsByClassName("operatorupdate");
		var MenuView = document.getElementsByClassName("operatorview");
		for (i = 0; i < MenuAdd.length; i++) 
		{
			MenuAdd[i].style.display = "block"
			MenuView[i].style.display = "none"
			MenuDelete[i].style.display = "none"
			MenuUpdate[i].style.display = "none"
			
		}
	}
	else if (txt == "delete") {
		var MenuAdd = document.getElementsByClassName("operator");
		var MenuDelete = document.getElementsByClassName("operatordeleted");
		var MenuUpdate = document.getElementsByClassName("operatorupdate");
		var MenuView = document.getElementsByClassName("operatorview");
		for (i = 0; i < MenuDelete.length; i++) 
		{
			MenuAdd[i].style.display = "none"
			MenuDelete[i].style.display = "block"
				MenuView[i].style.display = "none"
					
						MenuUpdate[i].style.display = "none"
			
		}
	}
	else if (txt == "update") {
		var MenuAdd = document.getElementsByClassName("operator");
		var MenuDelete = document.getElementsByClassName("operatordeleted");
		var MenuUpdate = document.getElementsByClassName("operatorupdate");
		var MenuView = document.getElementsByClassName("operatorview");
		for (i = 0; i < MenuUpdate.length; i++) 
		{
			MenuDelete[i].style.display = "none"
			MenuUpdate[i].style.display = "block"
			MenuView[i].style.display = "none"
			MenuAdd[i].style.display = "none"
		}
	}
	else if(txt == "view")
		{

		var MenuAdd = document.getElementsByClassName("operator");
		var MenuDelete = document.getElementsByClassName("operatordeleted");
		var MenuUpdate = document.getElementsByClassName("operatorupdate");
		var MenuView = document.getElementsByClassName("operatorview");
		for (i = 0; i < MenuView.length; i++) {
		MenuView[i].style.display = "block"
		MenuDelete[i].style.display = "none"
		MenuUpdate[i].style.display = "none"
		MenuAdd[i].style.display = "none"
		
				
/*		MenuView[i].style.margin = "120px 0px 0px -300px";
		MenuView[i].style.width = "1100";*/
		}
		}
	
}
</script>
<body bgcolor="black">
	<%@ include file="AdminHeader.jsp"%>

	<script type="text/javascript">
		document.getElementById("username").innerHTML = '${username}';
		hideMenu();
	</script>


	<div class="mainscreen">
		<div id="firstpart">

			<div id="firstparttop">
				<span style="color: black; font-size: 15px; cursor: pointer">&#9776;Mouse
					Hover Here</span>
			</div>
			<div class="adminsubmenu">
				<button class="tablinks" onclick="showform('add')">ADD</button>
				<button class="tablinks" onclick="showform('delete')">DELETE</button>
				<button class="tablinks" onclick="showform('update')">UPDATE</button>
				<button class="tablinks" onclick="showform('view')">VIEW</button>

			</div>
		</div>
		<div id="secondpart">
			<div id="secondpart">
				<%
 					String validMessage=(String)request.getAttribute("Message");
 					if(validMessage!=null)
 					{
 						driver = (Driver)session.getAttribute("driver");
 						%>
 					<div class="adminform messageframe" style="display:block;height:50px;width:100%;margin-left:-200px;">
					<div class="form">
						<h2 style="font-size: 16px;"><%=driver.getDriverName()%>&nbsp<%=validMessage%></h2>
						<input style="width:30%;height:40px;float:right;margin: -50px 5px 5px 0px;" type="button" value="Back" onclick="window.location.href='Driver.jsp'"/>
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
						<input style="width:30%;height:40px;float:right;margin: -50px 5px 5px 0px;" type="button" value="Back" onclick="window.location.href='Driver.jsp'"/>
					</div>
					</div>
 						<%
 					}
				%>

				<% 
			String did =request.getParameter("did");
			if(did!=null)
			{
				driver = new DriverServiceImpl().retrieveDriver(did);
				if(driver!=null)
				{
				%>

				<div class="adminform operatorupdate" style="display: block;">
					<div class="form">
						<h2>Update Driver</h2>
						<form method="post" action="UpdateDriverController"
							name="updateForm">
							<select id="selectoption" name="did" onchange="retrievedata()">
								<option value="<%=driver.getDriverId()%>">Driver Id<%=driver.getDriverId()%>
								</option>
							</select> <input type="text" placeholder="Driver Name" id="t1"
								name="driverName" required="required" pattern="[a-zA-Z\s]+" title="Please Enter Valid Name"
								value="<%=driver.getDriverName()%>" disabled="disabled" /> <input
								type="email" placeholder="Driver Email" id="t2"
								name="driverEmail" required="required"
								value="<%=driver.getDriverEmail()%>" disabled="disabled" /> <input
								type="text" placeholder="Driver Address" id="t3" pattern="^[a-zA-Z0-9\s\,\''\-]*$" title="Please Enter Valid Address"
								name="driverAddress" required="required"
								value="<%=driver.getDriverAddress()%>" disabled="disabled" /> <input
								type="text" placeholder="Driver Licence Number" id="t4"
								name="driverLicenceNumber" required="required" pattern="^[a-zA-Z]{2}[0-9]{2}\s[0-9]+" title="Please Enter Valid Licence Number" 
								value="<%=driver.getDriverLicenceNumber() %>"
								disabled="disabled" /> <input type="text"
								placeholder="Driver Contact" id="t5" name="driverContact" pattern="[7-9]{1}[0-9]{9}" title="Please Enter Valid Contact"
								required="required" value="<%=driver.getDriverContact()%>"
								disabled="disabled" /> 
								<select id="t6"
								name="dstatus" disabled="disabled" >
								<option selected disabled>Status</option>
								<%
								
								if(driver.getStatus().equals("ACTIVE"))
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
									<option  selectedvalue="INACTIVE">INACTIVE</option>
									<%
									
								}
								
								
								
								%>

							</select> 
								
							</select> <input id="bt1" type="button" name="enable" value="Enable Field"
								onclick="visiblefield();" /> <input id="bt2" type="submit"
								name="add" value="Update" /> <input type="button" name="Back"
								value="Back" onclick="window.location.href='Driver.jsp'" />

						</form>
					</div>

				</div>
				<%}
				}
				else
				{
					%>


				<!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->
				<div class="adminform operator">
					<div class="form">
						<h2>Add Driver</h2>
						<form method="post" action="AddingDriverController" name="addForm">
							<input type="text" placeholder="Driver Name" name="driverName" pattern="[a-zA-Z\s]+" title="Please Enter Valid Name"
								required="required" /> <input type="email"
								placeholder="Driver Email" name="driverEmail"
								required="required" /> <input type="text"
								placeholder="Driver Address" name="driverAddress" pattern="^[a-zA-Z0-9\s\,\''\-]*$" title="Please Enter Valid Address"
								required="required" /> <input type="text"
								placeholder="Driver Licence number" name="driverLicenceNumber" pattern="^[a-zA-Z]{2}[0-9]{2}\s[0-9]+" title="Please Enter Valid Licence Number" 
								required="required" /> 
								
								<input type="text"
								placeholder="Driver Contact" name="driverContact" pattern="[7-9]{1}[0-9]{9}" title="Please Enter Valid Contact"
								required="required" /> <input type="submit" name="add"
								value="Add Driver" /> <input type="reset" name="reset"
								value="Reset" /> <input type="button" name="close"
								value="Close" onclick="window.location.href='AdminHome.jsp'" />
						</form>
					</div>

				</div>
				<!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->
				<%
					did = request.getParameter("did1");
					if(did!=null)
					{
					driverService = new DriverServiceImpl();
					driver = driverService.retrieveDriver(did);
					if(driver!=null)
					{
				%>
				<div class="adminform operatorupdate" style="display: block;">
					<div class="form">
						<h2>Update Driver</h2>
						<form method="post" action="UpdateDriverController?did=<%=did%>"
							name="updateForm">
							<script>
								function retrievedata() {
				
									var did = document
											.getElementById("selectoption").value;
									var fname = document
											.getElementById("updateForm");
									window.location.href = "Driver.jsp?did1="
											+ did
								}
							</script>


							<select id="selectoption" name="did" onchange="retrievedata()">
								<option selected disabled>Driver Id</option>
								<%
									driverService = new DriverServiceImpl();
									driverList = driverService.retrieveDriverList();
									for (Driver driver2 : driverList) {
								%>
								<option value="<%=driver2.getDriverId()%>"><%=driver2.getDriverId()%></option>
								<%
									}
								%>
							</select> <input type="text" placeholder="Driver Name" id="t1"
								name="driverName" required="required"
								value="<%=driver.getDriverName()%>" disabled="disabled" pattern="[a-zA-Z\s]+" title="Please Enter Valid Name"/> <input
								type="email" placeholder="Driver Email" id="t2"
								name="driverEmail" required="required"
								value="<%=driver.getDriverEmail()%>" disabled="disabled" /> <input
								type="text" placeholder="Driver Website" id="t3"
								name="driverWebsite" required="required"
								value="<%=driver.getDriverAddress()%>" disabled="disabled" pattern="^[a-zA-Z0-9\s\,\''\-]*$" title="Please Enter Valid Address"/> <input
								type="text" placeholder="Driver Licence" id="t4"
								name="driverFax" required="required" pattern="^[a-zA-Z]{2}[0-9]{2}\s[0-9]+" title="Please Enter Valid Licence Number" 
								value="<%=driver.getDriverLicenceNumber() %>"
								disabled="disabled" /> <input type="text"
								placeholder="Driver Contact" id="t5" name="driverContact" pattern="[7-9]{1}[0-9]{9}" title="Please Enter Valid Contact"
								required="required" value="<%=driver.getDriverContact()%>"
								disabled="disabled" /> 
							
							<select id="t6"
								name="dstatus" disabled="disabled" >
								<option selected disabled>Status</option>
								<%
								
								if(driver.getStatus().equals("ACTIVE"))
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
									<option  selectedvalue="INACTIVE">INACTIVE</option>
									<%
									
								}
								
								
								
								%>
								

							</select>  
							
							<input id="b1" type="button" name="enable" value="Enable Field"
								onclick="visiblefield();" /> <input id="b2" type="submit"
								name="add" value="Update" /> <input type="button" name="Back"
								value="Back" onclick="window.location.href='Driver.jsp'" />

						</form>
					</div>

				</div>
				<%}
				}
					else
					{
					%>
				<div class="adminform operatorupdate" style="display: block;">
					<div class="form">
						<h2>Update Driver</h2>
						<form method="post" action="Driver.jsp" name="updateForm">
							<script>
								function retrievedata() {
									alert("hi no value")
									var did = document
											.getElementById("selectoption").value;
									var fname = document
											.getElementById("updateForm");
									window.location.href = "Driver.jsp?did1="
											+ did
									var bt2 = document.getElementById("bt2");
									bt2.disabled = false;
									var bt1 = document.getElementById("bt1");
									bt1.disabled = false;

								}
							</script>

							<select id="selectoption" name="did" onchange="retrievedata()">
								<option selected disabled>Driver Id</option>
								<%
									driverService = new DriverServiceImpl();
											driverList = driverService.retrieveDriverList();
											for (Driver driver : driverList) {
								%>
								<option value="<%=driver.getDriverId()%>"><%=driver.getDriverId()%></option>
							
							<%
								}
							%>

							</select><input type="text" placeholder="Driver Name" name="DriverName" pattern="[a-zA-Z\s]+" title="Please Enter Valid Name"
								id="t1" required="required" disabled= "disabled" /> <input
								type="email" placeholder="Driver Email" name="driverEmail"
								id="t2" required="required" disabled="disabled" /> <input
								type="text" placeholder="Driver Address" name="driverAddress" pattern="^[a-zA-Z0-9\s\,\''\-]*$" title="Please Enter Valid Address"
								id="t3" required="required" disabled="disabled" /> <input
								type="text" placeholder="Driver Licence number" pattern="^[a-zA-Z]{2}[0-9]{2}\s[0-9]+" title="Please Enter Valid Licence Number" 
								name="driverLicenceNumber" id="t4" required="required"
								disabled="disabled" /> <input type="text"
								placeholder="Driver Contact" name="driverContact" id="t5" pattern="[7-9]{1}[0-9]{9}" title="Please Enter Valid Contact Number" 
								required="required" disabled="disabled" /> 
							<select id="t6"
								name="dstatus" >
								<option selected disabled>Status</option>
								<option value="ACTIVE">ACTIVE</option>
								<option value="INACTIVE">INACTIVE</option>

							</select> 
							<input id="bt1" type="button" name="enable" value="Enable Field"
								onclick="visiblefield();" /> <input id="bt2" type="submit"
								name="add" value="Update" /> <input type="button" name="Back"
								value="Back" onclick="window.location.href='Driver.jsp'" />

						</form>
					</div>

				</div>
				<%
					}
				%>
				<!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->
				<div class="adminform operatordeleted">
					<div class="form">
						<h2>Delete Driver</h2>
						<form method="post" action="DeleteDriverController"
							name="deleteForm">
							<select id="selectoption" name="driverid">
								<option selected disabled>Driver Id</option>
								<%
									driverService = new DriverServiceImpl();
										driverList = driverService.retrieveActiveDriverList();
										for (Driver driver : driverList) {
								%>
								<option><%=driver.getDriverId()%></option>
								<%
										session.setAttribute("status", "null");
										}
									}
								%>
							</select><br /> <input id="bt1" type="submit" name="delete"
								value="Delete" /> <input type="button" name="close"
								value="Close" onclick="window.location.href='Driver.jsp'" />
						</form>
					</div>

				</div>
<!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->
<div class="tabelframe operatorview" style="margin:100px 20px 20px -260px;width:120%;">
				<table id="example">
	<thead>
								<tr>
									<th>ID</th>
									<th>NAME</th>
									<th>EMAIL</th>
									<th>ADDRESS</th>
									<th>LICENCE NUMBER</th>
									<th>CONTACT</th>
									<th>STATUS</th>
									<th>UPDATE</th>
									<th>DELETE</th>

								</tr>
							<thead>
							<tfoot>
								<tr>
									<th>ID</th>
									<th>NAME</th>
									<th>EMAIL</th>
									<th>ADDRESS</th>
									<th>LICENCE NUMBER</th>
									<th>CONTACT</th>
									<th>STATUS</th>
									<th>UPDATE</th>
									<th>DELETE</th>

								</tr>
							<tfoot>
								<%
									driverService = new DriverServiceImpl();
										driverList = driverService.retrieveDriverList();
										for (Driver driver : driverList) {
								%>
								<tr>
									<td><%=driver.getDriverId()%></td>
									<td><%=driver.getDriverName()%></td>
									<td><%=driver.getDriverEmail()%></td>
									<td style="column: width:80px;"><%=driver.getDriverAddress()%></td>
									<td><%=driver.getDriverLicenceNumber()%></td>
									<td><%=driver.getDriverContact()%></td>
									<td><%=driver.getStatus()%></td>
									<td><a style="color: #004080;"
										href="Driver.jsp?did=<%=driver.getDriverId()%>">Update</a></td>
									<%
								if(driver.getStatus().equals("ACTIVE"))
								{
									status="Delete";
								}
								else
								{
									status="Recover";
								}
							%>
							<td><a style="color: #004080;" href="DeleteDriverController?driverid=<%=driver.getDriverId()%>&status=<%=status%>"><%=status%></a></td>

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
	

				<%
				
				%>
			</div>

		</div>


	</div>
<%-- 
	<%@ include file="AdminFooter.jsp"%> --%>
</body>
</html>