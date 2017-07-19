
function card_validation()  
{  
var cardnumber = document.registerForm.passUsername;
var card_len = cardnumber.value.length;  
if (card_len == 0 || card_len >16)  
{  
alert("Invalid card number");   
return false;  
}  
return true;  
 if (cardnumber<=0)
{
	alert("Card number is not valid");
	return false;
}
return true;
if(isNaN(cardnumber)){
	alert("Invalid card number")
	return false;
}
return true;

}


function CVV_number()  
{  
var cvv = document.registerForm.passPassword;
var cvv_len = cvv.value.length;  
if (cvv_len == 0 ||cvv_len < 3)  
{  
alert("Invalid CVV number");   
return false;  
}  
return true;  
if (cvv<=0)
{
	alert("CVV number is not valid");
	return false;
}
return true;
if(isNaN(cvv)){
	alert("Invalid card number")
	return false;
}
return true;

}

function Accountno_validation()
{
var accno = document.registerForm.passPassword;
var acc_len = accno.value.length;  
if (acc_len == 0 ||acc_len < 15)  
{  
alert("Invalid Account number");   
return false;  
}  
return true;  
if (accno<=0)
{
	alert("Account number is not valid");
	return false;
}
return true;
if(isNaN(accno)){
	alert("Account card number")
	return false;
}
return true;

}	


function password_validation()
{
	var password=document.registerForm.passPassword;
	var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
	if(password.value.match(decimal))   
	{   
		return true;  
	}  
	else  
	{   
		alert('Wrong...!')  
		return false;  
	}  
}   
 function confirmpassword()
 {
	var password=document.registerForm.passPassword;
	var confirmpassword=document.registerForm.passPassword;
	if(password.value!=confirmpassword.value){
		alert("Password and confirm password do not match")
		return false;
	}return true;
 }




