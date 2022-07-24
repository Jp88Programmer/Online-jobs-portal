<%--
  Created by IntelliJ IDEA.
  User: jayendra
  Date: 21-04-2022
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="All_Component/all_component.jsp"%>
    <link rel="stylesheet" href="signUp.css">
</head>
<body>
<%@include file="All_Component/navbar.jsp"%>
<div id="login-form-wrap" class="login-form-wrap">
    <h1>Sign Up</h1>
    <form id="login-form" action="http://localhost:8080/JobPortal2/SignUpServlet" method="post"> 
        <p class="para">
            <input class="inputClass" type="text" id="name" name="name" placeholder="Name" required><i
                class="validation"><span></span><span></span></i>
        </p>
       
        <p class="para">
            <input class="inputClass" type="text" id="username" name="qualification" placeholder="Qualification" required><i
                class="validation"><span></span><span></span></i>
        </p>
        <p class="para">
            <input class="inputClass" type="email" id="email" name="email" placeholder="Email Address" required><i
                class="validation"><span></span><span></span></i>
        </p>

        <p class="para">
            <input class="inputClass" type="password" id="password" name="password" placeholder="password" required><i
                class="validation"><span></span><span></span></i>
        </p>

        <p class="para">
            <input class="inputClass" type="password" id="re-password" name="re-password" placeholder="Confirm Password" required><i
                class="validation"><span></span><span></span></i>
        </p>

        <p class="para">
            <input type="submit" id="login" value="Sign Up">
        </p>
    </form>

    <!--create-account-wrap-->
</div>
<!--login-form-wrap-->
<!-- partial -->

</body>
</html>
