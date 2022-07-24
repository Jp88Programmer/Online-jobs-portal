<%--
  Created by IntelliJ IDEA.
  User: jayendra
  Date: 20-04-2022
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Title</title>
<%@include file="All_Component/all_component.jsp"%>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<%@include file="All_Component/navbar.jsp"%>

	<div id="login-form-wrap" class="login-form-wrap">

		<h1>Sign In</h1>
		<form action="http://localhost:8080/JobPortal2/LoginServlet"
			id="login-form" method="post">
			<p class="para">
				<input class="inputClass" type="text" id="username" name="username"
					placeholder="Username" required><i class="validation"><span></span><span></span></i>
			</p>
			<p class="para">
				<input class="inputClass" type="password" id="password"
					name="password" placeholder="Password" required><i class="validation"><span></span><span></span></i>
			</p>
			<p class="para">
				<input type="submit" id="login" value="Login">
			</p>
		</form>
		<div id="create-account-wrap">
			<p>
				Not a member? <a href="signUp.jsp">Create Account</a>
			<p>
		</div>
		<!--create-account-wrap-->
	</div>
	<!--login-form-wrap-->
	<!-- partial -->

</body>
</html>
