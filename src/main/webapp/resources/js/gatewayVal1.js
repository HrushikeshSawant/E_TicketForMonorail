window.onload = function() {
	document.form.onsubmit = function(){ return checkForm(); }
	document.form1.onsubmit = function(){ return checkForm1(); }

	document.getElementById("co_name").onblur = co_nameValidate;
	document.getElementById("cr_no").onblur = cr_noValidate;
	document.getElementById("exp").onblur = expValidate;
	document.getElementById("cvcpwd").onblur = cvcpwdValidate;
}

function co_nameValidate(){
	var co_name = document.getElementById("co_name");

	if(co_name.value == "") {
		document.getElementById("co_nameStatus").style.display = "block";
		co_name.parentNode.className = "form-group has-error has-feedback";
		return false;
	} else {
		document.getElementById("co_nameStatus").style.display = "none";
		co_name.parentNode.className = "form-group has-success has-feedback";
		return true;
	}
}

function cr_noValidate(){
	var cr_no = document.getElementById("cr_no");

	if(cr_no.value == "") {
		document.getElementById("cr_noStatus").style.display = "block";
		cr_no.parentNode.className = "form-group has-error has-feedback";
		return false;
	} else {
		document.getElementById("cr_noStatus").style.display = "none";
		cr_no.parentNode.className = "form-group has-success has-feedback";
		return true;
	}
}

function expValidate(){
	var exp = document.getElementById("exp");

	if(exp.value == "") {
		document.getElementById("expStatus").style.display = "block";
		exp.parentNode.className = "form-group has-error has-feedback";
		return false;
	} else {
		document.getElementById("expStatus").style.display = "none";
		exp.parentNode.className = "form-group has-success has-feedback";
		return true;
	}
}

function cvcpwdValidate(){
	var cvcpwd = document.getElementById("cvcpwd");

	if(cvcpwd.value == "") {
		document.getElementById("cvcpwdStatus").style.display = "block";
		cvcpwd.parentNode.className = "form-group has-error has-feedback";
		return false;
	} else {
		document.getElementById("cvcpwdStatus").style.display = "none";
		cvcpwd.parentNode.className = "form-group has-success has-feedback";
		return true;
	}
}



function checkForm(){

	var valid = true;



	if(!co_nameValidate()) valid = true;
	if(!cr_noValidate()) valid = true;
	if(!expValidate()) valid = true;
	if(!cvcpwdValidate()) valid = true;

	return valid;
}

function checkForm1(){

	var valid = true;

	if(!co_nameValidate()) valid = false;
	if(!cr_noValidate()) valid = false;
	if(!expValidate()) valid = false;
	if(!cvcpwdValidate()) valid = false;



	return valid;
}
