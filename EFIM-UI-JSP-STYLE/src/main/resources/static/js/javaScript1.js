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