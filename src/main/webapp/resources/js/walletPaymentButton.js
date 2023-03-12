window.onload = function() {
	var walletAmount = document.getElementById("walletAmount");
	console.log(walletAmount.innerHTML);
	var fareAmount = document.getElementById("fareAmount");
	console.log(fareAmount.innerHTML);

	var walletPaymentButton = document.getElementById('walletPaymentButton');

	if(walletAmount.innerHTML < fareAmount.innerHTML)
	{
		walletPaymentButton.disabled = false;
	}
	else
	{
		walletPaymentButton.disabled = true;
	}
}