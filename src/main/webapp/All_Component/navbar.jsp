<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Job Portal</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Home</a></li>
				<c:if test="${userObj.role eq 'admin'}">
					<li class="nav-item"><a class="nav-link" href="addJobs.jsp">Post Job</a></li>
					<li class="nav-item"><a class="nav-link" href="viewJobs.jsp">View Job</a></li>
				</c:if>
			</ul>


			<form class="form-inline my-3 my-lg-0">

				<c:if test="${ userObj.role eq 'admin' }">
					<a href="login.jsp" class="btn btn-light">Admin</a>
					<a href="http://localhost:8080/JobPortal2/LogoutServlet" class="btn btn-light">Logout</a>
				</c:if>
				
				<c:if test="${ userObj.role eq 'user'  }">
					<a href="#" class="btn btn-light">${userObj.name}</a>
					<a href="http://localhost:8080/JobPortal2/LogoutServlet" class="btn btn-light">Logout</a>
				</c:if>
				
				<c:if test="${ empty userObj }">
					<a href="login.jsp" class="btn btn-light">Sign In</a>
					<a href="signUp.jsp" class="btn btn-light">SignUp</a>
				</c:if>
				
			</form>

		</div>
	</div>
</nav>