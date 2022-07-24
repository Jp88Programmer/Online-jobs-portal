<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.db.*"%>
<%@ page import="com.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="All_Component/all_component.jsp"%>
<link rel="stylesheet" href="general.css">
</head>
<body>

	<%@include file="All_Component/navbar.jsp"%>
	<div class="container">

		<h1 class="my-4">All Jobs</h1>
		<%
			App app = new App();
			List listDbData = app.getJobsByStatus();

			for (int i = 0; i < listDbData.size(); i++) {
				Jobs j = (Jobs) listDbData.get(i);
		%>

		<div class="card my-4" style="width: 100%;">
			<div class="card-body my-2">
				<h5 class="card-title my-2"><%=j.getTitle()%></h5>
				<div class="my-3">
					<input type="text" class="inputClass" id="inputLoc"
						value="Location : <%=j.getLocation()%>" readonly> <input
						type="text" class="inputClass" id="inputCat"
						value="Catgory : <%=j.getCategory()%>" readonly> <input
						type="text" class="inputClass" id="inputSta"
						value="Status : <%=j.getStatus()%>" readonly>
				</div>
				<%
					if (j.getDescription().length() < 120) {
				%>
				<p class="card-text"><%=j.getDescription()%></p>
				<%
					} else {
				%>
				<p class="card-text"><%=j.getDescription().substring(0, 120)%>...
				</p>
				<%
					}
				%>
				<%--<p>
					<a class="btn btn-primary" data-toggle="collapse"
						href="#collapseExample" role="button" aria-expanded="false"
						aria-controls="collapseExample"> Link with href </a>
					<button class="btn btn-primary" type="button"
						data-toggle="collapse" data-target="#collapseExample"
						aria-expanded="false" aria-controls="collapseExample">
						View More..</button>
				</p>
				<div class="collapse" id="collapseExample">
					<div class="card card-body"><%=j.getDescription()%></div>
				</div> --%>

			</div>
		</div>

		<%
			}
		%>

	
	</div>
	
</body>
</html>