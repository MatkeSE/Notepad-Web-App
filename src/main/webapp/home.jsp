<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
UserDtls user1 = (UserDtls) session.getAttribute("userD");

if (user1 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login...");
}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>


<div class="container-fluid p-0">
<%@include file="all_component/navbar.jsp"%>
<div class="card py-5">
<div class="card-body text-center">
<img alt="" src="img/images.jpg" class="img-fluid mx-auto" style="width: 350px;">
<h1>START TAKING YOUR NOTES</h1>
<a href="addNotes.jsp" class="btn btn-outline-primary">Start here</a>
</div>
</div>
</div>
<%@include file="all_component/footer.jsp"%>
</body>
</html>