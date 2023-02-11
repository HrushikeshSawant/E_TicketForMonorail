window.onload = function() {
	document.form.onsubmit = function() {
		return checkForm();
	}
	document.getElementById("emailInput").onblur = emailValidate;
	document.getElementById("mobInput").onblur = mobileValidate;
	document.getElementById("passInput").onblur = passwordValidate;
	document.getElementById("cpassInput").onblur = cpasswordValidate;
}

function nameValidate() {
	var nameInput = document.getElementById("nameInput");

	if (nameInput.value == "") {
		document.getElementById("nameInputStatus").style.display = "block";
		nameInput.parentNode.className = "form-group has-feedback";
		return false;
	} else {
		document.getElementById("nameInputStatus").style.display = "none";
		nameInput.parentNode.className = "form-group has-feedback";
		return true;
	}
}

function emailValidate() {

	document.getElementById("e1").style.display = "none";

	if (emailInput.value == "") {
		document.getElementById("emailInputStatus").innerHTML = "Email address is required!";
		document.getElementById("emailInputStatus").style.display = "block";
		emailInput.parentNode.className = "form-group has-feedback";
		return false;
	} else if (!validEmailAddress(emailInput.value)) {
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

function mobileValidate() {

	if (mobInput.value == "") {
		document.getElementById("mobInputStatus").innerHTML = "Mobile Number is required!";
		document.getElementById("mobInputStatus").style.display = "block";
		mobInput.parentNode.className = "form-group has-feedback";
		return false;
	} else if (!validMobile(mobInput.value)) {
		document.getElementById("mobInputStatus").innerHTML = "Please enter valid Mobile Number!";
		document.getElementById("mobInputStatus").style.display = "block";
		mobInput.parentNode.className = "form-group has-feedback";
		return false;
	} else {
		document.getElementById("mobInputStatus").style.display = "none";
		mobInput.parentNode.className = "form-group has-feedback";
		return true;
	}
}

function passwordValidate() {

	if (passInput.value == "") {
		document.getElementById("passInputStatus").innerHTML = "Password is required!";
		document.getElementById("passInputStatus").style.display = "block";
		passInput.parentNode.className = "form-group has-feedback";
		return false;
	} else if (!validPassword(passInput.value)) {
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

function cpasswordValidate() {

	if (cpassInput.value == "") {
		document.getElementById("cpassInputStatus").innerHTML = "Confirm Password is required!";
		document.getElementById("cpassInputStatus").style.display = "block";
		cpassInput.parentNode.className = "form-group has-feedback";
		return false;
	} else if (passInput.value != cpassInput.value) {
		document.getElementById("cpassInputStatus").innerHTML = "Password does not match!";
		document.getElementById("cpassInputStatus").style.display = "block";
		cpassInput.parentNode.className = "form-group has-feedback";
		return false;
	} else {
		document.getElementById("cpassInputStatus").style.display = "none";
		cpassInput.parentNode.className = "form-group has-feedback";
		return true;
	}
}

function checkForm() {

	var valid = true;

	var emailInput = document.getElementById("emailInput");
	var mobInput = document.getElementById("mobInput");
	var passInput = document.getElementById("passInput");

	if (!nameValidate())
		valid = false;
	if (!emailValidate())
		valid = false;
	if (!mobileValidate())
		valid = false;
	if (!passwordValidate())
		valid = false;
	if (!cpasswordValidate())
		valid = false;

	return valid;
}

function validEmailAddress(email) {

	var pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	return pattern.test(email);
}

function validMobile(mobile) {

	var pattern = /^[789]\d{9}$/;
	return pattern.test(mobile);
}

function validPassword(password) {

	var pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
	return pattern.test(password);
}