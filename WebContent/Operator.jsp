<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%!List<Operator> operatorList; %>
<%!OperatorService operatorService=null; %>
<%!Operator operator=null; %>
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
 						operator = (Operator)session.getAttribute("operator");
 						%>
 					<div class="adminform messageframe" style="display:block;height:50px;width:100%;margin-left:-200px;">
					<div class="form">
						<h2 style="font-size: 16px;"><%=operator.getOperatorName()%>&nbsp<%=validMessage%></h2>
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

				<% 
			String opid =	request.getParameter("opid");
			if(opid!=null)
			{
				operator = new OperatorServiceImpl().retrieveOperator(opid);
				if(operator!=null)
				{
				%>

				<div class="adminform operatorupdate" style="display:block;">
					<div class="form">
						<h2>Update Operator</h2>
						<form method="post" action="UpdateOperatorController" name="updateForm">
							<select id="selectoption" name="opid"
								onchange="retrievedata()">
								<option value="<%=operator.getOperatorId()%>">Operator
									Id <%=operator.getOperatorId()%></option>
							</select> <input type="text" placeholder="Operator Name" id="t1"
								name="operatorName" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid Name"
								value="<%=operator.getOperatorName()%>" disabled="disabled" />
							<input type="email" placeholder="Operator Email" id="t2"
								name="operatorEmail" required="required"
								value="<%=operator.getOperatorEmail()%>" disabled="disabled" />
							<input type="text" placeholder="Operator Website" id="t3"
								name="operatorWebsite" required="required" pattern="(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.([-a-zA-Z0-9@:%_\+.~#?&//=]*)" title="Please Enter Valid Website"
								value="<%=operator.getOperatorWebsite()%>" disabled="disabled" />
							<input type="text" placeholder="Operator Fax Number" id="t4" pattern="[1-9]{1}[0-9]{5}$" pattern="Please Enter Valid Fax Number"
								name="operatorFax" required="required"
								value="<%=operator.getOperatorFaxNumber()%>" disabled="disabled" />
							<input type="text" placeholder="Operator Address" id="t5"
								name="operatorAddress" required="required"
								value="<%=operator.getOperatorAddress()%>" disabled="disabled" pattern="^[a-zA-Z0-9\s\,\''\-]*$" title="Please Enter Valid Address"/>
							<input type="text" placeholder="Operator Contact" id="t6"
								name="operatorContact" required="required" pattern="[7-9]{1}[0-9]{9}" pattern="Please Enter Valid Contact"
								value="<%=operator.getOperatorContact()%>" disabled="disabled" />

							<select id="t7" name="opstatus" disabled="disabled">
								<option selected disabled>Status</option>
								<% 
								if(operator.getStatus().equals("ACTIVE"))
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
								value="Back" onclick="window.location.href='Operator.jsp'" />

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
						<h2>Add Operator</h2>
						<form method="post" action="AddOperatorController" name="addForm">
							<input type="text" placeholder="Operator Name" pattern="[a-zA-Z\s]+" title="Please Enter Valid Name"
								name="operatorName" required="required" /> <input type="email"
								placeholder="Operator Email" name="operatorEmail"
								required="required" /> <input type="text"
								placeholder="Operator Website" name="operatorWebsite" pattern="(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.([-a-zA-Z0-9@:%_\+.~#?&//=]*)" title="Please Enter Valid Website"
								required="required" /> <input type="text"
								placeholder="Operator Fax Number" name="operatorFax" pattern="[1-9]{1}[0-9]{5}$" title="Please Enter Valid Fax Number"
								required="required" /> <input type="text"
								placeholder="Operator Address" name="operatorAddress" pattern="^[a-zA-Z0-9\s\,\''\-]*$" title="Please Enter Valid Address"
								required="required" /> <input type="text"
								placeholder="Operator Contact" name="operatorContact" pattern="[7-9]{1}[0-9]{9}" title="Please Enter Valid Contact"
								required="required" /> <input type="submit" name="add"
								value="Add Operator" /> <input type="reset" name="reset"
								value="Reset" /> <input type="button" name="close"
								value="Close" onclick="window.location.href='AdminHome.jsp'" />
						</form>
					</div>

</div><!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->
				<%
					opid = request.getParameter("opid1");
					if(opid!=null)
					{
					operatorService = new OperatorServiceImpl();
					operator = operatorService.retrieveOperator(opid);
					if(operator!=null)
					{
				%>
				<div class="adminform operatorupdate" style="display:block;">
					<div class="form">
						<h2>Update Operator</h2>
						<form method="post" action="UpdateOperatorController?opid=<%=opid%>" name="updateForm">
						<script>
								function retrievedata() {
									alert("hi in selection")
									var opid = document
											.getElementById("selectoption").value;
									var fname = document
											.getElementById("updateForm");
									window.location.href = "Operator.jsp?opid="
											+ opid
								}
							</script>


							<select id="selectoption" name="opid"
								onchange="retrievedata()">
								<option selected disabled>Operator Id</option>
								<%
									operatorService = new OperatorServiceImpl();
									operatorList = operatorService.retrieveOperatorList();
									for (Operator operator2 : operatorList) {
								%>
								<option value="<%=operator2.getOperatorId()%>"><%=operator2.getOperatorId()%></option>
								<%
									}
								%>
							</select> <input type="text" placeholder="Operator Name" id="t1"
								name="operatorName" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid Name"
								value="<%=operator.getOperatorName()%>" disabled="disabled" />
							<input type="email" placeholder="Operator Email" id="t2"
								name="operatorEmail" required="required"
								value="<%=operator.getOperatorEmail()%>" disabled="disabled" />
							<input type="text" placeholder="Operator Website" id="t3" pattern="(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.([-a-zA-Z0-9@:%_\+.~#?&//=]*)" title="Please Enter Valid Website"
								name="operatorWebsite" required="required"
								value="<%=operator.getOperatorWebsite()%>" disabled="disabled" />
							<input type="text" placeholder="Operator Fax Number" id="t4"
								name="operatorFax" required="required" pattern="[1-9]{1}[0-9]{5}" title="Please Enter Valid Fax Number"
								value="<%=operator.getOperatorFaxNumber()%>" disabled="disabled" />
							<input type="text" placeholder="Operator Address" id="t5"
								name="operatorAddress" required="required"
								value="<%=operator.getOperatorAddress()%>" disabled="disabled" pattern="^[a-zA-Z0-9\s\,\''\-]*$" title="Please Enter Valid Address"/>
							<input type="text" placeholder="Operator Contact" id="t6" title="[7-9]{1}[0-9]{9}" title="Please Enter Valid Contact"
								name="operatorContact" required="required"
								value="<%=operator.getOperatorContact()%>" disabled="disabled" />
<select id="t7" name="opstatus" disabled="disabled">
								<option selected disabled>Status</option>
								<% 
								if(operator.getStatus().equals("ACTIVE"))
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
							</select>
							<input id="b1" type="button" name="enable" value="Enable Field"
								onclick="visiblefield();" /> 
								<input id="b2" type="submit"
								name="add" value="Update" /> 
								<input type="button" name="Back"
								value="Back" onclick="window.location.href='Operator.jsp'" />

						</form>
					</div>

				</div>
				<%}
				}
					else
					{
					%>
				<div class="adminform operatorupdate" id="update" >
					<div class="form">
						<h2>Update Operator</h2>
						<form method="post" action="Operator.jsp" name="updateForm">
						<script>
								function retrievedata() {
									alert("hi no value")
									var opid = document
											.getElementById("selectoption").value;
									var fname = document
											.getElementById("updateForm");
									window.location.href = "Operator.jsp?opid1="
											+ opid
									var bt2 = document.getElementById("bt2");
									bt2.disabled = false;
									var bt1 = document.getElementById("bt1");
									bt1.disabled = false;

								}
							</script>

							<select id="selectoption" name="opid"
								onchange="retrievedata()">
								<option selected disabled>Operator Id</option>
								<%
									operatorService = new OperatorServiceImpl();
											operatorList = operatorService.retrieveOperatorList();
											for (Operator operator : operatorList) {
								%>
								<option value="<%=operator.getOperatorId()%>"><%=operator.getOperatorId()%></option>
								<%
									}
								%>
							</select> <input type="text" placeholder="Operator Name" id="t1"
								name="operatorName" required="required" disabled="disabled" pattern="[a-zA-Z]+" title="Please Enter Valid Name"/>
							<input type="email" placeholder="Operator Email" id="t2"
								name="operatorEmail" required="required" disabled="disabled" />
							<input type="text" placeholder="Operator Website" id="t3" pattern="(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.([-a-zA-Z0-9@:%_\+.~#?&//=]*)" title="Please Enter Valid Website"
								name="operatorWebsite" required="required" disabled="disabled" />
							<input type="text" placeholder="Operator Fax Number" id="t4" pattern="[1-9]{1}[0-9]{5}" title="Please Enter Valid Fax Number"
								name="operatorFax" required="required" disabled="disabled" /> <input
								type="text" placeholder="Operator Address" id="t5" pattern="^[a-zA-Z0-9\s\,\''\-]*$" title="Please Enter Valid Address"
								name="operatorAddress" required="required" disabled="disabled" />
							<input type="text" placeholder="Operator Contact" id="t6" pattern="[7-9]{1}[0-9]{9}" title="Please Enter Valid Contact"
								name="operatorContact" required="required" disabled="disabled" />

							<select id ="t7" name="opstatus" disabled="disabled">
								<option selected disabled>Status</option>
								<option value="ACTIVE">ACTIVE</option>
								<option value="INACTIVE">INACTIVE</option>
								
							</select> 
							
							<input id="bt1" type="button" name="enable" value="Enable Field"
								onclick="visiblefield();" /> 
								<input id="bt2" type="submit"
								name="add" value="Update" /> 
								<input type="button" name="Back"
								value="Back" onclick="window.location.href='Operator.jsp'" />

						</form>
					</div>

				</div>
				<%
					}
				%>
<!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->
				<div class="adminform operatordeleted">
					<div class="form">
						<h2>Delete Operator</h2>
						<form method="post" action="DeleteOperatorController" name="deleteForm">
							<select id="selectoption" name="opid">
								<option selected disabled>Operator Id</option>
								<%
									operatorService = new OperatorServiceImpl();
										operatorList = operatorService.retrieveActiveOperatorList();
										for (Operator operator : operatorList) {
								%>
								<option><%=operator.getOperatorId()%></option>
								<%
									session.setAttribute("status", "null");
									}
								%>
							</select><br /> <input id="bt1" type="submit" name="delete"
								value="Delete"/>
							<input type="button" name="close" value="Close"
								onclick="window.location.href='Operator.jsp'" />
						</form>
					</div>

				</div>
<!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->
			
<div class="tabelframe operatorview">
				<table id="example">
					<thead>
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>EMAIL</th>
							<th>WEBSITE</th>
							<th>FAX NUMBER</th>
							<th>ADDRESS</th>
							<th>CONTACT</th>
							<th>STATUS</th>
							<th>UPDATE</th>
							<th>DELETE</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>EMAIL</th>
							<th>WEBSITE</th>
							<th>FAX NUMBER</th>
							<th>ADDRESS</th>
							<th>CONTACT</th>
							<th>STATUS</th>
							<th>UPDATE</th>
							<th>DELETE</th>
						</tr>
					</tfoot>
					<tbody>
						<%
									operatorService = new OperatorServiceImpl();
										operatorList = operatorService.retrieveOperatorList();
										for (Operator operator : operatorList) {
								%>
						<tr>
							<td><%=operator.getOperatorId()%></td>
							<td><%=operator.getOperatorName()%></td>
							<td><%=operator.getOperatorEmail()%></td>
							<td><%=operator.getOperatorWebsite()%></td>
							<td><%=operator.getOperatorFaxNumber()%></td>
							<td><%=operator.getOperatorAddress()%></td>
							<td><%=operator.getOperatorContact()%></td>
							<td><%=operator.getStatus()%></td>
							<td><a style="color: #004080;"
								href="Operator.jsp?opid=<%=operator.getOperatorId()%>">Update</a></td>
							<%
								if(operator.getStatus().equals("ACTIVE"))
								{
									status="Delete";
								}
								else
								{
									status="Recover";
								}
							%>
							<td><a style="color: #004080;" href="DeleteOperatorController?opid=<%=operator.getOperatorId()%>&status=<%=status%>"><%=status%></a></td>

						</tr>
						<%
									}
								%>
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
				%>
			</div>

		</div>


	</div>

	
<%-- <%-- 	<%@include file="SlideShow2.jsp" %> --%>
<%@ include file="AdminFooter.jsp" %> --%>
</body>
</html>