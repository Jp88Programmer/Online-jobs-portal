<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="All_Component/all_component.jsp"%>
<link rel="stylesheet" href="addJobs.css">
</head>
<body>
<c:if test="${ userObj.role ne 'admin' }">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
<%@include file="All_Component/navbar.jsp" %>
    <div class="container my-4">
    	<div class="heading-group">
        <h1><i class="fa-solid fa-users"></i></h1>
        <h2>Add Jobs</h2>
        </div>
        <form action="http://localhost:8080/JobPortal2/AddJob" method="post" class="row g-3 my-4">
            <div class="col-md-11">
                <label for="inputTitle" class="form-label">Enter title</label>
                <input type="text" name="title" class="form-control" id="inputTitle">
            </div>
            <div class="col-md-5">
                <label for="inputCity" class="form-label">Location</label>
                <input type="text" name="location" class="form-control" id="inputCity">
            </div>
            <div class="col-md-3">
                <label for="inputState" class="form-label">Category</label>
                <select id="inputState" name="category" class="form-select">
                    <option selected>Choose...</option>
                    <option value="frontend developer">frontend developer</option>
                    <option value="backend developer">backend developer</option>
                    <option value="fullstack developer">fullstack developer</option>
                    <option value="Data scientist">Data scientist</option>
                </select>
            </div>
            <div class="col-md-2">
                <label for="inputState" class="form-label">Status</label>
                <select id="inputState" name="status" class="form-select">
                    <option selected>Choose...</option>
                    <option value="active">Active</option>
                    <option value="inactive">inactive</option>
                </select>
            </div>
          
            <div class="col-md-11">
               
                <div class="form-floating">
                    <textarea class="form-control" name="description" placeholder="Leave a comment here" id="floatingTextarea" style="height: 200px"></textarea>
                    <label for="floatingTextarea">Enter Description</label>
                </div>
            </div>
            <div class="col-11">
                <button type="submit" class="btn btn-primary" id="btnPublish">Publish Job</button>
            </div>
        </form>
    </div>
   
</body>
</html>