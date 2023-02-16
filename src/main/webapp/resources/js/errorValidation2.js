errorValidate();

document.getElementById("nameInput").onblur = fieldClear;

function fieldClear() 
{
	document.getElementById('e1').style.display = "none";
	document.getElementById('e2').style.display = "none";
	document.getElementById('e3').style.display = "none";
	nameValidate();
}

function errorValidate() 
{
	var emailMsg = document.getElementById('e1');
	var globalMsg = document.getElementById('e2');
	var mobileMsg = document.getElementById('e3');
	console.log(emailMsg.innerHTML.length);
	console.log(globalMsg.innerHTML.length);
	console.log(emailMsg.value);
	console.log(globalMsg.value);
	
	if(emailMsg.value == "" || emailMsg.innerHTML.trim().length == 0 || emailMsg == null || emailMsg.innerHTML.length == 4)
	{
		console.log("Null");
		document.getElementById('e1').style.display = "none";
	}
	else
	{
		console.log("Not Null or Empty");
		document.getElementById('e1').style.display = "block";
	}
	
	if(globalMsg.value == "" || globalMsg.innerHTML.trim().length == 0 || globalMsg == null || globalMsg.innerHTML.length == 4)
	{
		console.log("Null");
		document.getElementById('e2').style.display = "none";
	}
	else
	{
		console.log("Not Null or Empty");
		document.getElementById('e2').style.display = "block";
	}
	
	if(mobileMsg.value == "" || mobileMsg.innerHTML.trim().length == 0 || mobileMsg == null || mobileMsg.innerHTML.length == 4)
	{
		console.log("Null");
		document.getElementById('e3').style.display = "none";
	}
	else
	{
		console.log("Not Null or Empty");
		document.getElementById('e3').style.display = "block";
	}
}

