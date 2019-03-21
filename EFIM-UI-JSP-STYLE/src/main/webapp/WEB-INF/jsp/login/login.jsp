<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/resources/css/MasterStyle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#register").click(function() {
			$("#loginForm:visible").css("visibility", "hidden");
			$("#registerForm:visible").css("visibility", "visible");
			$("#forgotForm:visible").css("visibility", "hidden");
		});
		$("#login").click(function() {
			$("#loginForm:visible").css("visibility", "visible");
			$("#registerForm:visible").css("visibility", "hidden");
			$("#forgotForm:visible").css("visibility", "hidden");
		});
		$("#forgotPassword").click(function() {
			$("#loginForm:visible").css("visibility", "hidden");
			$("#registerForm:visible").css("visibility", "hidden");
			$("#forgotForm:visible").css("visibility", "visible");
		});

		$("#loginForm:visible").css("visibility", "visibility");
		$("#registerForm:visible").css("visibility", "hidden");
		$("#forgotForm:visible").css("visibility", "hidden");
	});
</script>


<!-- <link rel="stylesheet" href="/resources/css/MasterStyle.css" type="text/css" > -->


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>

</head>

<body background="http://localhost:2020/EFIM-CORE-IBATIS/PictureCtl/GetTheBackgroundPicture?projectCode=EFIM&pictureName=EFIMBG.png"
	style="background-repeat: no-repeat; background-size: cover;">
     
	<div class="introHead">
		<div class="buttonHead">
			<button title="Login" id="login" class="subButtonHead1">LOGIN</button>
			<button title="Register" id="register" class="subButtonHead2">REGISTER</button>
			<button title="Forgot Password" id="forgotPassword" class="subButtonHead3">FORGOT PASSWORD</button>
		</div>
	</div>

	<form:form action="${pageContext.request.contextPath}/event"
		method="post" modelAttribute="login" id="loginForm">
		<div class="regLoginBox">
			<p style="position : relative; left: 35%;">
				<form:input path="inputUserId" class = "text-box" placeHolder="Nama User" />
			</p>
			<p style="position : relative; left: 35%; top : 5%;">
				<form:password path="inputPassword" class = "text-box" placeHolder="Password"/>
			</p>
			<p style="position : relative; left: 8%; top : 17%;">
			<input 
			   type="SUBMIT" value="LOGIN" name="LOG IN" class="buttonRegBox" />
			</p>
		</div>
	</form:form>

	<form:form action="${pageContext.request.contextPath}/event" 
		method="post" modelAttribute="forgot" id="forgotForm">
		<div class="regLoginBox">
			<p style="position : relative; left: 35%;">
				<form:input path="forgotUserId" placeHolder="USER ID" class = "text-box"/>
			</p>
			<p style="position : relative; left: 8%; top : 17%;">
			<input type="SUBMIT" value="FORGOT" name="RESET PASSWORD" class="buttonRegBox"  />
			</p>
		</div>
	</form:form>

	<form:form action="${pageContext.request.contextPath}/event" 
		method="post" modelAttribute="register" id="registerForm">
		<div class="regLoginBox">
		     
		   <div id="userInfoId">  
			<p>
				<form:input path="registerUserName" placeHolder = "Nama User" class = "text-box-register"/>
			</p>
			<p>
				<form:input path="registerUserId" placeHolder = "User Id" class = "text-box-register"/>
			</p>
			
			<button type="button"><i class="material-icons">arrow_forward</i></button>
		   </div>
			
		   <div id="userContact">
			<p>
				<form:input path="registerUserMail" placeHolder = "User Email" class = "text-box-register"/>
			</p>
		   
			<p>
				<form:input path="registerUserPhone" placeHolder = "User Telp." class = "text-box-register"/>
			</p>
			
			<p>
			<button type="button"><i class="material-icons">arrow_back</i></button>
			<button type="button"><i class="material-icons">arrow_forward</i></button>
			</p>
		   </div>	
		   
		   <div id="userPassword"> 	
			<p>
				<form:input path="registerUserPassword" placeHolder = "Password" class = "text-box-register"/>
			</p>
			<p>
				<form:input path="confirmUserRegisterPassword" placeHolder = "Konfirmasi Password" class = "text-box-register"/>
			</p>
			<button type="button"><i class="material-icons">arrow_back</i></button>
		   </div>
		   	
			<input type="SUBMIT" value="REGISTER" name="register" class="buttonRegBox"/>
		</div>
	</form:form>



</body>
</html>