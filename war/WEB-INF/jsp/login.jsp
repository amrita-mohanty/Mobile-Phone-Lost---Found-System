<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="appTitle" /></title>
<link rel="stylesheet" href="css/bootstrap-responsive.css" type="text/css"/>
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" type="text/css"/>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>

<style>
h1 {
	color: #FF8000;
	background: url("Images/icon1.jpeg") no-repeat;
	height: 150px;
}

.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<script type="text/javascript">
	var submitted = 0;

	function formvalidation() {
		
		var form = document.getElementById('loginForm');
		form.submit();
		/*
		var userName = document.getElementById('username').value;
		var password = document.getElementById('password').value;
		
		if ((userName == null || userName == "")
				&& (password == null || password == "")) {
			alert("Please enter the username and password !!!");
			return false;
		} else if (userName == null || userName == "") {
			alert("Please enter the username !!!");
			return false;
		} else if (password == null || password == "") {
			alert("Please enter the password !!!");
			return false;
		}
		else
		{
			
		}
		*/
	}
</script>

</head>
<body>
	<form:form id="loginForm" method="post" commandName="login">
	
	<table width="100%" height="100%" background="Images/wp4.jpeg">
		<tr><td>
		
		<table width="100%" height="100%"  background="Images/wp4.jpeg">
		<tr><td>
		
		<table width="100%" height="60%" background="Images/images23.jpg" cellspacing="0" style="color: black; background-color: #F8F8F8 ;font-size: 60pt"  >
		<tr>
			<td><img src="Images/icon1.jpeg" height="150" width="150"/></td>
			<td  align="center" >
				<b>Mobile</b>
			<img src="Images/images17.jpeg" class="img-circle" />
			</td>
		</tr>
		</table>
	</td></tr>
	<tr><td width="100%" height="100%" >
		<div class="container">
		<table width="70%" align="center" border="0" cellspacing="0" cellpadding="5" style="background-color: #F8F8F8 ;">
			<tr>
				<td align="center" style="color: #0000FF; font-size: 20pt"><b>
					<fmt:message key="login.heading" /></b>
				</td>
			</tr>
			


			<tr>
				<td>
					<table align="center" width="100%"> 
						<tr>
							<td align="right" width="70%">
								<font color="#4682B4"><b>Enter Username	</b></font>
									<font color="red">(*)</font> 
									<form:input path="username" />
							</td>
							<td width="30%">
								<form:errors path="username" cssClass="error" />
							</td>
						</tr>
						<tr>
							<td align="right" width="60%">
								<font color="#4682B4"><b>Enter Password</b></font>
									<font color="red">(*)</font>
									<form:password path="password" />
							</td>
							<td width="40%"><form:errors path="password"
									cssClass="error" /></td>
						</tr>
					</table>
				</td>
			</tr>

			<tr width="100%">
				<td align="center" width="100%">
					<button class="btn btn-primary" type="submit" id="Sign-In">Sign-In</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<c:url value="register.htm"/>">Create new account</a>
				<td>
			</tr>
		</table>
		<br>
		</div>
		</td></tr>
		
		
		</table>
	</form:form>
</body>