window.onload = function() {
	document.form.onsubmit = function(){ return checkForm(); }
	document.form1.onsubmit = function(){ return checkForm1(); }
  document.getElementById("bk_nm").onblur = bk_nmValidate;
	document.getElementById("ben_nm").onblur = ben_nmValidate;
	document.getElementById("scode").onblur = scodeValidate;
	document.getElementById("icode").onblur = icodeValidate;

	document.getElementById("co_name").onblur = co_nameValidate;
	document.getElementById("cr_no").onblur = cr_noValidate;
	document.getElementById("exp").onblur = expValidate;
	document.getElementById("cvcpwd").onblur = cvcpwdValidate;
}


function bk_nmValidate(){
	var bk_nm = document.getElementById("bk_nm");

	if(bk_nm.value == "") {
		document.getElementById("bk_nmStatus").style.display = "block";
		bk_nm.parentNode.className = "form-group has-error has-feedback";
		return false;
	} else {
		document.getElementById("bk_nmStatus").style.display = "none";
		bk_nm.parentNode.className = "form-group has-success has-feedback";
		return true;
	}
}

function ben_nmValidate(){
	var ben_nm = document.getElementById("ben_nm");

	if(ben_nm.value == "") {
		document.getElementById("ben_nmStatus").style.display = "block";
		ben_nm.parentNode.className = "form-group has-error has-feedback";
		return false;
	} else {
		document.getElementById("ben_nmStatus").style.display = "none";
		ben_nm.parentNode.className = "form-group has-success has-feedback";
		return true;
	}
}

function scodeValidate(){
	var scode = document.getElementById("scode");

	if(scode.value == "") {
		document.getElementById("scodeStatus").style.display = "block";
		scode.parentNode.className = "form-group has-error has-feedback";
		return false;
	} else {
		document.getElementById("scodeStatus").style.display = "none";
		scode.parentNode.className = "form-group has-success has-feedback";
		return true;
	}
}

function icodeValidate(){
	var icode = document.getElementById("icode");

	if(icode.value == "") {
		document.getElementById("icodeStatus").style.display = "block";
		icode.parentNode.className = "form-group has-error has-feedback";
		return false;
	} else {
		document.getElementById("icodeStatus").style.display = "none";
		icode.parentNode.className = "form-group has-success has-feedback";
		return true;
	}
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
	if(!bk_nmValidate()) valid = false;
	if(!ben_nmValidate()) valid = false;
	if(!scodeValidate()) valid = false;
	if(!icodeValidate()) valid = false;

	return valid;
}

function checkForm1(){

	var valid = true;
	if(!bk_nmValidate()) valid = true;
	if(!ben_nmValidate()) valid = true;
	if(!scodeValidate()) valid = true;
	if(!icodeValidate()) valid = true;

	if(!co_nameValidate()) valid = false;
	if(!cr_noValidate()) valid = false;
	if(!expValidate()) valid = false;
	if(!cvcpwdValidate()) valid = false;



	return valid;
}
