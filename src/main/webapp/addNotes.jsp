<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
UserDtls user2 = (UserDtls) session.getAttribute("userD");

if (user2 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login...");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allcss.jsp"%>

<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid p-0">
		<%@include file="all_component/navbar.jsp"%>

		<h1 class="text-center">Add Your Notes</h1>

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="AddNotesServlet" method="post">
						<div class="form-group">

							<%
							UserDtls us = (UserDtls) session.getAttribute("userD");
							if (us != null) {
							%>
							<input type="hidden" value="<%=us.getId()%>" name="uid">

							<%
							}
							%>


							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								name="title" required="required" aria-describedby="emailHelp">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1"></label>
							<textarea rows="8" cols="" class="form-control"
								placeholder="Start writing..." name="content"
								required="required"></textarea>
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add notes</button>
						</div>

					</form>
				</div>
			</div>
		</div>

	</div>
	<%@include file="all_component/footer.jsp"%>

</body>
</html>