<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
	<%-- <h1>Spring MVC 5 - Spring Security 5 - Hibernate 5</h1>
	<h2>${message}</h2>

	<form name='loginForm'
		action="<c:url value='/admin/j_spring_security_login' />"
		method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input id="username" type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input id="password" type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input id="loginAdmin" name="submit"
					type="submit" value="login" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form> --%>
	<div class="middle-box text-center loginscreen animated fadeInDown">
		<div>
			<div>

				<h1 class="logo-name">IN+</h1>

			</div>
			<h3>Welcome to IN+</h3>
			<p>
				Perfectly designed and precisely prepared admin theme with over 50
				pages with extra new web app views.
				<!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->
			</p>
			<p>Login in. To see it in action.</p>
			<form name="loginForm" class="m-t"
				action="admin/j_spring_security_login" method='POST'>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Username"
						required="" name="username">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password"
						required="" name='password'>
				</div>
				<button type="submit" id="loginAdmin"
					class="btn btn-primary block full-width m-b">Login</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <a href="#"><small>Forgot
						password?</small></a>
			

			</form>
			<p class="m-t">
				<small>Inspinia we app framework base on Bootstrap 3 &copy;
					2014</small>
			</p>
		</div>
	</div>
</body>
</html>