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

table.background {
	background: url("Images/images15.jpeg") no-repeat;

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

</head>
<body>
	<form:form method="post" commandName="register">
	
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
		<table align="center" width="70%" style="background-color: #F8F8F8 ;" border="0" cellspacing="0" cellpadding="5">
  	<tr>
  		<td align="center" style="color: #4682B4; font-size: 20pt"><b>
						<fmt:message key="registrationPage.heading" /></b>
		</td>
		<td valign="top" style="color: #4682B4; font-size:10pt">
			<b><a href="<c:url value="login.htm"/>">Home</a></b>
		</td>
	</tr>
	<tr>	        
	       	<td align="center" style="color:red; font-size: 14pt"><b><u>
						(*) : Are mandatory fields</u></b>
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
						<tr>
							<td align="right" width="60%">
								<font color="#4682B4"><b>Enter IMEI Number</b></font>
									<font color="red">(*)</font>
									<form:input path="imeiNumber" />
							</td>
							<td width="40%"><form:errors path="imeiNumber"
									cssClass="error" /></td>
						</tr>
						<tr>
							<td align="right" width="60%">
								<font color="#4682B4"><b>Enter Email Address</b></font>
									<font color="red">(*)</font> 
									<form:input path="emailAddress" />
							</td>
							<td width="40%"><form:errors path="emailAddress"
									cssClass="error" /></td>
						</tr>
					</table>
				</td>
			</tr>


			<tr>
				<td width="100%" align="center">
				<input type="submit" align="center" class="btn btn-primary" value="Register"></td>
			</tr>
		</table>
		<br>
		</div>
		</td></tr>
		
		
		</table>
	</form:form>
</body>