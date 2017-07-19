<%@page import="com.manipal.service.impl.*"%>
<%@page import="com.manipal.service.*"%>
<%@page import="com.manipal.model.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%!List<City> cityList; %>
<%!CityService cityService=null; %>
<%!City city=null; %>
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
 						city = (City)session.getAttribute("city");
 						%>
 					<div class="adminform messageframe" style="display:block;height:50px;width:100%;margin-left:-200px;">
					<div class="form">
						<h2 style="font-size: 16px;"><%=city.getCityName()%>&nbsp<%=validMessage%></h2>
						<input style="width:30%;height:40px;float:right;margin: -50px 5px 5px 0px;" type="button" value="Back" onclick="window.location.href='City.jsp'"/>
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
						<input style="width:30%;height:40px;float:right;margin: -50px 5px 5px 0px;" type="button" value="Back" onclick="window.location.href='City.jsp'"/>
					</div>
					</div>
 						<%
 					}
				%>

				
				<% 
			String cityid =	request.getParameter("cityid");
			if(cityid!=null)
			{
				city = new CityServiceImpl().retrieveCity(cityid);
				if(city!=null)
				{
				%>

				<div class="adminform operatorupdate" style="display:block;">
					<div class="form">
						<h2>Update City</h2>
						<form method="post" action="UpdateCityController" name="updateForm">
							<select id="selectoption" name="cityid"
								onchange="retrievedata()">
								<option value="<%=city.getCityId()%>">City
									Id <%=city.getCityId()%></option>
							</select> <input type="text" placeholder="City Name" id="t1"
								name="cityName" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid Name"
								value="<%=city.getCityName()%>" disabled="disabled" />
							<input type="text" placeholder="City State" id="t2"
								name="cityState" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid State"
								value="<%=city.getCityState()%>" disabled="disabled" />

							<select id="t3" name="cityStatus" disabled="disabled">
								<option selected disabled>Status</option>
								<% 
								if(city.getStatus().equals("ACTIVE"))
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
								value="Back" onclick="window.location.href='City.jsp'" />

						</form>
					</div>

				</div>
				<%}
				}
					else
					{
					%>

<!-- ------------------------------------------------ELSE PART START---------------------------------------------------------------------------------------------------------------->
			<%
			cityid = request.getParameter("cityid1");
			if(cityid!=null)
			{
					cityService = new CityServiceImpl();
					city = cityService.retrieveCity(cityid);
					if(city!=null)
					{
						%>
						<div class="adminform operatorupdate" style="display:block;" >
							<div class="form">
								<h2>Update City</h2>
								<form method="post" action="UpdateCityController?cityid=<%=cityid%>" name="updateForm">
								<script>
										function retrievedata() {
											alert("hi in selection")
											var cityid = document
													.getElementById("selectoption").value;
											var fname = document
													.getElementById("updateForm");
											window.location.href = "City.jsp?cityid1="
													+ cityid
										}
									</script>


									<select id="selectoption" name="cityid"
										onchange="retrievedata()">
										<option selected disabled>City Id</option>
										<%
											cityService = new CityServiceImpl();
											cityList = cityService.retrieveCityList();
											for (City city2 : cityList) {
										%>
										<option value="<%=city2.getCityId()%>"><%=city2.getCityId()%></option>
										<%
											}
										%>
									</select> <input type="text" placeholder="City Name" id="t1"
										name="cityName" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid Name"
										value="<%=city.getCityName()%>" disabled="disabled" />
									<input type="text" placeholder="City State" id="t2"
										name="cityState" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid State"
										value="<%=city.getCityState()%>" disabled="disabled" />
									<select id="t3" name="cityStatus" disabled="disabled">
										<option selected disabled>Status</option>
										<% 
										if(city.getStatus().equals("ACTIVE"))
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
										value="Back" onclick="window.location.href='City.jsp'" />

								</form>
							</div>

						</div>
						<%
					}
			}
			else
			{
				%>
				<div class="adminform operatorupdate">
					<div class="form">
						<h2>Update City</h2>
						<form method="post" action="City.jsp" name="updateForm">
						<script>
								function retrievedata() {
									var cityid = document
											.getElementById("selectoption").value;
									var fname = document
											.getElementById("updateForm");
									window.location.href = "City.jsp?cityid1="
											+ cityid
									var bt2 = document.getElementById("bt2");
									bt2.disabled = false;
									var bt1 = document.getElementById("bt1");
									bt1.disabled = false;

								}
							</script>

							<select id="selectoption" name="cityid"
								onchange="retrievedata()">
								<option selected disabled>City Id</option>
								<%
									cityService = new CityServiceImpl();
											cityList = cityService.retrieveCityList();
											for (City city : cityList) {
								%>
								<option value="<%=city.getCityId()%>"><%=city.getCityId()%></option>
								<%
									}
								%>
							</select> <input type="text" placeholder="City Name" id="t1"
								name="cityName" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid Name" disabled="disabled" />
							<input type="text" placeholder="City State" id="t3"
								name="cityState" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid State" disabled="disabled" />
							<select id ="t3" name="cityStatus" disabled="disabled">
								<option selected disabled>Status</option>
								<option value="ACTIVE">ACTIVE</option>
								<option value="INACTIVE">INACTIVE</option>
								
							</select> 
							
							<input id="bt1" type="button" name="enable" value="Enable Field"
								onclick="visiblefield();" /> 
								<input id="bt2" type="submit"
								name="add" value="Update" /> 
								<input type="button" name="Back"
								value="Back" onclick="window.location.href='City.jsp'" />

						</form>
					</div>

				</div>
				<%
				
			}

 			%>
					
<!-- //--------------ADD CITY-----------------------------------------------------------------------------------------------------------------------------------// -->
				<div class="adminform operator">
					<div class="form">
						<h2>Add City</h2>
						<form method="post" action="AddCityController" name="addForm">
							<input type="text" placeholder="City Name"
								name="cityName" required="required" pattern="[a-zA-Z]+" title="Please Enter Valid Name" /> <input type="text"
								placeholder="City State" name="cityState"
								required="required" pattern="[a-zA-Z]+" title="Please Enter Valid State" /> <input type="submit" name="add"
								value="Add City" /> <input type="reset" name="reset"
								value="Reset" /> <input type="button" name="close"
								value="Close" onclick="window.location.href='AdminHome.jsp'" />
						</form>
					</div>

				</div>
<!-- //-----------DELETE CITY--------------------------------------------------------------------------------------------------------------------------------------// -->
				<div class="adminform operatordeleted">
					<div class="form">
						<h2>Delete City</h2>
						<form method="post" action="DeleteCityController" name="deleteForm">
							<select id="selectoption" name="cityid">
								<option selected disabled>City Id</option>
								<%
									cityService = new CityServiceImpl();
										cityList = cityService.retrieveActiveCityList();
										for (City city : cityList) {
								%>
								<option><%=city.getCityId()%></option>
								<%
									}
								%>
							</select><br /> <input id="bt1" type="submit" name="delete"
								value="Delete"/>
							<input type="button" name="close" value="Close"
								onclick="window.location.href='City.jsp'" />
						</form>
					</div>

				</div>
<!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->
<div class="tabelframe operatorview" style="width:70%;margin: 110px 0px 0px -130px;">
				<table id="example">
					<thead>
						<tr>
									<th>ID</th>
									<th>NAME</th>
									<th>STATE</th>
									<th>STATUS</th>
									<th>UPDATE</th>
									<th>DELETE</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
										<th>ID</th>
									<th>NAME</th>
									<th>STATE</th>
									<th>STATUS</th>
									<th>UPDATE</th>
									<th>DELETE</th>
						</tr>
					</tfoot>
					<tbody>
								<%
									cityService = new CityServiceImpl();
										cityList = cityService.retrieveCityList();
										for (City city : cityList) {
								%>
								<tr>
									<td><%=city.getCityId()%></td>
									<td><%=city.getCityName()%></td>
									<td><%=city.getCityState()%></td>
									<td><%=city.getStatus()%></td>
									<td><a style="color: #004080;"
										href="City.jsp?cityid=<%=city.getCityId()%>">Update</a></td>
									<%
								if(city.getStatus().equals("ACTIVE"))
								{
									status="Delete";
								}
								else
								{
									status="Recover";
								}
							%>
							<td><a style="color: #004080;" href="DeleteCityController?cityid=<%=city.getCityId()%>&status=<%=status%>"><%=status%></a></td>

						</tr>
						<%
									}
								%>
					</tbody>
				</table>
		</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.14/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
<!-- //-------------------------------------------------------------------------------------------------------------------------------------------------// -->
	
	
	
		
<!-- ------------------------------------------------ELSE PART END--------------------------------------------------------------------------------------------------------------	-->			
						<%
					}
				%>
		</div> <!-- SECOND PART -->
	</div> <!-- SECOND PART -->
</div><!-- MAIN SCREEN -->

	
<%-- 	<%@include file="SlideShow2.jsp" %> --%>
<%@ include file="AdminFooter.jsp" %>
</body>
</html>