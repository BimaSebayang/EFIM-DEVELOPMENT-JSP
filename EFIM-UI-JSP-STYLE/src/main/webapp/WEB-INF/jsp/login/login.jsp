<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#register").click(function() {
			$("#loginForm:visible").css("visibility","hidden");
			$("#registerForm:visible").css("visibility","visible");
			$("#forgotForm:visible").css("visibility","hidden");
		});
		$("#login").click(function() {
			$("#loginForm:visible").css("visibility","visible");
			$("#registerForm:visible").css("visibility","hidden");
			$("#forgotForm:visible").css("visibility","hidden");
		});
		$("#forgotPassword").click(function() {
			$("#loginForm:visible").css("visibility","hidden");
			$("#registerForm:visible").css("visibility","hidden");
			$("#forgotForm:visible").css("visibility","visible");
		}); 
			
		$("#loginForm:visible").css("visibility","visibility");
		$("#registerForm:visible").css("visibility","hidden");
		$("#forgotForm:visible").css("visibility","hidden");
	});
</script>




<%-- <link rel="stylesheet" href="<core:url value="/css/MasterStyle.css"/>"> --%>
<link rel="stylesheet" href="css/MasterStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body background="images/loginBg.jpg"
	style="background-repeat: no-repeat; background-size: cover;">



	<div class="introHead">
		<div class="buttonHead">
			<button title="Login" id="login" >Login</button>
			<button title="Register" id="register">Register</button>
			<button title="Forgot Password" id="forgotPassword">Forgot
				Password</button>
		</div>
	</div>



	<form:form action="${pageContext.request.contextPath}/event"
		method="post" modelAttribute="login" id="loginForm">
		<div class="regLoginBox">
			<p>
				<label>Nama User</label>
				<form:input path="inputUserId" />
			</p>
			<p>
				<label>Password</label>
				<form:input path="inputPassword"/>
			</p>
			<input type="SUBMIT" value="LOGIN" name="login"/>
		</div>
	</form:form>
	
	
	<form:form action="${pageContext.request.contextPath}/event"
		method="post" modelAttribute="forgot" id="forgotForm">
		<div class="regLoginBox">
			<p>
				<label>User Id</label>
				<form:input path="forgotUserId" />
			</p>
			<input type="SUBMIT" value="FORGOT" name="forgot" />
		</div>
	</form:form>
	
	<form:form action="${pageContext.request.contextPath}/event"
		method="post"  modelAttribute="register" id="registerForm">
		<div class="regLoginBox">
			<p>
				<label>Nama User</label>
				<form:input path="registerUserName"  />
			</p>
			<p>
				<label>User Id</label>
				<form:input path="registerUserId" />
			</p>
			<p>
				<label>User Email</label>
				<form:input path="registerUserMail" />
			</p>
			<p>
				<label>User Telp.</label>
				<form:input path="registerUserPhone" />
			</p>
			<p>
				<label>Password</label>
				<form:input path="registerUserPassword" />
			</p>
			<p>
				<label>Konfirmasi Password</label>
				<form:input path="confirmUserRegisterPassword" />
			</p>
			<input type="SUBMIT" value="REGISTER" name="register"/>
		</div>
	</form:form>



</body>
</html>