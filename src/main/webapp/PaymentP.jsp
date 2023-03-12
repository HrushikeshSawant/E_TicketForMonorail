<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Payment</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/payment.ico" />
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' rel='stylesheet'>
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/gatewayStyle.css">
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/resources/js/gatewayVal.js'></script>
<script type='text/javascript' src='gateway.js'></script>
</head>
<body oncontextmenu='return false' class='snippet-body'>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("Email")==null){
			response.sendRedirect("Login.jsp");
		}
	%>
	<div class="container-fluid px-0" id="bg-div">
	    <div class="row justify-content-center">
	        <div class="col-lg-9 col-12">
	            <div class="card card0">
	                <div class="d-flex" id="wrapper">
	                    <!-- Sidebar -->
	                    <div class="bg-light border-right" id="sidebar-wrapper">
	                        <div class="sidebar-heading pt-5 pb-4"><strong>PAY WITH</strong></div>
	                        <div class="list-group list-group-flush"> <a data-toggle="tab" href="#menu1" id="tab1" class="tabs list-group-item bg-light">
	                        	<div class="list-div my-2">
	                            	<div class="fa fa-home"></div> &nbsp;&nbsp; Bank
	                            </div>
	                            </a> <a data-toggle="tab" href="#menu2" id="tab2" class="tabs list-group-item active1">
	                            <div class="list-div my-2">
	                                 <div class="fa fa-credit-card"></div> &nbsp;&nbsp; Card
	                            </div>
	                            </a>
	                        </div>
	                    </div> <!-- Page Content -->
	                    <div id="page-content-wrapper">
	                    	<div class="row pt-3" id="border-btm">
	                        	<div class="col-4"> <button class="btn btn-success mt-4 ml-3 mb-3" id="menu-toggle" style="display:none;">
	                            	<div class="bar4"></div>
	                                <div class="bar4"></div>
	                                <div class="bar4"></div></button>
	                            </div>
	                            <div class="col-8">
	                                <div class="row justify-content-right">
	                                    <div class="col-12">
	                                    	<p class="mb-0 mr-4 mt-4 text-right" style="float:right;">${Name}</p>
	                                    </div>
	                                </div>
	                                <div class="row justify-content-right">
	                                    <div class="col-12">
	                                        <p class="mb-0 mr-4 text-right" float:"right">Pay: <span class="top-highlight"><i class="fas fa-rupee-sign"></i> ${Fare}</span> </p>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <br>
	                        <div class="row justify-content-center">
	                        <!--    <div class="text-center" id="test">Pay</div>-->
	                        </div>
	                        <div class="tab-content">
	                            <div id="menu1" class="tab-pane">
	                                <div class="row justify-content-center">
	                                    <div class="col-11">
	                                        <div class="form-card">
	                                            <h3 class="mt-0 mb-4 text-center">Enter bank details to pay</h3>
	                                            <form action="PassT" method="post" id="form" class="form" name="form">
	                                                <div class="row form-group has-feedback">
	                                                  <span id = "bk_nmStatus" class = "errorHeader"><b>*</b></span>
	                                                    <div class="col-12 form-group has-feedback">
	                                                        <div class="input-group"> <input type="text" id="bk_nm" name="bk_nm" value="" autocomplete="off"><label>BANK NAME</label></div>
	                                                    </div>
	                                                </div>
	                                                <div class="row">
	                                                    <div class="col-12 form-group has-feedback">
	                                                        <span id = "ben_nmStatus" class = "errorHeader"><b>*</b></span>
	                                                        <div class="input-group form-group has-feedback"> <input type="text" name="ben_nm" id="ben_nm" value="" autocomplete="off"> <label>BENEFICIARY NAME</label> </div>
	                                                    </div>
	                                                    <div class="col-12 form-group has-feedback">
	                                                        <span id = "scodeStatus" class = "errorHeader"><b>*</b></span>
	                                                        <div class="input-group form-group has-feedback"> <input type="text" id="scode" name="scode" value="" autocomplete="off" class="placeicon" minlength="8" maxlength="11"> <label>ACCOUNT NUMBER</label> </div>
	                                                    </div>
	                                                    <div class="col-12 form-group has-feedback">
	                                                      <span id = "icodeStatus" class = "errorHeader"><b>*</b></span>
	                                                      <div class="input-group form-group has-feedback"> <input type="text" id="icode" name="icode" value="" autocomplete="off" class="placeicon" minlength="8" maxlength="11"> <label>IFSC CODE</label> </div>
	                                                    </div>
	                                                </div>
	                                                <div class="row">
	                                                    <div class="col-md-12"> <input type="submit" value="Pay" class="btn btn-success placeicon" name="btn"> </div>
	                                                </div>
	                                            </form>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            <div id="menu2" class="tab-pane in active">
	                                <div class="row justify-content-center">
	                                    <div class="col-11">
	                                        <div class="form-card">
	                                            <h3 class="mt-0 mb-4 text-center">Enter your card details to pay</h3>
			 									<img src="<%=request.getContextPath()%>/resources/images/card.png"></img>
	                                            <form action="PassT" method="post" id="form1" class="form1" name="form1">
	                                                <div class="row">
	                                                    <div class="col-12 form-group has-feedback">
	                                                        <span id = "co_nameStatus" class = "errorHeader"><b>*</b></span>
	                                                        <div class="input-group form-group has-feedback"> <input type="text" id="co_name" name="co_name" value="" autocomplete="off" minlength="10" maxlength="30"> <label>NAME ON CARD</label> </div>
	                                                    </div>
	                                                </div>
	                                                <div class="row">
	                                                  <div class="col-12 form-group has-feedback">
	                                                      <span id = "cr_noStatus" class = "errorHeader"><b>*</b></span>
	                                                      <div class="input-group form-group has-feedback"> <input type="text" id="cr_no" name="cr_no" value="" autocomplete="off" minlength="19" maxlength="19"> <label>CARD NUMBER</label> </div>
	                                                  </div>
	                                                    <div class="col-6 form-group has-feedback">
	                                                        <span id = "expStatus" class = "errorHeader"><b>*</b></span>
	                                                        <div class="input-group form-group has-feedback"> <input type="text" name="exp" id="exp" value="" placeholder="MM/YY" minlength="5" maxlength="5" autocomplete="off"> <label>CARD EXPIRY</label> </div>
	                                                    </div>
	                                                    <div class="col-6 form-group has-feedback">
	                                                        <span id = "cvcpwdStatus" class = "errorHeader"><b>*</b></span>
	                                                        <div class="input-group form-group has-feedback"> <input type="password" id="cvcpwd" name="cvcpwd" value="" placeholder="&#9679;&#9679;&#9679;" class="placeicon" minlength="3" maxlength="3" autocomplete="off"> <label>CVV</label> </div>
	                                                    </div>
	                                                </div>
	                                                <div class="row">
	                                                    <div class="col-md-12"> <input type="submit" value="PAY" class="btn btn-success placeicon" name="btn"> </div>
	                                                </div>
	                                                <div class="row">
	                                                    <div class="col-md-12">
	                                                        <!--<p class="text-center mb-5" id="below-btn"><a href="#">Use a test card</a></p>-->
	                                                    </div>
	                                                </div>
	                                            </form>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>