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
	<c:if test="${ userObj.role ne 'admin' }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="All_Component/navbar.jsp"%>
	<div class="container">

		<c:if test="${not empty msg }">
			<div class="alert alert-success my-3" role="alert">${msg}</div>
			<c:remove var="msg" />
		</c:if>

		<h1 class="my-4">All Jobs</h1>
		<%
			App app = new App();
			List listDbData = app.getJobs();

			for (int i = 0; i < listDbData.size(); i++) {
				Jobs j = (Jobs) listDbData.get(i);
		%>

		<div class="card my-4" style="width: 100%;">
			<div class="card-body my-2">
				<h5 class="card-title my-2"><%=j.getTitle()%></h5>

				<p class="card-text"><%=j.getDescription()%></p>
				<div class="my-3">
					<input type="text" class="inputClass" id="inputLoc"
						value="Location : <%=j.getLocation()%>"> <input
						type="text" class="inputClass" id="inputCat"
						value="Catgory : <%=j.getCategory()%>"> <input type="text"
						class="inputClass" id="inputSta"
						value="Status : <%=j.getStatus()%>">
				</div>

				<button type="button" class="btn btn-primary butStyle" id="edit">
					<a href="editJobs.jsp?id=<%=j.getId()%>"
						style="color: #e9ebef; text-decoration: none;"
						onMouseOver="this.style.color='black'"
						onMouseOut="this.style.color='white'">Edit</a>
				</button>
				<button type="button" class="btn btn-primary butStyle" id="delete">
					<a
						href="http://localhost:8080/JobPortal2/DeleteServlet?id=<%=j.getId()%>"
						style="color: #e9ebef; text-decoration: none;"
						onMouseOver="this.style.color='black'"
						onMouseOut="this.style.color='white'">Delete</a>
				</button>
				
			</div>
		</div>

		<%
			}
		%>


	</div>
</body>
</html>