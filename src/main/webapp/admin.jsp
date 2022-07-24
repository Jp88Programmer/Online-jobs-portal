<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="All_Component/all_component.jsp"%>
<link rel="stylesheet" href="admin.css">
</head>
<body>
	<c:if test="${ userObj.role ne 'admin' }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="All_Component/navbar.jsp"%>

	<div class="adminDiv"></div>
	<div class="container">
		<h1>Welcome To Admin</h1>
	</div>
	</div>
</body>
</html>