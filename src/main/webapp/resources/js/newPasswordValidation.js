window.onload = function() {
	document.form.onsubmit = function() {
		return checkForm();
	}
	document.getElementById("passInput").onblur = passwordValidate;
	document.getElementById("cpassInput").onblur = cpasswordValidate;
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
	var passInput = document.getElementById("passInput");

	if (!passwordValidate())
		valid = false;
	if (!cpasswordValidate())
		valid = false;

	return valid;
}

function validPassword(password) {

	var pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
	return pattern.test(password);
}