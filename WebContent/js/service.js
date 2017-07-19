function chooseService() {
	var SearchTab
	var slider
	var service = document.getElementById("userService").value
	
	if (service == "Search Bus") {
		var buslist = document.getElementsByClassName("buslist");
		for (i = 0; i < buslist.length; i++) {
			buslist[i].style.display = "none"
		} 
		var buslist = document.getElementsByClassName("buslist");
		slider = document.getElementsByClassName("slider-container");
		for (i = 0; i < slider.length; i++) {
			slider[i].style.display = "none"
				buslist[i].style.display = "none"
		}
		SearchTab = document.getElementsByClassName("searchframe");
		for (i = 0; i < SearchTab.length; i++) {
			SearchTab[i].style.display = "block"
		}
		
	} else if (service == "My Profile") {
		alert("in my profile")
		var buslist = document.getElementsByClassName("buslist");
		var slider = document.getElementsByClassName("slider-container");
		var search = document.getElementsByClassName("searchframe");
		var form = document.getElementsByClassName("form-style");
		for (i = 0; i < form.length; i++) {
			form[i].style.display = "block"
			slider[i].style.display = "none"
			buslist[i].style.display = "none"
				search[i].style.display = "none"
					
		}

	} else  
	{
		window.location.href = "Login.jsp"
	}
}

function showsearchframe() {

		var buslist = document.getElementsByClassName("buslist");
		slider = document.getElementsByClassName("slider-container");
		for (i = 0; i < slider.length; i++) {
			slider[i].style.display = "none"
			buslist[i].style.display = "none"
		}
		SearchTab = document.getElementsByClassName("searchframe");
		for (i = 0; i < SearchTab.length; i++) {
			SearchTab[i].style.display = "block"
		}

}

function onSearchAction() {
	alert("hi")
	var slider = document.getElementsByClassName("slider-container");
	for (i = 0; i < slider.length; i++) {
		slider[i].style.display = "none"
	}
}
// ==============================================================================================
function AdminService() {
	var SearchTab
	var service = document.getElementById("adminService").value
	if (service == "Manage") {
		SearchTab = document.getElementsByClassName("featureframe");
		for (i = 0; i < SearchTab.length; i++) {
			SearchTab[i].style.display = "block"
		}
		SearchTab = document.getElementsByClassName("myprofileframe");
		for (i = 0; i < SearchTab.length; i++) {
			SearchTab[i].style.display = "none"
		}
	} else if (service == "My Profile") {
		SearchTab = document.getElementsByClassName("featureframe");
		for (i = 0; i < SearchTab.length; i++) {
			SearchTab[i].style.display = "none"
		}
		SearchTab = document.getElementsByClassName("myprofileframe");
		for (i = 0; i < SearchTab.length; i++) {
			SearchTab[i].style.display = "block"
		}
	} else if (service == "Logout") {
		window.location.href = "Login.jsp"
	}

}
// ========================================================================================
function visiblefield() {
	var t1 = document.getElementById("t1");
	var t2 = document.getElementById("t2");
	var t3 = document.getElementById("t3");
	var t4 = document.getElementById("t4");
	var t5 = document.getElementById("t5");
	var t6 = document.getElementById("t6");
	var t7 = document.getElementById("t7");
	var opstatus = document.getElementById("opstatus");
	var dstatus = document.getElementById("dstatus");
	t1.disabled = false;
	t2.disabled = false;
	t3.disabled = false;
	t4.disabled = false;
	t5.disabled = false;
	t6.disabled = false;
	t7.disabled = false;
	opstatus.disabled = false;
	dstatus.disabled = false;
	
}

function message(name) {
	var SearchTab = document.getElementsByClassName("msg");
	for (i = 0; i < SearchTab.length; i++) {
		SearchTab[i].style.display = "block"
	}
}

function showbuslist() {
	var buslist = document.getElementsByClassName("buslist");
	for (i = 0; i < buslist.length; i++) {
		buslist[i].style.display = "block"
	}
	var slider = document.getElementsByClassName("slider-container");
	for (i = 0; i < slider.length; i++) {
		slider[i].style.display = "none"
	}
}

function adminService() {
	var service = document.getElementById("adminService").value
	if (service == "Manage") {
		window.location.href = "AdminHome.jsp";
		var slider = document.getElementsByClassName("slider-containerAdmin");
		for (i = 0; i < slider.length; i++) {
			slider[i].style.display = "none"
		}
	}
	if (service == "Logout") {
		window.location.href = "Login.jsp"
	}
}

function hideMenu() {
	var MenuTab = document.getElementsByClassName("adminmenubar");
	for (i = 0; i < MenuTab.length; i++) {
		MenuTab[i].style.display = "none"
	}
	var MenuTab = document.getElementsByClassName("operator");
	for (i = 0; i < MenuTab.length; i++) {
		MenuTab[i].style.display = "none"

	}
}

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

function retrievedata() {
	var opid = document.getElementById("selectoption").value;
	alert(opid)
	var bt1 = document.getElementById("bt1");
	var bt2 = document.getElementById("bt2");
	bt1.disabled = false;
	bt2.disabled = false;

}