window.onload = function() { 
	document.form.onsubmit = function()  { return checkForm(); } 
	document.getElementById("passInput").onblur = passwordValidate;
}

function emailValidate() { 
	var emailInput = document.getElementById("emailInput"); 
	
	document.getElementById("e1").style.display = "none";
	document.getElementById("e2").style.display = "none";

	if(emailInput.value == "") { 
		document.getElementById("emailInputStatus").style.display = "block"; 
		emailInput.parentNode.className = "form-group has-feedback"; 
		return false; 
	} else if(!validEmailAddress(emailInput.value)) { 
		document.getElementById("emailInputStatus").innerHTML = "Incorrect email address format!"; 
		document.getElementById("emailInputStatus").style.display = "block"; 
		emailInput.parentNode.className = "form-group has-feedback";
		return false; 
	} else { 
		document.getElementById("emailInputStatus").style.display = "none"; 
		emailInput.parentNode.className = "form-group has-feedback";
		return true; 
	}
}

function passwordValidate(){
	
	document.getElementById("e1").style.display = "none";
	document.getElementById("e2").style.display = "none";
	
	if(passInput.value == "") { 
		document.getElementById("passInputStatus").innerHTML = "Password is required!"; 
		document.getElementById("passInputStatus").style.display = "block"; 
		passInput.parentNode.className = "form-group has-feedback"; 			
		return false; 
	} else if(!validPassword(passInput.value)) { 
		document.getElementById("passInputStatus").innerHTML = "The password must contain atleast one Upper case, Lower case letter, a Number and a Special character and of altleast 8 character long!"; 
		document.getElementById("passInputStatus").style.display = "block"; 
		passInput.parentNode.className = "form-group has-feedback";
		return false; 	
	} else { 
		document.getElementById("passInputStatus").style.display = "none"; 
		passInput.parentNode.className = "form-group has-feedback";
		return true; 
	}
	
}

function checkForm(){

	var valid = true;
	
	var passInput= document.getElementById("passInput");

	if(!emailValidate()) valid = false; 
	if(!passwordValidate()) valid = false; 

	return valid;
}

function validEmailAddress(email){
	
	var pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/; 
	return pattern.test(email); 
}

function validPassword(password){
	
	var pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
	return pattern.test(password);
}